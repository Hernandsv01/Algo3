package org.fiuba.algotres.item;

import org.fiuba.algotres.Pokemon;

public class Revivir extends Item {
    public Revivir(int cantidad, String nombre) {
        super(cantidad, nombre);
    }

    @Override
    public boolean usar(Pokemon pokemon) {
        if (super.usar(pokemon)) {
            if (pokemon.getVidaActual() == 0) {
                pokemon.curar();
                cantidad--;
                return true;
            }
        }
        return false;
    }
}
