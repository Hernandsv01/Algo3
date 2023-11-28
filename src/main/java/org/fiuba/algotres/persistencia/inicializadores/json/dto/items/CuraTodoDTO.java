package org.fiuba.algotres.persistencia.inicializadores.json.dto.items;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.fiuba.algotres.model.item.CuraTodo;
import org.fiuba.algotres.model.item.FactoryItem;
import org.fiuba.algotres.model.item.Item;

@JsonTypeName("curatodo")
public class CuraTodoDTO extends ItemDTO{
    @JsonCreator
    public CuraTodoDTO(@JsonProperty("id") Integer id) {
        super(id);
    }

    @Override
    public Item toItem() {
        Item item = FactoryItem.crearCuraTodo();
        item.setId(getId());
        return item;
    }
}
