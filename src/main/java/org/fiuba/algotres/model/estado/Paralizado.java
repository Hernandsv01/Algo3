package org.fiuba.algotres.model.estado;

import org.fiuba.algotres.model.Pokemon;

public class Paralizado extends Estado {
    private final double PROBABILIDAD = 0.5;
    public Paralizado(String nombre) {
        super(nombre);
    }

    @Override
    public boolean accionar() {
        return (Math.random() <= PROBABILIDAD);
    }
}
