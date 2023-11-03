package org.fiuba.algotres.model.item;

import lombok.Getter;
import lombok.Setter;
import org.fiuba.algotres.model.Pokemon;

@Setter @Getter
public abstract class Item{
    protected int cantidad;
    private final String nombre;

    public Item(int cantidad, String nombre) {
        this.cantidad = cantidad;
        this.nombre = nombre;
    }

    public abstract boolean usar(Pokemon pokemon);

    boolean verificarCantidad(int cantidad) {
        return cantidad > 0;
    }
}
