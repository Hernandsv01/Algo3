package org.fiuba.algotres.model.item;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public abstract class ItemAbstracto implements Item{
    protected int cantidad;
    private final String nombre;

    public ItemAbstracto(int cantidad, String nombre) {
        this.cantidad = cantidad;
        this.nombre = nombre;
    }
    boolean verificarCantidad(int cantidad) {
        return cantidad > 0;
    }
}
