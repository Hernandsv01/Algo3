package org.fiuba.algotres;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public enum Tipos {
    TIERRA(
            new HashMap<TiposBasicos, Efectividad>(){{
                put(TiposBasicos.AGUA, Efectividad.FUERTE);
                put(TiposBasicos.PLANTA, Efectividad.DEBIL);
            }}
    ),
    FUEGO(
            new HashMap<TiposBasicos, Efectividad>(){{
                put(TiposBasicos.AGUA, Efectividad.FUERTE);
                put(TiposBasicos.PLANTA, Efectividad.DEBIL);
            }}
    );
    // Acá agregar todos los tipos

    private final HashMap<TiposBasicos, Efectividad> efectividadMap;
    Tipos(HashMap<TiposBasicos, Efectividad> efectividadMap) {
        this.efectividadMap = efectividadMap;
    }

    public HashMap<TiposBasicos, Efectividad> getEfectividadMap() {
        return efectividadMap;
    }
}

enum TiposBasicos {
    FUEGO,
    AGUA,
    PLANTA,
    ELECTRICO;
}

enum Efectividad {
    FUERTE(2.0f),
    NORMAL(1.0f),
    DEBIL(0.5f),
    INUTIL(0.0f);

    private final float multiplicador;

    Efectividad(float multiplicador){
        this.multiplicador = multiplicador;
    }

    public float getEfectividadMap() {
        return multiplicador;
    }
}