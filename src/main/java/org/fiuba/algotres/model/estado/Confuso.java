package org.fiuba.algotres.model.estado;

import org.fiuba.algotres.model.Pokemon;

public class Confuso extends Estado {
    private final double PROBABILIDAD = 0.33;

    public Confuso(String nombre) {
        super(nombre);
    }

    @Override
    public boolean accionar(Pokemon pokemon) {
        if (this.turnosAplicados >= 3) {
            pokemon.setEstados(null);
            return true;
        }
        this.turnosAplicados++;
        return (Math.random() >= PROBABILIDAD);
    }
}
