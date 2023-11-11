package org.fiuba.algotres.model.strategies;

import lombok.Getter;
import lombok.Setter;
import org.fiuba.algotres.model.Pokemon;

@Getter @Setter
public abstract class Strategy {
    boolean efectoPositivo;

    public Strategy() {
    }

    public Strategy(boolean efectoPositivo) {
        this.efectoPositivo = efectoPositivo;
    }

    public abstract void modificar(Pokemon pokemon, int porcentaje);

    public abstract boolean esPositivo();
}
