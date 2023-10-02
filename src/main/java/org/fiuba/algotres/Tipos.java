package org.fiuba.algotres;

import java.util.HashMap;

public enum Tipos {

    AGUA(
            new HashMap<TiposBasicos, Efectividad>(){{
                put(TiposBasicos.AGUA, Efectividad.DEBIL);
                put(TiposBasicos.BICHO, Efectividad.NORMAL);
                put(TiposBasicos.DRAGON, Efectividad.DEBIL);
                put(TiposBasicos.ELECTRICO, Efectividad.NORMAL);
                put(TiposBasicos.FANTASMA, Efectividad.NORMAL);
                put(TiposBasicos.FUEGO, Efectividad.FUERTE);
                put(TiposBasicos.HIELO, Efectividad.NORMAL);
                put(TiposBasicos.LUCHA, Efectividad.NORMAL);
                put(TiposBasicos.NORMAL, Efectividad.NORMAL);
                put(TiposBasicos.PLANTA, Efectividad.DEBIL);
                put(TiposBasicos.PSIQUICO, Efectividad.NORMAL);
                put(TiposBasicos.ROCA, Efectividad.FUERTE);
                put(TiposBasicos.TIERRA, Efectividad.FUERTE);
                put(TiposBasicos.VENENO, Efectividad.NORMAL);
                put(TiposBasicos.VOLADOR, Efectividad.NORMAL);
            }}
    ),
    BICHO(
            new HashMap<TiposBasicos, Efectividad>(){{
                put(TiposBasicos.AGUA, Efectividad.NORMAL);
                put(TiposBasicos.BICHO, Efectividad.NORMAL);
                put(TiposBasicos.DRAGON, Efectividad.NORMAL);
                put(TiposBasicos.ELECTRICO, Efectividad.NORMAL);
                put(TiposBasicos.FANTASMA, Efectividad.DEBIL);
                put(TiposBasicos.FUEGO, Efectividad.DEBIL);
                put(TiposBasicos.HIELO, Efectividad.NORMAL);
                put(TiposBasicos.LUCHA, Efectividad.DEBIL);
                put(TiposBasicos.NORMAL, Efectividad.NORMAL);
                put(TiposBasicos.PLANTA, Efectividad.FUERTE);
                put(TiposBasicos.PSIQUICO, Efectividad.FUERTE);
                put(TiposBasicos.ROCA, Efectividad.NORMAL);
                put(TiposBasicos.TIERRA, Efectividad.NORMAL);
                put(TiposBasicos.VENENO, Efectividad.FUERTE);
                put(TiposBasicos.VOLADOR, Efectividad.DEBIL);
            }}
    ),
    DRAGON(
            new HashMap<TiposBasicos, Efectividad>(){{
                put(TiposBasicos.AGUA, Efectividad.NORMAL);
                put(TiposBasicos.BICHO, Efectividad.NORMAL);
                put(TiposBasicos.DRAGON, Efectividad.FUERTE);
                put(TiposBasicos.ELECTRICO, Efectividad.NORMAL);
                put(TiposBasicos.FANTASMA, Efectividad.NORMAL);
                put(TiposBasicos.FUEGO, Efectividad.NORMAL);
                put(TiposBasicos.HIELO, Efectividad.NORMAL);
                put(TiposBasicos.LUCHA, Efectividad.NORMAL);
                put(TiposBasicos.NORMAL, Efectividad.NORMAL);
                put(TiposBasicos.PLANTA, Efectividad.NORMAL);
                put(TiposBasicos.PSIQUICO, Efectividad.NORMAL);
                put(TiposBasicos.ROCA, Efectividad.NORMAL);
                put(TiposBasicos.TIERRA, Efectividad.NORMAL);
                put(TiposBasicos.VENENO, Efectividad.NORMAL);
                put(TiposBasicos.VOLADOR, Efectividad.NORMAL);
            }}
    ),
    ELECTRICO(
            new HashMap<TiposBasicos, Efectividad>(){{
                put(TiposBasicos.AGUA, Efectividad.FUERTE);
                put(TiposBasicos.BICHO, Efectividad.NORMAL);
                put(TiposBasicos.DRAGON, Efectividad.DEBIL);
                put(TiposBasicos.ELECTRICO, Efectividad.DEBIL);
                put(TiposBasicos.FANTASMA, Efectividad.NORMAL);
                put(TiposBasicos.FUEGO, Efectividad.NORMAL);
                put(TiposBasicos.HIELO, Efectividad.NORMAL);
                put(TiposBasicos.LUCHA, Efectividad.NORMAL);
                put(TiposBasicos.NORMAL, Efectividad.NORMAL);
                put(TiposBasicos.PLANTA, Efectividad.DEBIL);
                put(TiposBasicos.PSIQUICO, Efectividad.NORMAL);
                put(TiposBasicos.ROCA, Efectividad.NORMAL);
                put(TiposBasicos.TIERRA, Efectividad.INUTIL);
                put(TiposBasicos.VENENO, Efectividad.NORMAL);
                put(TiposBasicos.VOLADOR, Efectividad.FUERTE);
            }}
    ),
    FANTASMA(
            new HashMap<TiposBasicos, Efectividad>(){{
                put(TiposBasicos.AGUA, Efectividad.NORMAL);
                put(TiposBasicos.BICHO, Efectividad.NORMAL);
                put(TiposBasicos.DRAGON, Efectividad.NORMAL);
                put(TiposBasicos.ELECTRICO, Efectividad.NORMAL);
                put(TiposBasicos.FANTASMA, Efectividad.FUERTE);
                put(TiposBasicos.FUEGO, Efectividad.NORMAL);
                put(TiposBasicos.HIELO, Efectividad.NORMAL);
                put(TiposBasicos.LUCHA, Efectividad.NORMAL);
                put(TiposBasicos.NORMAL, Efectividad.INUTIL);
                put(TiposBasicos.PLANTA, Efectividad.NORMAL);
                put(TiposBasicos.PSIQUICO, Efectividad.INUTIL);
                put(TiposBasicos.ROCA, Efectividad.NORMAL);
                put(TiposBasicos.TIERRA, Efectividad.NORMAL);
                put(TiposBasicos.VENENO, Efectividad.NORMAL);
                put(TiposBasicos.VOLADOR, Efectividad.NORMAL);
            }}
    ),
    FUEGO(
            new HashMap<TiposBasicos, Efectividad>(){{
                put(TiposBasicos.AGUA, Efectividad.DEBIL);
                put(TiposBasicos.BICHO, Efectividad.FUERTE);
                put(TiposBasicos.DRAGON, Efectividad.DEBIL);
                put(TiposBasicos.ELECTRICO, Efectividad.NORMAL);
                put(TiposBasicos.FANTASMA, Efectividad.NORMAL);
                put(TiposBasicos.FUEGO, Efectividad.DEBIL);
                put(TiposBasicos.HIELO, Efectividad.FUERTE);
                put(TiposBasicos.LUCHA, Efectividad.NORMAL);
                put(TiposBasicos.NORMAL, Efectividad.NORMAL);
                put(TiposBasicos.PLANTA, Efectividad.FUERTE);
                put(TiposBasicos.PSIQUICO, Efectividad.NORMAL);
                put(TiposBasicos.ROCA, Efectividad.DEBIL);
                put(TiposBasicos.TIERRA, Efectividad.NORMAL);
                put(TiposBasicos.VENENO, Efectividad.NORMAL);
                put(TiposBasicos.VOLADOR, Efectividad.NORMAL);
            }}
    ),
    HIELO(
            new HashMap<TiposBasicos, Efectividad>(){{
                put(TiposBasicos.AGUA, Efectividad.DEBIL);
                put(TiposBasicos.BICHO, Efectividad.NORMAL);
                put(TiposBasicos.DRAGON, Efectividad.FUERTE);
                put(TiposBasicos.ELECTRICO, Efectividad.NORMAL);
                put(TiposBasicos.FANTASMA, Efectividad.NORMAL);
                put(TiposBasicos.FUEGO, Efectividad.NORMAL);
                put(TiposBasicos.HIELO, Efectividad.DEBIL);
                put(TiposBasicos.LUCHA, Efectividad.NORMAL);
                put(TiposBasicos.NORMAL, Efectividad.NORMAL);
                put(TiposBasicos.PLANTA, Efectividad.FUERTE);
                put(TiposBasicos.PSIQUICO, Efectividad.NORMAL);
                put(TiposBasicos.ROCA, Efectividad.NORMAL);
                put(TiposBasicos.TIERRA, Efectividad.FUERTE);
                put(TiposBasicos.VENENO, Efectividad.NORMAL);
                put(TiposBasicos.VOLADOR, Efectividad.FUERTE);
            }}
    ),
    LUCHA(
            new HashMap<TiposBasicos, Efectividad>(){{
                put(TiposBasicos.AGUA, Efectividad.NORMAL);
                put(TiposBasicos.BICHO, Efectividad.DEBIL);
                put(TiposBasicos.DRAGON, Efectividad.NORMAL);
                put(TiposBasicos.ELECTRICO, Efectividad.NORMAL);
                put(TiposBasicos.FANTASMA, Efectividad.INUTIL);
                put(TiposBasicos.FUEGO, Efectividad.NORMAL);
                put(TiposBasicos.HIELO, Efectividad.FUERTE);
                put(TiposBasicos.LUCHA, Efectividad.NORMAL);
                put(TiposBasicos.NORMAL, Efectividad.FUERTE);
                put(TiposBasicos.PLANTA, Efectividad.NORMAL);
                put(TiposBasicos.PSIQUICO, Efectividad.DEBIL);
                put(TiposBasicos.ROCA, Efectividad.FUERTE);
                put(TiposBasicos.TIERRA, Efectividad.NORMAL);
                put(TiposBasicos.VENENO, Efectividad.DEBIL);
                put(TiposBasicos.VOLADOR, Efectividad.DEBIL);
            }}
    ),
    NORMAL(
            new HashMap<TiposBasicos, Efectividad>(){{
                put(TiposBasicos.AGUA, Efectividad.NORMAL);
                put(TiposBasicos.BICHO, Efectividad.NORMAL);
                put(TiposBasicos.DRAGON, Efectividad.NORMAL);
                put(TiposBasicos.ELECTRICO, Efectividad.NORMAL);
                put(TiposBasicos.FANTASMA, Efectividad.INUTIL);
                put(TiposBasicos.FUEGO, Efectividad.NORMAL);
                put(TiposBasicos.HIELO, Efectividad.NORMAL);
                put(TiposBasicos.LUCHA, Efectividad.NORMAL);
                put(TiposBasicos.NORMAL, Efectividad.NORMAL);
                put(TiposBasicos.PLANTA, Efectividad.NORMAL);
                put(TiposBasicos.PSIQUICO, Efectividad.NORMAL);
                put(TiposBasicos.ROCA, Efectividad.DEBIL);
                put(TiposBasicos.TIERRA, Efectividad.NORMAL);
                put(TiposBasicos.VENENO, Efectividad.NORMAL);
                put(TiposBasicos.VOLADOR, Efectividad.NORMAL);
            }}
    ),
    PLANTA(
            new HashMap<TiposBasicos, Efectividad>(){{
                put(TiposBasicos.AGUA, Efectividad.FUERTE);
                put(TiposBasicos.BICHO, Efectividad.DEBIL);
                put(TiposBasicos.DRAGON, Efectividad.DEBIL);
                put(TiposBasicos.ELECTRICO, Efectividad.NORMAL);
                put(TiposBasicos.FANTASMA, Efectividad.NORMAL);
                put(TiposBasicos.FUEGO, Efectividad.DEBIL);
                put(TiposBasicos.HIELO, Efectividad.NORMAL);
                put(TiposBasicos.LUCHA, Efectividad.NORMAL);
                put(TiposBasicos.NORMAL, Efectividad.NORMAL);
                put(TiposBasicos.PLANTA, Efectividad.DEBIL);
                put(TiposBasicos.PSIQUICO, Efectividad.NORMAL);
                put(TiposBasicos.ROCA, Efectividad.FUERTE);
                put(TiposBasicos.TIERRA, Efectividad.FUERTE);
                put(TiposBasicos.VENENO, Efectividad.DEBIL);
                put(TiposBasicos.VOLADOR, Efectividad.DEBIL);
            }}
    ),
    PSIQUICO(
            new HashMap<TiposBasicos, Efectividad>(){{
                put(TiposBasicos.AGUA, Efectividad.NORMAL);
                put(TiposBasicos.BICHO, Efectividad.NORMAL);
                put(TiposBasicos.DRAGON, Efectividad.NORMAL);
                put(TiposBasicos.ELECTRICO, Efectividad.NORMAL);
                put(TiposBasicos.FANTASMA, Efectividad.NORMAL);
                put(TiposBasicos.FUEGO, Efectividad.NORMAL);
                put(TiposBasicos.HIELO, Efectividad.NORMAL);
                put(TiposBasicos.LUCHA, Efectividad.FUERTE);
                put(TiposBasicos.NORMAL, Efectividad.NORMAL);
                put(TiposBasicos.PLANTA, Efectividad.NORMAL);
                put(TiposBasicos.PSIQUICO, Efectividad.DEBIL);
                put(TiposBasicos.ROCA, Efectividad.NORMAL);
                put(TiposBasicos.TIERRA, Efectividad.NORMAL);
                put(TiposBasicos.VENENO, Efectividad.FUERTE);
                put(TiposBasicos.VOLADOR, Efectividad.NORMAL);
            }}
    ),
    ROCA(
            new HashMap<TiposBasicos, Efectividad>(){{
                put(TiposBasicos.AGUA, Efectividad.NORMAL);
                put(TiposBasicos.BICHO, Efectividad.FUERTE);
                put(TiposBasicos.DRAGON, Efectividad.NORMAL);
                put(TiposBasicos.ELECTRICO, Efectividad.NORMAL);
                put(TiposBasicos.FANTASMA, Efectividad.NORMAL);
                put(TiposBasicos.FUEGO, Efectividad.FUERTE);
                put(TiposBasicos.HIELO, Efectividad.FUERTE);
                put(TiposBasicos.LUCHA, Efectividad.DEBIL);
                put(TiposBasicos.NORMAL, Efectividad.NORMAL);
                put(TiposBasicos.PLANTA, Efectividad.NORMAL);
                put(TiposBasicos.PSIQUICO, Efectividad.NORMAL);
                put(TiposBasicos.ROCA, Efectividad.NORMAL);
                put(TiposBasicos.TIERRA, Efectividad.DEBIL);
                put(TiposBasicos.VENENO, Efectividad.NORMAL);
                put(TiposBasicos.VOLADOR, Efectividad.FUERTE);
            }}
    ),
    TIERRA(
            new HashMap<TiposBasicos, Efectividad>(){{
                put(TiposBasicos.AGUA, Efectividad.NORMAL);
                put(TiposBasicos.BICHO, Efectividad.DEBIL);
                put(TiposBasicos.DRAGON, Efectividad.NORMAL);
                put(TiposBasicos.ELECTRICO, Efectividad.FUERTE);
                put(TiposBasicos.FANTASMA, Efectividad.NORMAL);
                put(TiposBasicos.FUEGO, Efectividad.FUERTE);
                put(TiposBasicos.HIELO, Efectividad.NORMAL);
                put(TiposBasicos.LUCHA, Efectividad.NORMAL);
                put(TiposBasicos.NORMAL, Efectividad.NORMAL);
                put(TiposBasicos.PLANTA, Efectividad.DEBIL);
                put(TiposBasicos.PSIQUICO, Efectividad.NORMAL);
                put(TiposBasicos.ROCA, Efectividad.FUERTE);
                put(TiposBasicos.TIERRA, Efectividad.NORMAL);
                put(TiposBasicos.VENENO, Efectividad.FUERTE);
                put(TiposBasicos.VOLADOR, Efectividad.INUTIL);
            }}
    ),
    VENENO(
            new HashMap<TiposBasicos, Efectividad>(){{
                put(TiposBasicos.AGUA, Efectividad.NORMAL);
                put(TiposBasicos.BICHO, Efectividad.FUERTE);
                put(TiposBasicos.DRAGON, Efectividad.NORMAL);
                put(TiposBasicos.ELECTRICO, Efectividad.NORMAL);
                put(TiposBasicos.FANTASMA, Efectividad.DEBIL);
                put(TiposBasicos.FUEGO, Efectividad.NORMAL);
                put(TiposBasicos.HIELO, Efectividad.NORMAL);
                put(TiposBasicos.LUCHA, Efectividad.NORMAL);
                put(TiposBasicos.NORMAL, Efectividad.NORMAL);
                put(TiposBasicos.PLANTA, Efectividad.FUERTE);
                put(TiposBasicos.PSIQUICO, Efectividad.NORMAL);
                put(TiposBasicos.ROCA, Efectividad.DEBIL);
                put(TiposBasicos.TIERRA, Efectividad.DEBIL);
                put(TiposBasicos.VENENO, Efectividad.DEBIL);
                put(TiposBasicos.VOLADOR, Efectividad.NORMAL);
            }}
    ),
    VOLADOR(
            new HashMap<TiposBasicos, Efectividad>(){{
                put(TiposBasicos.AGUA, Efectividad.NORMAL);
                put(TiposBasicos.BICHO, Efectividad.FUERTE);
                put(TiposBasicos.DRAGON, Efectividad.NORMAL);
                put(TiposBasicos.ELECTRICO, Efectividad.DEBIL);
                put(TiposBasicos.FANTASMA, Efectividad.NORMAL);
                put(TiposBasicos.FUEGO, Efectividad.NORMAL);
                put(TiposBasicos.HIELO, Efectividad.NORMAL);
                put(TiposBasicos.LUCHA, Efectividad.FUERTE);
                put(TiposBasicos.NORMAL, Efectividad.NORMAL);
                put(TiposBasicos.PLANTA, Efectividad.FUERTE);
                put(TiposBasicos.PSIQUICO, Efectividad.NORMAL);
                put(TiposBasicos.ROCA, Efectividad.DEBIL);
                put(TiposBasicos.TIERRA, Efectividad.NORMAL);
                put(TiposBasicos.VENENO, Efectividad.NORMAL);
                put(TiposBasicos.VOLADOR, Efectividad.NORMAL);
            }}
    );
    
    private final HashMap<TiposBasicos, Efectividad> efectividadMap;
    Tipos(HashMap<TiposBasicos, Efectividad> efectividadMap) {
        this.efectividadMap = efectividadMap;
    }

    public HashMap<TiposBasicos, Efectividad> getEfectividadMap() {
        return efectividadMap;
    }
}

enum TiposBasicos {
    AGUA,
    BICHO,
    DRAGON,
    ELECTRICO,
    FANTASMA,
    FUEGO,
    HIELO,
    LUCHA,
    NORMAL,
    PLANTA,
    PSIQUICO,
    ROCA,
    TIERRA,
    VENENO,
    VOLADOR
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

    public float getMultiplicador() {
        return multiplicador;
    }
}