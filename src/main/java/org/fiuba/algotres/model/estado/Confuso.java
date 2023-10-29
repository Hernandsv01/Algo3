package org.fiuba.algotres.model.estado;

import org.fiuba.algotres.model.Pokemon;

public class Confuso extends Estado {
    private final int DANO = 5;
    private final double PROBABILIDAD = 0.33;

    public Confuso(String nombre) {
        super(nombre);
    }

    @Override
    public boolean accionar() {
        if (this.turnosAplicados >= 3) {
            pokemon.quitarEstado(this)
        }
        this.turnosAplicados++;
        if (Math.random() <= PROBABILIDAD) {
            pokemon.danarPorPorcentaje(DANO);
        }
        return true;
    }
}
