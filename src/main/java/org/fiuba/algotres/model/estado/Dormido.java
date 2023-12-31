package org.fiuba.algotres.model.estado;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Dormido extends Estado {
    private final double PROBABILIDAD_INICIAL = 0.25;
    private final double PROBABILIDAD_AGREGADA_POR_TURNO = 0.25;

    @JsonCreator
    public Dormido(@JsonProperty("nombreEstado") String nombre) {
        super(nombre);
    }

    @Override
    public boolean accionar() {
        double proba = PROBABILIDAD_INICIAL + this.turnosAplicados * PROBABILIDAD_AGREGADA_POR_TURNO;
        if (randomizador.getRandomValue(0, 1) <= proba) {
            this.pokemon.quitarEstado(this);
            return true;
        }
        this.turnosAplicados++;
        return false;
    }
}
