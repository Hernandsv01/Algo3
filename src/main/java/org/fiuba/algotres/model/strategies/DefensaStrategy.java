package org.fiuba.algotres.model.strategies;

import org.fiuba.algotres.model.Pokemon;

public class DefensaStrategy extends Strategy {

    public DefensaStrategy() {
    }
    public DefensaStrategy(boolean efectoPositivo) {
        super(efectoPositivo);
    }

    @Override
    public void modificar(Pokemon pokemon, int porcentaje) {
        if (efectoPositivo) {
            pokemon.modificarDefensa(porcentaje);
        } else {
            pokemon.modificarDefensa(-porcentaje);
        }
    }
    @Override
    public boolean esPositivo() {
        return efectoPositivo;
    }
}
