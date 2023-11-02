package org.fiuba.algotres.model.strategies;

import org.fiuba.algotres.model.Pokemon;

public class DefensaStrategy implements Strategy {
    boolean efectoPositivo;

    public DefensaStrategy(boolean efectoPositivo) {
        this.efectoPositivo = efectoPositivo;
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
