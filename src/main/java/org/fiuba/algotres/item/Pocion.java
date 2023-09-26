package org.fiuba.algotres.item;

import org.fiuba.algotres.Pokemon;

public class Pocion extends Item{
    //Pocion (cura 20), Mega Pocion (cura 50) e Hiper Pocion (cura 100)
    protected int cantidadDeVida;

    public Pocion(int cantidad, String nombre, int cantidadDeVida) {
        super(cantidad, nombre);
        this.cantidadDeVida = cantidadDeVida;
    }

    @Override
    public boolean usar(Pokemon pokemon) {
        if (cantidad <= 0) {
            return false;
        }
        pokemon.setVidaActual(pokemon.getVidaActual() + cantidadDeVida);
        cantidad--;
        return true;
    }
}
