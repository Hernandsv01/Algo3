package org.fiuba.algotres.model.strategy;

import org.fiuba.algotres.model.Pokemon;

public interface Strategy {
    void modificar(Pokemon pokemon, int porcentaje);
}
