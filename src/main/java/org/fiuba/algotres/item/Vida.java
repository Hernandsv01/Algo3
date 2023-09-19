package org.fiuba.algotres.item;

public abstract class Vida extends Item{
    protected int cantidadDeVida;

    public Vida(int cantidad, String nombre, int cantidadDeVida) {
        super(cantidad, nombre);
        this.cantidadDeVida = cantidadDeVida;
    }
}
