package org.fiuba.algotres.model.item;

import org.fiuba.algotres.model.Pokemon;

public class HiperPocion extends ItemAbstracto {
    private final int CANTIDADDEVIDA = 100;

    public HiperPocion(int cantidad, String nombre) {
        super(cantidad, nombre);
        if (cantidad > 1) {
            this.cantidad = 1;
        }
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
