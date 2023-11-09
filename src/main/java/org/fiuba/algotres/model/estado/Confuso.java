package org.fiuba.algotres.model.estado;

public class Confuso extends Estado {
    private final int DANO = 5;
    private final double PROBABILIDAD = 0.33;

    public Confuso(String nombre) {
        super(nombre);
    }

    @Override
    public boolean accionar() {
        if (this.turnosAplicados >= 3) {
            pokemon.quitarEstado(this);
        } else {
            this.turnosAplicados++;
            if (randomizador.getRandomValue(0, 1) <= PROBABILIDAD) {
                pokemon.danarPorPorcentaje(DANO);
            }
        }
        return true;
    }
}
