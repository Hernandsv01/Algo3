package org.fiuba.algotres.model.item;

import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.estado.Estado;

public class CuraTodo extends Item{
    public CuraTodo(int cantidad, String nombre) {
        super(cantidad, nombre);
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
