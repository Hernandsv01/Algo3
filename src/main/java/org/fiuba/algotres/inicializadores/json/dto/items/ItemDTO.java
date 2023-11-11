package org.fiuba.algotres.inicializadores.json.dto.items;

import java.io.File;
import java.io.IOException;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;
import org.fiuba.algotres.model.item.*;

@Getter @Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "tipo")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CuraTodoDTO.class, name = "curatodo"),
        @JsonSubTypes.Type(value = EstadisticaDTO.class, name = "estadistica"),
        @JsonSubTypes.Type(value = PocionDTO.class, name = "pocion"),
        @JsonSubTypes.Type(value = PocionMolestaAlumnosDTO.class, name = "pocionmolestaalumnos"),
        @JsonSubTypes.Type(value = RevivirDTO.class, name = "revivir")
})
public abstract class ItemDTO {

    private Integer id;
    private String nombre;
    private Integer cantidad;

    @JsonCreator
    public ItemDTO(@JsonProperty ("id") Integer id, @JsonProperty("nombre") String nombre, @JsonProperty ("cantidad") Integer cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public static List<ItemDTO> loadItemsJson(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(path);
        return mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, Item.class));
    }

    public Item toItem(){
        return null;
    }

}
