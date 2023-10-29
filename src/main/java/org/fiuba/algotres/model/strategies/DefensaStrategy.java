package org.fiuba.algotres.model.strategies;

import org.fiuba.algotres.model.Pokemon;

public class DefensaStrategy implements Strategy {
    @Override
    public void modificar(Pokemon pokemon, int porcentaje) {
        pokemon.modificarDefensa(porcentaje);
        int dfs = pokemon.getDefensa();
        if (porcentaje > 0 && porcentaje < 100) {
            pokemon.setDefensa(dfs + Math.round(((float) porcentaje / 100) * dfs));
        }
    }
}
