package org.fiuba.algotres.model.item;

import org.fiuba.algotres.model.Pokemon;

public class MegaPocion extends ItemAbstracto {
    private final int CANTIDADDEVIDA = 50;

    public MegaPocion(int cantidad, String nombre) {
        super(cantidad, nombre);
    }

    @Override
    public boolean usar(Pokemon pokemon) {
        if (verificarCantidad(cantidad)) {
            pokemon.curarPorPuntos(CANTIDADDEVIDA);
            cantidad--;
            return true;
        }
        return false;
    }

    public int getEficiencia() {
        return CANTIDADDEVIDA;
    }
}
