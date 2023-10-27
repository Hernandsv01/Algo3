package org.fiuba.algotres.dto;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;

import lombok.Getter;
import lombok.Setter;

import java.io.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import org.fiuba.algotres.model.estado.Estado;
import org.fiuba.algotres.model.tipos.Tipos;


@Getter @Setter @JsonInclude(JsonInclude.Include.NON_NULL)
public class LecturaJSONHabilidades {

    private Integer id;
    private String nombre;
    private Integer usos;
    private Integer poder;
    private Tipos tipo;
    private Integer porcentajeDefensa;
    private Integer porcentajeAtaque;
    private Integer porcentajeVida;
    private String estado;
    private String clima;

    @JsonCreator
    public LecturaJSONHabilidades(@JsonProperty ("id") Integer id, @JsonProperty("nombre") String nombre, @JsonProperty("usos")Integer usos,@JsonProperty("poder") Integer poder, @JsonProperty("tipo") Tipos tipo, @JsonProperty("porcentajeDefensa") Integer porcentajeDefensa,@JsonProperty("porcentajeAtaque") Integer porcentajeAtaque,@JsonProperty("porcentajeVida") Integer porcentajeVida, @JsonProperty("nombreEstado") String estado, @JsonProperty("clima") String clima) {
        this.id = id;
        this.nombre = nombre;
        this.usos = usos;
        this.poder = poder;
        this.tipo = tipo;
        this.porcentajeDefensa = porcentajeDefensa;
        this.porcentajeAtaque = porcentajeAtaque;
        this.porcentajeVida = porcentajeVida;
        this.estado = estado;
        this.clima = clima;
    }
    
    public static List<LecturaJSONHabilidades> leecturadearchivos() throws IOException, FileNotFoundException, InvalidDefinitionException, JsonParseException {
        ObjectMapper mapper = new ObjectMapper();
        File pathLeer = new File("src\\main\\java\\org\\fiuba\\algotres\\habilidades.json");

       List<LecturaJSONHabilidades> a = mapper.readValue(pathLeer, new TypeReference<List<LecturaJSONHabilidades>>(){});
       return a;
        
        
    }
    
}
