package org.fiuba.algotres.model.estado;

import java.util.Random;

import org.fiuba.algotres.model.Pokemon;

public class Dormido extends Estado {
    private final double PROBABILIDAD_INICIAL = 0.25;
    private final double PROBABILIDAD_AGREGADA_POR_TURNO = 0.25;

    public Dormido(String nombre) {
        super(nombre);
    }

    @Override
    public boolean accionar() {
        double proba = PROBABILIDAD_INICIAL + this.turnosAplicados * PROBABILIDAD_AGREGADA_POR_TURNO;
        if (Math.random() <= proba) {
            this.pokemon.quitarEstado(this);
            return true;
        }
        this.turnosAplicados++;
        return false;
    }
}
