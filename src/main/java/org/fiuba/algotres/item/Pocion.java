package org.fiuba.algotres.item;

import org.fiuba.algotres.Pokemon;

public class Pocion extends Item{
    protected int cantidadDeVida;

    public Pocion(int cantidad, String nombre, int cantidadDeVida) {
        super(cantidad, nombre);
        this.cantidadDeVida = cantidadDeVida;
    }

    @Override
    public boolean usar(Pokemon pokemon) {
        if (super.usar(pokemon)) {
            pokemon.setVidaActual(pokemon.getVidaActual() + cantidadDeVida);
            cantidad--;
            return true;
        }
        return false;
    }
}
