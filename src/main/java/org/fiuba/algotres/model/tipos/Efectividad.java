package org.fiuba.algotres.model.tipos;

import lombok.Getter;

@Getter
public enum Efectividad {
    FUERTE(2.0f),
    NORMAL(1.0f),
    DEBIL(0.5f),
    INUTIL(0.0f);

    private final float multiplicador;

    Efectividad(float multiplicador) {
        this.multiplicador = multiplicador;
    }

}
