package org.fiuba.algotres.item;

public abstract class Estadistica extends Item{
    protected int porcentaje;
    // si es 10%, tenemos que poner 10

    public Estadistica(int cantidad, String nombre, int porcentaje) {
        super(cantidad, nombre);
        this.porcentaje = porcentaje;
    }
}
