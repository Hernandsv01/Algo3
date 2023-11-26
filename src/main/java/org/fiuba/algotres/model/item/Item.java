package org.fiuba.algotres.model.item;

import lombok.Getter;
import lombok.Setter;
import org.fiuba.algotres.model.Pokemon;

@Setter @Getter
public abstract class Item{
    private int id;
    private final String nombre;
    protected int cantidad;


    public Item(int id, int cantidad, String nombre) {
        this.id = id;
        this.cantidad = cantidad;
        this.nombre = nombre;
    }
    public Item(int cantidad, String nombre) {
        this.cantidad = cantidad;
        this.nombre = nombre;
    }
    public Item(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }
    public Item(String nombre) {
        this.nombre = nombre;
    }

    public abstract boolean usar(Pokemon pokemon);

    boolean verificarCantidad(int cantidad) {
        return cantidad > 0;
    }
}
