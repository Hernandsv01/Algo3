package org.fiuba.algotres.model.item;

import org.fiuba.algotres.model.Pokemon;

public class PocionMolestaAlumnos extends ItemAbstracto {
    private final int PORCENTAJEDEVIDA = 33;
    public PocionMolestaAlumnos(int cantidad, String nombre) {
        super(cantidad, nombre);
    }

    @Override
    public boolean usar(Pokemon pokemon) {
        if (verificarCantidad(cantidad)) {
            pokemon.curarPorPorcentaje(PORCENTAJEDEVIDA);
            cantidad--;
            return true;
        }
        return false;
    }
    public int getEficiencia() {
        return PORCENTAJEDEVIDA;
    }
}
