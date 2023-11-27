package org.fiuba.algotres.persistencia.inicializadores.json.dto.items;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.fiuba.algotres.model.item.FactoryItem;
import org.fiuba.algotres.model.item.Item;

@JsonTypeName("staquex")
public class AtaqueXDTO extends ItemDTO {
    @JsonCreator
    public AtaqueXDTO(@JsonProperty("id") Integer id) {
        super(id);
    }

    @Override
    public Item toItem() {
        Item item = FactoryItem.crearAtaqueX();
        item.setId(getId());
        return item;
    }
}
