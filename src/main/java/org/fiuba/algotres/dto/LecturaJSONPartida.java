package org.fiuba.algotres.dto;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LecturaJSONPartida {
    private String nombre;
    private HashMap<String, Integer> items;
    private List<Integer> pokemons;

    @JsonCreator
    public LecturaJSONPartida(@JsonProperty ("nombre") String nombre,@JsonProperty ("items") HashMap<String, Integer> items,@JsonProperty ("pokemons") List<Integer> pokemons) {
        this.nombre = nombre;
        this.items = items;
        this.pokemons = pokemons;
    }

    public static List<LecturaJSONPartida> leecturaDeArchivo() throws StreamReadException, DatabindException, IOException {
        ObjectMapper  mapper = new ObjectMapper();
        File pathALeer = new File("src\\main\\java\\org\\fiuba\\algotres\\partida.json");
        List<LecturaJSONPartida> a = mapper.readValue(pathALeer , new TypeReference<List<LecturaJSONPartida>>(){});
        return a;
    }

    //public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
    //    leecturaDeArchivo();
    //}
}
