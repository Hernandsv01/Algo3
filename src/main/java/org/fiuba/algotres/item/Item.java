package org.fiuba.algotres.item;

import lombok.Setter;
import org.fiuba.algotres.Pokemon;

@Setter
public abstract class Item {
    protected int cantidad;
    private String nombre;

    public Item(int cantidad, String nombre) {
        this.cantidad = cantidad;
        this.nombre = nombre;
    }

    public abstract boolean usar(Pokemon pokemon);
}
