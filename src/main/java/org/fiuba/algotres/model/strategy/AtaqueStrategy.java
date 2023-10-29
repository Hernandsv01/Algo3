package org.fiuba.algotres.model.strategy;

import org.fiuba.algotres.model.Pokemon;

public class AtaqueStrategy implements Strategy {
    @Override
    public void modificar(Pokemon pokemon, int porcentaje) {
        pokemon.modificarAtaque(porcentaje);
    }
}
