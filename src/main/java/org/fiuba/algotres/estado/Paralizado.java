package org.fiuba.algotres.estado;

import org.fiuba.algotres.Pokemon;

public class Paralizado extends Estado {
    public Paralizado(String nombre) {
        super(nombre);
    }

    @Override
    public boolean accionar(Pokemon pokemon, Pokemon ignorado) {
        return Math.random() >= 0.5;
    }
}
