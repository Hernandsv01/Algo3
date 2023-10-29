package org.fiuba.algotres.model.strategy;

import org.fiuba.algotres.model.Pokemon;

public class DefensaStrategy implements Strategy {
    @Override
    public void modificar(Pokemon pokemon, int porcentaje) {
        int dfs = pokemon.getDefensa();
        if (porcentaje > 0 && porcentaje < 100) {
            pokemon.setDefensa(dfs + Math.round(((float) porcentaje / 100) * dfs));
        }
    }
}
