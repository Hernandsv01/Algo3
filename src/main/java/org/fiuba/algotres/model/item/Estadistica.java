package org.fiuba.algotres.model.item;

public abstract class Estadistica extends Item {
    protected int porcentaje;

    public Estadistica(int cantidad, String nombre, int porcentaje) {
        super(cantidad, nombre);
        this.porcentaje = porcentaje;
    }
}