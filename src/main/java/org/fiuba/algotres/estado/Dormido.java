package org.fiuba.algotres.estado;

import org.fiuba.algotres.Pokemon;

public class Dormido extends Estado {
    public Dormido(String nombre) {
        super(nombre);
    }

    @Override
    public boolean accionar(Pokemon pokemon, Pokemon ignorado) {
        double proba = 0.25 + this.turnosAplicados * 0.25;
        if (Math.random() <= proba) {
            return true;
        }
        this.turnosAplicados++;
        return false;
    }
}
