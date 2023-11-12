package org.fiuba.algotres.persistencia.inicializadores.json.dto.items;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.fiuba.algotres.model.item.CuraTodo;
import org.fiuba.algotres.model.item.Item;

@JsonTypeName("curatodo")
public class CuraTodoDTO extends ItemDTO{

    @JsonCreator
    public CuraTodoDTO(@JsonProperty("id") Integer id, @JsonProperty("nombre") String nombre) {
        super(id, nombre);
    }

    @Override
    public Item toItem() {
        return new CuraTodo(getNombre(), getId());
    }
}
