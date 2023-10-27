package org.fiuba.algotres.model.estado;

import org.fiuba.algotres.model.Pokemon;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Paralizado extends Estado {
    private final double PROBABILIDAD = 0.5;
    @JsonCreator
    public Paralizado(@JsonProperty("nombreEstado") String nombre) {
        super(nombre);
    }

    @Override
    public boolean accionar(Pokemon pokemon) {
        return Math.random() <= PROBABILIDAD;
    }
}
