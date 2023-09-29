package org.fiuba.algotres.item;

import org.fiuba.algotres.Pokemon;

public class Defensa extends Estadistica {
    public Defensa(int cantidad, String nombre, int porcentaje) {
        super(cantidad, nombre, porcentaje);
    }

    @Override
    public boolean accionar(Pokemon pokemon, Pokemon ignorado) {
        if (super.accionar(pokemon, ignorado)) {
            int defensaAnterior = pokemon.getDefensa();
            pokemon.setDefensa((Math.round( (float) (porcentaje / 100) * defensaAnterior)) + defensaAnterior);
            cantidad--;
            return true;
        }
        return false;
    }
}
