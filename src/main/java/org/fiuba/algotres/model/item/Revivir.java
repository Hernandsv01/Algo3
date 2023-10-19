package org.fiuba.algotres.model.item;

import org.fiuba.algotres.model.Pokemon;

public class Revivir extends Item {
    public Revivir(int cantidad, String nombre) {
        super(cantidad, nombre);
    }

    @Override
    public boolean usar(Pokemon pokemon) {
        if (super.usar(pokemon)) {
            if (pokemon.getVidaActual() == 0) {
                pokemon.revivir();
                cantidad--;
                return true;
            }
        }
        return false;
    }
}
