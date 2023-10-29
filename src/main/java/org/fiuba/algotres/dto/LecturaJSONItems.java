package org.fiuba.algotres.dto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LecturaJSONItems {

    private Integer id;
    private String nombre;
    private Integer cantidad;
    private Integer cantidadDeVida;
    private Integer estadisticaDefensa;
    private Integer estadisticaAtaque;
    private boolean curaTodo;
    private boolean revivir;

    @JsonCreator
    public LecturaJSONItems(@JsonProperty ("id") Integer id, @JsonProperty("nombre") String nombre,@JsonProperty ("cantidad") Integer cantidad,@JsonProperty ("cantidadVida") Integer cantidadDeVida,@JsonProperty ("estadisticaDefensa") Integer estadisticaDefensa,@JsonProperty("estadisticaAtaque") Integer estadisticaAtaque,@JsonProperty ("curaTodo") boolean curaTodo, @JsonProperty ("revivir") boolean revivir) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.cantidadDeVida = cantidadDeVida;
        this.estadisticaDefensa = estadisticaDefensa;
        this.estadisticaAtaque = estadisticaAtaque;
        this.curaTodo = curaTodo;
        this.revivir = revivir;
    }

    public static List<LecturaJSONItems> leecturaDeArchivo() throws IOException, FileNotFoundException, InvalidDefinitionException, JsonParseException {
        ObjectMapper mapper = new ObjectMapper();
        File pathLeer = new File("src\\main\\java\\org\\fiuba\\algotres\\items.json");


       List<LecturaJSONItems> a = mapper.readValue(pathLeer, new TypeReference<List<LecturaJSONItems>>(){});
        //for(int i = 0; i< a.size(); i++){
        //    System.out.println("ID " + a.get(i).getId());
        //    System.out.println("NOMBRE " + a.get(i).getNombre());
        //    System.out.println( "cantidad " +a.get(i).getCantidad());
        //    System.out.println("cant vida " +a.get(i).getCantidadDeVida());
        //    System.out.println("estat def " +a.get(i).getEstadisticaDefensa());
        //    System.out.println("estat ataq " +a.get(i).getEstadisticaAtaque());
        //    System.out.println("todo " +a.get(i).isCuraTodo());
        //    System.out.println("****");
        //}
        return a;
    }

}
