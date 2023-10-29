package org.fiuba.algotres.model.strategy;

import org.fiuba.algotres.model.Pokemon;

public class VidaStrategy implements Strategy {
    @Override
    public void modificar(Pokemon pokemon, int porcentaje) {
        pokemon.curarPorPorcentaje(porcentaje);
    }
}
