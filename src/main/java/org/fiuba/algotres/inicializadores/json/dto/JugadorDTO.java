package org.fiuba.algotres.inicializadores.json.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.fiuba.algotres.model.Jugador;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.item.Item;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
public class JugadorDTO {
    private String nombre;
    private HashMap<String, Integer> itemIDs;
    private List<Integer> pokemonIDs;

    @JsonCreator
    public JugadorDTO(@JsonProperty("nombre") String nombre, @JsonProperty("items") HashMap<String, Integer> itemIDs, @JsonProperty("pokemons") List<Integer> pokemonIDs) {
        this.nombre = nombre;
        this.itemIDs = itemIDs;
        this.pokemonIDs = pokemonIDs;
    }

    public static List<JugadorDTO> loadJugadoresJson(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(path);
        return mapper.readValue(file , new TypeReference<>(){});
    }

    public Jugador toJugador(){
        return new Jugador(
            null,
            null,
            nombre
        );
    }

    public Jugador toJugador(List<Pokemon> pokemons, List<Item> items){
        return new Jugador(
                pokemons,
                items,
                nombre
        );
    }
}
