package org.fiuba.algotres.persistencia.inicializadores.json.dto.items;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.fiuba.algotres.model.item.Item;
import org.fiuba.algotres.model.item.Pocion;

@JsonTypeName("pocion")
public class PocionDTO extends ItemDTO {
    private final int cantidadDeVida;

    @JsonCreator
    public PocionDTO(@JsonProperty("id") Integer id, @JsonProperty("nombre") String nombre, @JsonProperty("cantidadDeVida") int cantidadDeVida) {
        super(id, nombre);
        this.cantidadDeVida = cantidadDeVida;
    }

    @Override
    public Item toItem() {
        return new Pocion(getNombre(), cantidadDeVida, getId());
    }
}
