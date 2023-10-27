package org.fiuba.algotres.model.estado;

import org.fiuba.algotres.model.Pokemon;

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
