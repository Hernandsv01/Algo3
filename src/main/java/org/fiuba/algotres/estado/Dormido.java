package org.fiuba.algotres.estado;

import org.fiuba.algotres.Pokemon;

public class Dormido extends Estado {
    public Dormido(String nombre) {
        super(nombre);
    }

    @Override
    public boolean accionar(Pokemon pokemon) {
        double proba = 0.25 + this.turnosAplicados * 0.25;
        if (Math.random() <= proba) {
            pokemon.setEstado(null);
            return true;
        }
        this.turnosAplicados++;
        return false;
    }
}
