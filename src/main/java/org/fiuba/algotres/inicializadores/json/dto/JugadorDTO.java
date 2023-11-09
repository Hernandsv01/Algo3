package org.fiuba.algotres.inicializadores.json.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.fiuba.algotres.model.Jugador;
import org.fiuba.algotres.model.Pokemon;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
public class JugadorDTO {
    private String nombre;
    private HashMap<Integer, Integer> itemIDs;
    private List<Integer> pokemonIDs;

    @JsonCreator
    public JugadorDTO(@JsonProperty("nombre") String nombre, @JsonProperty("items") HashMap<Integer, Integer> itemIDs, @JsonProperty("pokemons") List<Integer> pokemonIDs) {
        this.nombre = nombre;
        this.itemIDs = itemIDs;
        this.pokemonIDs = pokemonIDs;
    }

    public static List<JugadorDTO> loadJugadoresJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File pathALeer = new File("src\\main\\resources\\partida.json");
        return mapper.readValue(pathALeer , new TypeReference<>() {
        });
    }

    public static List<Jugador> getJugadores() {
       /*
       1) Cargar todo
       2) Crear versión posta de objetos
            a) items y habilidades
            b) Pokemons (se le mete habilidades)
            c) Jugadores (se les mete pokemons e items)

        QUE HAYA UN INICIALIZADOR GENERAL CON MAPEOS, QUE ESTAS CLASES NO GENEREN EL RESTO DE OBJETOS
        */

        ArrayList<Jugador> jugadores = new ArrayList<>();
        List<JugadorDTO> jugadoresDTO;
        List<PokemonDTO> pokemonsDTO;
        List<HabilidadDTO> habilidadesDTO;
        List<ItemDTO> itemsDTO;
        try {
            jugadoresDTO = loadJugadoresJson();
//            pokemonsDTO = loadPokemonsJson();
//            habilidadesDTO = loadHabilidadesJson();
//            itemsDTO = loadItemsJson();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        // Jugadores
        for (int i = 0; i < jugadoresDTO.size(); i++){
            JugadorDTO jugadorDTO = jugadoresDTO.get(i);
//            jugadores.add(new Jugador(
//                    pokemonsDTO.stream().filter(pokemonDTO -> jugadorDTO.getPokemonIDs().contains(pokemonDTO.getId())).map(pokemonDTO -> /*to pokemon*/).collect(Collectors.toList()),
//                    itemsDTO.stream().filter(itemDTO -> jugadorDTO.getItemIDs().containsKey(itemDTO.getId()))
//            ));
        }
    }
}
