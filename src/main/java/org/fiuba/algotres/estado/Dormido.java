package org.fiuba.algotres.estado;

import org.fiuba.algotres.Pokemon;

public class Dormido extends Estado {
    private final double PROBABILIDAD_INICIAL = 0.25;
    private final double PROBABILIDAD_AGREGADA_POR_TURNO = 0.25;

    public Dormido(String nombre) {
        super(nombre);
    }

    @Override
    public boolean accionar(Pokemon pokemon) {
        double proba = PROBABILIDAD_INICIAL + this.turnosAplicados * PROBABILIDAD_AGREGADA_POR_TURNO;
        if (Math.random() <= proba) {
            pokemon.setEstado(null);
            return true;
        }
        this.turnosAplicados++;
        return false;
    }
}
