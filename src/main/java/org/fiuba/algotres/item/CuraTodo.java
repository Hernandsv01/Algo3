package org.fiuba.algotres.item;

import org.fiuba.algotres.Pokemon;

public class CuraTodo extends Item{
    public CuraTodo(int cantidad, String nombre) {
        super(cantidad, nombre);
    }

    @Override
    public boolean usar(Pokemon pokemon) {
        if (super.usar(pokemon)) {
            if (pokemon.getEstado() != null) {
                pokemon.setEstado(null);
                cantidad--;
                return true;
            }
        }
        return false;
    }
}
