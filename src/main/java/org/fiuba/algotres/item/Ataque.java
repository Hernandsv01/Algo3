package org.fiuba.algotres.item;

import org.fiuba.algotres.Pokemon;

public class Ataque extends Estadistica {
    public Ataque(int cantidad, String nombre, int porcentaje) {
        super(cantidad, nombre, porcentaje);
    }

    @Override
    public boolean usar(Pokemon pokemon) {
        if (super.usar(pokemon)) {
            int ataqueAnterior = pokemon.getAtaque();
            pokemon.setAtaque((Math.round( (float) (porcentaje / 100) * ataqueAnterior)) + ataqueAnterior);
            cantidad--;
            return true;
        }
        return false;
    }
}
