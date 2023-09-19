package org.fiuba.algotres.item;

import org.fiuba.algotres.Pokemon;

public class CuraTodo extends Item{
    public Pokemon CuraTodo(Pokemon pokemon) {
        if (pokemon.getEstado() != null) {
            pokemon.setEstado(null);
            cantidad--;
        }
        return pokemon;
    }
}
