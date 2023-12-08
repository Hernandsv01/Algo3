package org.fiuba.algotres.model.item;

import org.fiuba.algotres.model.Pokemon;

public class CuraTodo extends Item {

    public CuraTodo(String nombre, int id) {
        super(nombre, id);
    }

    public CuraTodo(int cantidad, String nombre) {
        super(cantidad, nombre);
    }

    public CuraTodo(String nombre) {
        super(nombre);
    }

    @Override
    public boolean usar(Pokemon pokemon) {
        if (verificarCantidad(cantidad)) {
            if (!pokemon.getEstados().isEmpty()) {
                pokemon.getEstados().removeAll(pokemon.getEstados());
                cantidad--;
                return true;
            }
        }
        return false;
    }
}
