package org.fiuba.algotres.model.estado;

public class Paralizado extends Estado {
    private final double PROBABILIDAD = 0.5;
    public Paralizado(String nombre) {
        super(nombre);
    }

    @Override
    public boolean accionar() {
        return (randomizador.getRandomValue(0, 1) <= PROBABILIDAD);
    }
}
