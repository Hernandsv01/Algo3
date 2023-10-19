package org.fiuba.algotres.model.item;

import org.fiuba.algotres.model.Pokemon;

public class EstadisticaDefensa extends Estadistica {
    public EstadisticaDefensa(int cantidad, String nombre, int porcentaje) {
        super(cantidad, nombre, porcentaje);
    }

    @Override
    public boolean usar(Pokemon pokemon) {
        if (super.usar(pokemon)) {
            pokemon.modificarDefensa(porcentaje);
            cantidad--;
            return true;
        }
        return false;
    }
}
