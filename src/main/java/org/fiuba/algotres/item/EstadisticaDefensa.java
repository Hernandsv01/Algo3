package org.fiuba.algotres.item;

import org.fiuba.algotres.Pokemon;

public class EstadisticaDefensa extends Estadistica {
    public EstadisticaDefensa(int cantidad, String nombre, int porcentaje) {
        super(cantidad, nombre, porcentaje);
    }

    @Override
    public boolean usar(Pokemon pokemon) {
        if (super.usar(pokemon)) {
            int defensaAnterior = pokemon.getDefensa();
            pokemon.setDefensa((Math.round( (float) (porcentaje / 100) * defensaAnterior)) + defensaAnterior);
            cantidad--;
            return true;
        }
        return false;
    }
}
