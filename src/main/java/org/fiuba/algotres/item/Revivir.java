package org.fiuba.algotres.item;

import org.fiuba.algotres.Pokemon;

public class Revivir extends Vida{
    // solo puede ser usado en el pokemon que se encuentre muerto
    public Revivir(Integer cantidad) {
        this.cantidad = cantidad;
    }
    @Override
    public Pokemon Usar(Pokemon pokemon) {
        if (pokemon.getVidaActual() == 0) {
            pokemon.setVidaActual(pokemon.getVidaMaxima());
            cantidad--;
        }
        return pokemon;
    }
}
