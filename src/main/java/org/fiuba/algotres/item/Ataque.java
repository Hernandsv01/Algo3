package org.fiuba.algotres.item;

import org.fiuba.algotres.Pokemon;

public class Ataque extends Estadistica{
    // solo puede ser usado en el pokemon que se encuentre en el campo de batalla
    @Override
    public Pokemon Usar(Pokemon pokemon) {
        Integer ataqueAnterior = pokemon.getAtaque();
        pokemon.setAtaque((porcentaje/100) * ataqueAnterior + ataqueAnterior);
        return pokemon;
    }
}
