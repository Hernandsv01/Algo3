package org.fiuba.algotres.model.item;

import org.fiuba.algotres.model.Pokemon;

public class Revivir extends Item {
    public Revivir(int cantidad, String nombre) {
        super(cantidad, nombre);
    }

    public Revivir(String nombre, int id) {
        super(nombre, id);
    }

    public Revivir(String nombre) {
        super(nombre);
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
}
