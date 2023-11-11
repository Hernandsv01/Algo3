package org.fiuba.algotres.model.strategies;

import org.fiuba.algotres.model.Pokemon;

public class VidaStrategy extends Strategy {
    public VidaStrategy() {
    }

    public VidaStrategy(boolean efectoPositivo) {
        super(efectoPositivo);
    }

    @Override
    public void modificar(Pokemon pokemon, int porcentaje) {
        pokemon.curarPorPorcentaje(porcentaje);
    }

    @Override
    public boolean esPositivo() {
        return true;
    }
}
