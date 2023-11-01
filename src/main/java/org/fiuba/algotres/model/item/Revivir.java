package org.fiuba.algotres.model.item;

import org.fiuba.algotres.model.Pokemon;

public class Revivir extends ItemAbstracto {
    public Revivir(int cantidad, String nombre) {
        super(cantidad, nombre);
    }

    @Override
    public boolean usar(Pokemon pokemon) {
        if (verificarCantidad(cantidad)) {
            if (!pokemon.estaVivo()) {
                pokemon.revivir();
                cantidad--;
                return true;
            }
        }
        return false;
    }

    @Override
    public int getEficiencia() {
        return 0;
    }
}
