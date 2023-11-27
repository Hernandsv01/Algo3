package org.fiuba.algotres.persistencia.inicializadores.json.dto.items;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.fiuba.algotres.model.item.FactoryItem;
import org.fiuba.algotres.model.item.Item;

@JsonTypeName("defensax")
public class DefensaXDTO extends ItemDTO {

    @JsonCreator
    public DefensaXDTO(@JsonProperty("id") Integer id) {
        super(id);
    }

    @Override
    public Item toItem() {
        Item item = FactoryItem.crearDefensaX();
        item.setId(getId());
        return item;
    }
}
