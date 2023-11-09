package org.fiuba.algotres.model.estado;

import org.fiuba.algotres.model.Pokemon;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Envenenado extends Estado{
    private final int DANO = 5;
    @JsonCreator
    public Envenenado(@JsonProperty("nombreEstado") String nombre) {
        super(nombre);
    }

    @Override
    public boolean accionar() {
        this.pokemon.danarPorPorcentaje(DANO);
        return true;
    }
}
