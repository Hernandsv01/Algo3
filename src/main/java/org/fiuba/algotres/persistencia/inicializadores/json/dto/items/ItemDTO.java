package org.fiuba.algotres.persistencia.inicializadores.json.dto.items;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.fiuba.algotres.model.item.Item;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Getter @Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "item")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CuraTodoDTO.class, name = "curatodo"),
        @JsonSubTypes.Type(value = AtaqueXDTO.class, name = "ataquex"),
        @JsonSubTypes.Type(value = DefensaXDTO.class, name = "defensax"),
        @JsonSubTypes.Type(value = PocionDTO.class, name = "pocion"),
        @JsonSubTypes.Type(value = MegaPocionDTO.class, name = "megapocion"),
        @JsonSubTypes.Type(value = HiperPocionDTO.class, name = "hiperpocion"),
        @JsonSubTypes.Type(value = PocionMolestaAlumnosDTO.class, name = "pocionmolestaalumnos"),
        @JsonSubTypes.Type(value = RevivirDTO.class, name = "revivir")
})
public abstract class ItemDTO {

    private Integer id;

    @JsonCreator
    public ItemDTO(@JsonProperty ("id") Integer id) {
        this.id = id;
    }

    public static List<ItemDTO> loadItemsJson(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(path);
        return mapper.readValue(file, new TypeReference<>() {});
    }

    public abstract Item toItem();

}
