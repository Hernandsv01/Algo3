package org.fiuba.algotres.item;

import org.fiuba.algotres.Pokemon;

public class Ataque extends Estadistica {
    public Ataque(int cantidad, String nombre, int porcentaje) {
        super(cantidad, nombre, porcentaje);
    }

    @Override
    public boolean accionar(Pokemon pokemon, Pokemon ignorado) {
        if (super.accionar(pokemon, ignorado)) {
            int ataqueAnterior = pokemon.getAtaque();
            pokemon.setAtaque((Math.round( (float) (porcentaje / 100) * ataqueAnterior)) + ataqueAnterior);
            cantidad--;
            return true;
        }
        return false;
    }
}
