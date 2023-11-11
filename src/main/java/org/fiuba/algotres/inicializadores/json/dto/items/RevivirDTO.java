package org.fiuba.algotres.inicializadores.json.dto.items;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.fiuba.algotres.model.item.Item;
import org.fiuba.algotres.model.item.Revivir;

@JsonTypeName("revivir")
public class RevivirDTO extends ItemDTO {

    @JsonCreator
    public RevivirDTO(@JsonProperty("id") Integer id, @JsonProperty("nombre") String nombre) {
        super(id, nombre);
    }

    @Override
    public Item toItem() {
        return new Revivir(getNombre(), getId());
    }
}
