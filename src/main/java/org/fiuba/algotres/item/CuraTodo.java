package org.fiuba.algotres.item;

import org.fiuba.algotres.Pokemon;

public class CuraTodo extends Item{
    public CuraTodo(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public void usar(Pokemon pokemon) {
        if (pokemon.getEstado() != null) {
            pokemon.setEstado(null);
            cantidad--;
        }
    }
}
