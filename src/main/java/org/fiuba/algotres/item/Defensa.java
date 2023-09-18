package org.fiuba.algotres.item;

import org.fiuba.algotres.Pokemon;

public class Defensa extends Estadistica{
    // solo puede ser usado en el pokemon que se encuentre en el campo de batalla
    @Override
    public Pokemon Usar(Pokemon pokemon) {
        Integer defensaAnterior = pokemon.getDefensa();
        pokemon.setAtaque((porcentaje/100) * defensaAnterior + defensaAnterior);
        return pokemon;
    }
}
