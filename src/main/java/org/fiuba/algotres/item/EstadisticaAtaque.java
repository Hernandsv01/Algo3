package org.fiuba.algotres.item;

import org.fiuba.algotres.Pokemon;

public class EstadisticaAtaque extends Estadistica {
    public EstadisticaAtaque(int cantidad, String nombre, int porcentaje) {
        super(cantidad, nombre, porcentaje);
    }

    @Override
    public boolean usar(Pokemon pokemon) {
        if (super.usar(pokemon)) {
            pokemon.modificarAtaque(porcentaje);
            cantidad--;
            return true;
        }
        return false;
    }
}
