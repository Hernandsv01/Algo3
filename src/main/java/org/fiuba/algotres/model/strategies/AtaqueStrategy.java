package org.fiuba.algotres.model.strategies;

import org.fiuba.algotres.model.Pokemon;

public class AtaqueStrategy extends Strategy {

    public AtaqueStrategy() {
    }
    public AtaqueStrategy(boolean efectoPositivo) {
        super(efectoPositivo);
    }

    @Override
    public void modificar(Pokemon pokemon, int porcentaje) {
        if (efectoPositivo) {
            pokemon.modificarAtaque(porcentaje);
        } else {
            pokemon.modificarAtaque(-porcentaje);
        }
    }

    @Override
    public boolean esPositivo() {
        return efectoPositivo;
    }
}
