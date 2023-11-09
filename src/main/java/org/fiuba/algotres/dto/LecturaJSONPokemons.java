package org.fiuba.algotres.dto;

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
public class LecturaJSONPokemons {
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
    public LecturaJSONPokemons(@JsonProperty ("id") Integer id, @JsonProperty("nombre") String nombre,@JsonProperty ("nivel") Integer nivel,@JsonProperty ("tipo") Tipos tipo,@JsonProperty ("historia") String historia,@JsonProperty ("vidaMaxima") Integer vidaMaxima,@JsonProperty ("velocidad") Integer velocidad,@JsonProperty ("defensa") Integer defensa,@JsonProperty ("ataque") Integer ataque,@JsonProperty ("habilidades") List<Integer> habilidades) {
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

    public static List<LecturaJSONPokemons> leecturadearchivos() throws StreamReadException, DatabindException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        File pathLeer = new File("src\\main\\resources\\pokemons.json");

        List<LecturaJSONPokemons> a = mapper.readValue(pathLeer, new TypeReference<List<LecturaJSONPokemons>>(){});

        return a;

       //for(int i = 0; i< a.size(); i++){
       //    System.out.println("ID " + a.get(i).getId());
       //    System.out.println("NOMBRE " + a.get(i).getNombre());
       //    System.out.println( "nivel " +a.get(i).getNivel());
       //    System.out.println("tipo " +a.get(i).getTipo());
       //    System.out.println( "historia " +a.get(i).getHistoria());
       //    System.out.println("vida maxima " +a.get(i).getVidaMaxima());
       //    System.out.println("velocidad " +a.get(i).getVelocidad());
       //    System.out.println("defensa " +a.get(i).getDefensa());
       //    System.out.println("ataque " +a.get(i).getAtaque());
       //    System.out.println("habilidades " +a.get(i).getHabilidades());
       //    System.out.println("****");
       //
        
    }


        public static void main(String[] args) throws IOException, FileNotFoundException, InvalidDefinitionException, JsonParseException {
            LecturaJSONPokemons.leecturadearchivos();
    }
}
