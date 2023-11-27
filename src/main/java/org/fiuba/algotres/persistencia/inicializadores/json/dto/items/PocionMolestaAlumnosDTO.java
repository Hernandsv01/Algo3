package org.fiuba.algotres.persistencia.inicializadores.json.dto.items;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.fiuba.algotres.model.item.FactoryItem;
import org.fiuba.algotres.model.item.Item;
import org.fiuba.algotres.model.item.PocionMolestaAlumnos;

@JsonTypeName("pocionmolestaalumnos")
public class PocionMolestaAlumnosDTO extends ItemDTO {
    @JsonCreator
    public PocionMolestaAlumnosDTO(@JsonProperty("id") Integer id) {
        super(id);
    }

    @Override
    public Item toItem() {
        Item item = FactoryItem.crearPocionMolestaAlumnos();
        item.setId(getId());
        return item;
    }
}
