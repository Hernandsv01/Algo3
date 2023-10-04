package org.fiuba.algotres;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
    
    private final Map<TiposBasicos, Efectividad> efectividadMap;
    private static final Map<Tipos, TiposBasicos> tiposToTiposBasicosMap;

    static {
        tiposToTiposBasicosMap = new HashMap<>();
        for (Tipos tipo : values()) {
            tiposToTiposBasicosMap.put(tipo, tipo.toBasico());
        }
    }

    Tipos(Map<TiposBasicos, Efectividad> efectividadMap) {
        this.efectividadMap = Collections.unmodifiableMap(efectividadMap);
    }

    public Map<TiposBasicos, Efectividad> getEfectividadMap() {
        return efectividadMap;
    }
    public TiposBasicos toBasico() {
        return tiposToTiposBasicosMap.get(this);
    }
}
