package org.fiuba.algotres.item;

import org.fiuba.algotres.Pokemon;

public class Revivir extends Vida{
    // solo puede ser usado en el pokemon que se encuentre muerto

    public Revivir(int cantidad, String nombre, int cantidadDeVida) {
        super(cantidad, nombre, cantidadDeVida);
    }

    @Override
    public boolean usar(Pokemon pokemon) {
        if (cantidad <= 0) {
            return false;
        }
        if (pokemon.getVidaActual() == 0) {
            pokemon.setVidaActual(pokemon.getVidaMaxima());
            cantidad--;
            return true;
        }
        return false;
    }
}
