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
    public boolean accionar(Pokemon pokemon) {
        Random util = new Random();
        double proba = PROBABILIDAD_INICIAL + this.turnosAplicados * PROBABILIDAD_AGREGADA_POR_TURNO;
        if (util.nextDouble() <= proba) {
            pokemon.setEstado(null);
            return true;
        }
        this.turnosAplicados++;
        return false;
    }
}
