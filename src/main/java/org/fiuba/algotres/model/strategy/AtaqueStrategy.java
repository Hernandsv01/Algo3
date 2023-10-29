package org.fiuba.algotres.model.strategy;

import org.fiuba.algotres.model.Pokemon;

public class AtaqueStrategy implements Strategy {
    @Override
    public void modificar(Pokemon pokemon, int porcentaje) {
        int atq = pokemon.getAtaque();
        if (porcentaje > 0 && porcentaje < 100) {
            pokemon.setAtaque(atq + Math.round(((float) porcentaje / 100) * atq));
        }
    }
}
