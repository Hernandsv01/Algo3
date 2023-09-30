package org.fiuba.algotres.item;

import org.fiuba.algotres.Pokemon;

public abstract class Estadistica extends Item {
    protected int porcentaje;

    public Estadistica(int cantidad, String nombre, int porcentaje) {
        super(cantidad, nombre);
        this.porcentaje = porcentaje;
    }

    public boolean usar(Pokemon pokemon) {
        return super.usar(pokemon);
    }
}