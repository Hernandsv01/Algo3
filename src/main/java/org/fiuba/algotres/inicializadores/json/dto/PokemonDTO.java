package org.fiuba.algotres.inicializadores.json.dto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.fiuba.algotres.model.tipos.Tipos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PokemonDTO {
    private Integer id;
    private String nombre;
    private Integer nivel;
    private Tipos tipo;
    private String historia;
    private Integer vidaMaxima;
    private Integer velocidad;
    private Integer defensa;
    private Integer ataque;
    private List<Integer> habilidades;

    @JsonCreator
    public PokemonDTO(@JsonProperty ("id") Integer id, @JsonProperty("nombre") String nombre, @JsonProperty ("nivel") Integer nivel, @JsonProperty ("tipo") Tipos tipo, @JsonProperty ("historia") String historia, @JsonProperty ("vidaMaxima") Integer vidaMaxima, @JsonProperty ("velocidad") Integer velocidad, @JsonProperty ("defensa") Integer defensa, @JsonProperty ("ataque") Integer ataque, @JsonProperty ("habilidades") List<Integer> habilidades) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
        this.tipo = tipo;
        this.historia = historia;
        this.vidaMaxima = vidaMaxima;
        this.velocidad = velocidad;
        this.defensa = defensa;
        this.ataque = ataque;
        this.habilidades = habilidades;
    }

    public static List<PokemonDTO> leecturadearchivos() throws StreamReadException, DatabindException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        File pathLeer = new File("src\\main\\resources\\pokemons.json");

        List<PokemonDTO> a = mapper.readValue(pathLeer, new TypeReference<List<PokemonDTO>>(){});

        return a;
    }
}
