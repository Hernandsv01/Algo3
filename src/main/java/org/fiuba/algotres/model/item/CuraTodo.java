package org.fiuba.algotres.model.item;

import org.fiuba.algotres.model.Pokemon;

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
