package org.fiuba.algotres.persistencia.inicializadores.json;

import org.fiuba.algotres.utils.RandomizadorCustom;
import org.fiuba.algotres.model.Randomizador;
import org.fiuba.algotres.model.habilidad.CambiarClima;
import org.fiuba.algotres.persistencia.inicializadores.json.dto.Utils;
import org.fiuba.algotres.persistencia.inicializadores.json.dto.habilidades.HabilidadDTO;
import org.fiuba.algotres.persistencia.inicializadores.json.dto.items.ItemDTO;
import org.fiuba.algotres.persistencia.inicializadores.json.dto.JugadorDTO;
import org.fiuba.algotres.persistencia.inicializadores.json.dto.PokemonDTO;
import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.Jugador;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.clima.*;
import org.fiuba.algotres.model.habilidad.Habilidad;
import org.fiuba.algotres.model.item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.fiuba.algotres.persistencia.inicializadores.json.dto.items.ItemDTO.loadItemsJson;
import static org.fiuba.algotres.persistencia.inicializadores.json.dto.JugadorDTO.loadJugadoresJson;

public class JSONInitializer {
    private static final String JUGADORES_PATH = "src\\main\\resources\\json\\partida.json";
    private static final String ITEMS_PATH = "src\\main\\resources\\json\\items.json";
    private static final String HABILIDADES_PATH = "src\\main\\resources\\json\\habilidades.json";
    private static final String POKEMONS_PATH = "src\\main\\resources\\json\\pokemons.json";

    private static final Randomizador randomizador = new RandomizadorCustom();

    public static CampoDeBatalla loadCampoDeBatalla(){
        List<JugadorDTO> jugadoresDTO;
        List<PokemonDTO> pokemonsDTO;
        List<HabilidadDTO> habilidadesDTO;
        List<ItemDTO> itemsDTO;
        try {
            jugadoresDTO = loadJugadoresJson(JUGADORES_PATH);
            pokemonsDTO = PokemonDTO.loadPokemonsJson(POKEMONS_PATH);
            habilidadesDTO = HabilidadDTO.loadHabilidadesJson(HABILIDADES_PATH);
            itemsDTO = loadItemsJson(ITEMS_PATH);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


        List<Habilidad> habilidades = habilidadesDTO.stream().map(HabilidadDTO::toHabilidad).collect(Collectors.toCollection(ArrayList::new));
        List<Item> items = itemsDTO.stream().map(ItemDTO::toItem).collect(Collectors.toCollection(ArrayList::new));


        // Mapeamos las habilidades que le corresponden a cada pokemon
        List<Pokemon> pokemons = pokemonsDTO.stream().map(
            pokemonDTO -> pokemonDTO.toPokemon(
                habilidades.stream().filter(
                    habilidad -> pokemonDTO.getHabilidades().contains(habilidad.getId())
                ).collect(Collectors.toCollection(ArrayList::new))
            )
        ).collect(Collectors.toCollection(ArrayList::new));

        // Mapeamos los pokemons e items que le corresponden a cada jugador
        Jugador[] jugadores = jugadoresDTO.stream().map(
            jugadorDTO -> jugadorDTO.toJugador(
                pokemons.stream().filter(pokemon -> jugadorDTO.getPokemonIDs().contains(pokemon.getId())).collect(Collectors.toCollection(ArrayList::new)),
                items.stream().filter(item -> jugadorDTO.getItemIDs().containsKey("" + item.getId())).collect(Collectors.toCollection(ArrayList::new))
            )
        ).toArray(Jugador[]::new);

        // Setteamos la cantidad a cada item (verificando que no haya mas de una HiperPocion por jugador)
        IntStream.range(0, jugadores.length).forEach(
                i ->jugadores[i].getItems().forEach(
                        item -> {
                            int cantidad = jugadoresDTO.get(i).getItemIDs().get("" + item.getId());
                            if(item.getNombre().equals("Hiper Pocion") && cantidad > 1){
                                item.setCantidad(1);
                            }else{
                                item.setCantidad(cantidad);
                            }
                        }
                )
        );

        CampoDeBatalla cdb = new CampoDeBatalla();
        cdb.setJugadores(jugadores);
        cdb.setClima(getRandomClima());
        setMissingAttributes(cdb);
        return cdb;
    }

    private static void setMissingAttributes(CampoDeBatalla cdb) {
        for (Jugador jugador : cdb.getJugadores()) {
            for (Pokemon pokemon : jugador.getPokemons()) {
                pokemon.getHabilidades().stream()
                        .filter(habilidad -> habilidad instanceof CambiarClima)
                        .forEach(habilidad -> ((CambiarClima) habilidad).getClima().setCdb(cdb));
            }
        }
    }

    private static Clima getRandomClima(){
        String[] nombresclimas = new String[]{"Huracan", "Lluvia", "Niebla", "Soleado", "TormentaArena", "TormentaRayos"};
        randomizador.getRandomValue(0, 3);
        int res = (int) randomizador.getRandomValue(0, 3);
        if(res < 2){
            return Utils.getClima("SinClima");
        }else{
            return Utils.getClima(nombresclimas[(int) (Math.random()*nombresclimas.length)]);
        }
    }
}
