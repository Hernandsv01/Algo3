package org.fiuba.algotres.item;

import org.fiuba.algotres.Pokemon;

public class Pocion extends Vida{

    @Override
    public Pokemon Usar(Pokemon pokemon) {
        if ((pokemon.getVidaActual() + cantidadDeVida) > pokemon.getVidaMaxima()) {
            pokemon.setVidaActual(pokemon.getVidaMaxima());
        } else {
            Integer vidaAnterior = pokemon.getVidaActual();
            pokemon.setVidaActual(vidaAnterior + cantidadDeVida);
        }
        cantidad--;
        return pokemon;
    }
}
