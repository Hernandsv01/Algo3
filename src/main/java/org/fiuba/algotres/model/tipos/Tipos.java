package org.fiuba.algotres.model.tipos;

import lombok.Getter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Getter
public enum Tipos {

    AGUA(
            new HashMap<TiposPrimitivos, Efectividad>(){{
                put(TiposPrimitivos.AGUA, Efectividad.DEBIL);
                put(TiposPrimitivos.BICHO, Efectividad.NORMAL);
                put(TiposPrimitivos.DRAGON, Efectividad.DEBIL);
                put(TiposPrimitivos.ELECTRICO, Efectividad.NORMAL);
                put(TiposPrimitivos.FANTASMA, Efectividad.NORMAL);
                put(TiposPrimitivos.FUEGO, Efectividad.FUERTE);
                put(TiposPrimitivos.HIELO, Efectividad.NORMAL);
                put(TiposPrimitivos.LUCHA, Efectividad.NORMAL);
                put(TiposPrimitivos.NORMAL, Efectividad.NORMAL);
                put(TiposPrimitivos.PLANTA, Efectividad.DEBIL);
                put(TiposPrimitivos.PSIQUICO, Efectividad.NORMAL);
                put(TiposPrimitivos.ROCA, Efectividad.FUERTE);
                put(TiposPrimitivos.TIERRA, Efectividad.FUERTE);
                put(TiposPrimitivos.VENENO, Efectividad.NORMAL);
                put(TiposPrimitivos.VOLADOR, Efectividad.NORMAL);
            }}
    ),
    BICHO(
            new HashMap<TiposPrimitivos, Efectividad>(){{
                put(TiposPrimitivos.AGUA, Efectividad.NORMAL);
                put(TiposPrimitivos.BICHO, Efectividad.NORMAL);
                put(TiposPrimitivos.DRAGON, Efectividad.NORMAL);
                put(TiposPrimitivos.ELECTRICO, Efectividad.NORMAL);
                put(TiposPrimitivos.FANTASMA, Efectividad.DEBIL);
                put(TiposPrimitivos.FUEGO, Efectividad.DEBIL);
                put(TiposPrimitivos.HIELO, Efectividad.NORMAL);
                put(TiposPrimitivos.LUCHA, Efectividad.DEBIL);
                put(TiposPrimitivos.NORMAL, Efectividad.NORMAL);
                put(TiposPrimitivos.PLANTA, Efectividad.FUERTE);
                put(TiposPrimitivos.PSIQUICO, Efectividad.FUERTE);
                put(TiposPrimitivos.ROCA, Efectividad.NORMAL);
                put(TiposPrimitivos.TIERRA, Efectividad.NORMAL);
                put(TiposPrimitivos.VENENO, Efectividad.FUERTE);
                put(TiposPrimitivos.VOLADOR, Efectividad.DEBIL);
            }}
    ),
    DRAGON(
            new HashMap<TiposPrimitivos, Efectividad>(){{
                put(TiposPrimitivos.AGUA, Efectividad.NORMAL);
                put(TiposPrimitivos.BICHO, Efectividad.NORMAL);
                put(TiposPrimitivos.DRAGON, Efectividad.FUERTE);
                put(TiposPrimitivos.ELECTRICO, Efectividad.NORMAL);
                put(TiposPrimitivos.FANTASMA, Efectividad.NORMAL);
                put(TiposPrimitivos.FUEGO, Efectividad.NORMAL);
                put(TiposPrimitivos.HIELO, Efectividad.NORMAL);
                put(TiposPrimitivos.LUCHA, Efectividad.NORMAL);
                put(TiposPrimitivos.NORMAL, Efectividad.NORMAL);
                put(TiposPrimitivos.PLANTA, Efectividad.NORMAL);
                put(TiposPrimitivos.PSIQUICO, Efectividad.NORMAL);
                put(TiposPrimitivos.ROCA, Efectividad.NORMAL);
                put(TiposPrimitivos.TIERRA, Efectividad.NORMAL);
                put(TiposPrimitivos.VENENO, Efectividad.NORMAL);
                put(TiposPrimitivos.VOLADOR, Efectividad.NORMAL);
            }}
    ),
    ELECTRICO(
            new HashMap<TiposPrimitivos, Efectividad>(){{
                put(TiposPrimitivos.AGUA, Efectividad.FUERTE);
                put(TiposPrimitivos.BICHO, Efectividad.NORMAL);
                put(TiposPrimitivos.DRAGON, Efectividad.DEBIL);
                put(TiposPrimitivos.ELECTRICO, Efectividad.DEBIL);
                put(TiposPrimitivos.FANTASMA, Efectividad.NORMAL);
                put(TiposPrimitivos.FUEGO, Efectividad.NORMAL);
                put(TiposPrimitivos.HIELO, Efectividad.NORMAL);
                put(TiposPrimitivos.LUCHA, Efectividad.NORMAL);
                put(TiposPrimitivos.NORMAL, Efectividad.NORMAL);
                put(TiposPrimitivos.PLANTA, Efectividad.DEBIL);
                put(TiposPrimitivos.PSIQUICO, Efectividad.NORMAL);
                put(TiposPrimitivos.ROCA, Efectividad.NORMAL);
                put(TiposPrimitivos.TIERRA, Efectividad.INUTIL);
                put(TiposPrimitivos.VENENO, Efectividad.NORMAL);
                put(TiposPrimitivos.VOLADOR, Efectividad.FUERTE);
            }}
    ),
    FANTASMA(
            new HashMap<TiposPrimitivos, Efectividad>(){{
                put(TiposPrimitivos.AGUA, Efectividad.NORMAL);
                put(TiposPrimitivos.BICHO, Efectividad.NORMAL);
                put(TiposPrimitivos.DRAGON, Efectividad.NORMAL);
                put(TiposPrimitivos.ELECTRICO, Efectividad.NORMAL);
                put(TiposPrimitivos.FANTASMA, Efectividad.FUERTE);
                put(TiposPrimitivos.FUEGO, Efectividad.NORMAL);
                put(TiposPrimitivos.HIELO, Efectividad.NORMAL);
                put(TiposPrimitivos.LUCHA, Efectividad.NORMAL);
                put(TiposPrimitivos.NORMAL, Efectividad.INUTIL);
                put(TiposPrimitivos.PLANTA, Efectividad.NORMAL);
                put(TiposPrimitivos.PSIQUICO, Efectividad.INUTIL);
                put(TiposPrimitivos.ROCA, Efectividad.NORMAL);
                put(TiposPrimitivos.TIERRA, Efectividad.NORMAL);
                put(TiposPrimitivos.VENENO, Efectividad.NORMAL);
                put(TiposPrimitivos.VOLADOR, Efectividad.NORMAL);
            }}
    ),
    FUEGO(
            new HashMap<TiposPrimitivos, Efectividad>(){{
                put(TiposPrimitivos.AGUA, Efectividad.DEBIL);
                put(TiposPrimitivos.BICHO, Efectividad.FUERTE);
                put(TiposPrimitivos.DRAGON, Efectividad.DEBIL);
                put(TiposPrimitivos.ELECTRICO, Efectividad.NORMAL);
                put(TiposPrimitivos.FANTASMA, Efectividad.NORMAL);
                put(TiposPrimitivos.FUEGO, Efectividad.DEBIL);
                put(TiposPrimitivos.HIELO, Efectividad.FUERTE);
                put(TiposPrimitivos.LUCHA, Efectividad.NORMAL);
                put(TiposPrimitivos.NORMAL, Efectividad.NORMAL);
                put(TiposPrimitivos.PLANTA, Efectividad.FUERTE);
                put(TiposPrimitivos.PSIQUICO, Efectividad.NORMAL);
                put(TiposPrimitivos.ROCA, Efectividad.DEBIL);
                put(TiposPrimitivos.TIERRA, Efectividad.NORMAL);
                put(TiposPrimitivos.VENENO, Efectividad.NORMAL);
                put(TiposPrimitivos.VOLADOR, Efectividad.NORMAL);
            }}
    ),
    HIELO(
            new HashMap<TiposPrimitivos, Efectividad>(){{
                put(TiposPrimitivos.AGUA, Efectividad.DEBIL);
                put(TiposPrimitivos.BICHO, Efectividad.NORMAL);
                put(TiposPrimitivos.DRAGON, Efectividad.FUERTE);
                put(TiposPrimitivos.ELECTRICO, Efectividad.NORMAL);
                put(TiposPrimitivos.FANTASMA, Efectividad.NORMAL);
                put(TiposPrimitivos.FUEGO, Efectividad.NORMAL);
                put(TiposPrimitivos.HIELO, Efectividad.DEBIL);
                put(TiposPrimitivos.LUCHA, Efectividad.NORMAL);
                put(TiposPrimitivos.NORMAL, Efectividad.NORMAL);
                put(TiposPrimitivos.PLANTA, Efectividad.FUERTE);
                put(TiposPrimitivos.PSIQUICO, Efectividad.NORMAL);
                put(TiposPrimitivos.ROCA, Efectividad.NORMAL);
                put(TiposPrimitivos.TIERRA, Efectividad.FUERTE);
                put(TiposPrimitivos.VENENO, Efectividad.NORMAL);
                put(TiposPrimitivos.VOLADOR, Efectividad.FUERTE);
            }}
    ),
    LUCHA(
            new HashMap<TiposPrimitivos, Efectividad>(){{
                put(TiposPrimitivos.AGUA, Efectividad.NORMAL);
                put(TiposPrimitivos.BICHO, Efectividad.DEBIL);
                put(TiposPrimitivos.DRAGON, Efectividad.NORMAL);
                put(TiposPrimitivos.ELECTRICO, Efectividad.NORMAL);
                put(TiposPrimitivos.FANTASMA, Efectividad.INUTIL);
                put(TiposPrimitivos.FUEGO, Efectividad.NORMAL);
                put(TiposPrimitivos.HIELO, Efectividad.FUERTE);
                put(TiposPrimitivos.LUCHA, Efectividad.NORMAL);
                put(TiposPrimitivos.NORMAL, Efectividad.FUERTE);
                put(TiposPrimitivos.PLANTA, Efectividad.NORMAL);
                put(TiposPrimitivos.PSIQUICO, Efectividad.DEBIL);
                put(TiposPrimitivos.ROCA, Efectividad.FUERTE);
                put(TiposPrimitivos.TIERRA, Efectividad.NORMAL);
                put(TiposPrimitivos.VENENO, Efectividad.DEBIL);
                put(TiposPrimitivos.VOLADOR, Efectividad.DEBIL);
            }}
    ),
    NORMAL(
            new HashMap<TiposPrimitivos, Efectividad>(){{
                put(TiposPrimitivos.AGUA, Efectividad.NORMAL);
                put(TiposPrimitivos.BICHO, Efectividad.NORMAL);
                put(TiposPrimitivos.DRAGON, Efectividad.NORMAL);
                put(TiposPrimitivos.ELECTRICO, Efectividad.NORMAL);
                put(TiposPrimitivos.FANTASMA, Efectividad.INUTIL);
                put(TiposPrimitivos.FUEGO, Efectividad.NORMAL);
                put(TiposPrimitivos.HIELO, Efectividad.NORMAL);
                put(TiposPrimitivos.LUCHA, Efectividad.NORMAL);
                put(TiposPrimitivos.NORMAL, Efectividad.NORMAL);
                put(TiposPrimitivos.PLANTA, Efectividad.NORMAL);
                put(TiposPrimitivos.PSIQUICO, Efectividad.NORMAL);
                put(TiposPrimitivos.ROCA, Efectividad.DEBIL);
                put(TiposPrimitivos.TIERRA, Efectividad.NORMAL);
                put(TiposPrimitivos.VENENO, Efectividad.NORMAL);
                put(TiposPrimitivos.VOLADOR, Efectividad.NORMAL);
            }}
    ),
    PLANTA(
            new HashMap<TiposPrimitivos, Efectividad>(){{
                put(TiposPrimitivos.AGUA, Efectividad.FUERTE);
                put(TiposPrimitivos.BICHO, Efectividad.DEBIL);
                put(TiposPrimitivos.DRAGON, Efectividad.DEBIL);
                put(TiposPrimitivos.ELECTRICO, Efectividad.NORMAL);
                put(TiposPrimitivos.FANTASMA, Efectividad.NORMAL);
                put(TiposPrimitivos.FUEGO, Efectividad.DEBIL);
                put(TiposPrimitivos.HIELO, Efectividad.NORMAL);
                put(TiposPrimitivos.LUCHA, Efectividad.NORMAL);
                put(TiposPrimitivos.NORMAL, Efectividad.NORMAL);
                put(TiposPrimitivos.PLANTA, Efectividad.DEBIL);
                put(TiposPrimitivos.PSIQUICO, Efectividad.NORMAL);
                put(TiposPrimitivos.ROCA, Efectividad.FUERTE);
                put(TiposPrimitivos.TIERRA, Efectividad.FUERTE);
                put(TiposPrimitivos.VENENO, Efectividad.DEBIL);
                put(TiposPrimitivos.VOLADOR, Efectividad.DEBIL);
            }}
    ),
    PSIQUICO(
            new HashMap<TiposPrimitivos, Efectividad>(){{
                put(TiposPrimitivos.AGUA, Efectividad.NORMAL);
                put(TiposPrimitivos.BICHO, Efectividad.NORMAL);
                put(TiposPrimitivos.DRAGON, Efectividad.NORMAL);
                put(TiposPrimitivos.ELECTRICO, Efectividad.NORMAL);
                put(TiposPrimitivos.FANTASMA, Efectividad.NORMAL);
                put(TiposPrimitivos.FUEGO, Efectividad.NORMAL);
                put(TiposPrimitivos.HIELO, Efectividad.NORMAL);
                put(TiposPrimitivos.LUCHA, Efectividad.FUERTE);
                put(TiposPrimitivos.NORMAL, Efectividad.NORMAL);
                put(TiposPrimitivos.PLANTA, Efectividad.NORMAL);
                put(TiposPrimitivos.PSIQUICO, Efectividad.DEBIL);
                put(TiposPrimitivos.ROCA, Efectividad.NORMAL);
                put(TiposPrimitivos.TIERRA, Efectividad.NORMAL);
                put(TiposPrimitivos.VENENO, Efectividad.FUERTE);
                put(TiposPrimitivos.VOLADOR, Efectividad.NORMAL);
            }}
    ),
    ROCA(
            new HashMap<TiposPrimitivos, Efectividad>(){{
                put(TiposPrimitivos.AGUA, Efectividad.NORMAL);
                put(TiposPrimitivos.BICHO, Efectividad.FUERTE);
                put(TiposPrimitivos.DRAGON, Efectividad.NORMAL);
                put(TiposPrimitivos.ELECTRICO, Efectividad.NORMAL);
                put(TiposPrimitivos.FANTASMA, Efectividad.NORMAL);
                put(TiposPrimitivos.FUEGO, Efectividad.FUERTE);
                put(TiposPrimitivos.HIELO, Efectividad.FUERTE);
                put(TiposPrimitivos.LUCHA, Efectividad.DEBIL);
                put(TiposPrimitivos.NORMAL, Efectividad.NORMAL);
                put(TiposPrimitivos.PLANTA, Efectividad.NORMAL);
                put(TiposPrimitivos.PSIQUICO, Efectividad.NORMAL);
                put(TiposPrimitivos.ROCA, Efectividad.NORMAL);
                put(TiposPrimitivos.TIERRA, Efectividad.DEBIL);
                put(TiposPrimitivos.VENENO, Efectividad.NORMAL);
                put(TiposPrimitivos.VOLADOR, Efectividad.FUERTE);
            }}
    ),
    TIERRA(
            new HashMap<TiposPrimitivos, Efectividad>(){{
                put(TiposPrimitivos.AGUA, Efectividad.NORMAL);
                put(TiposPrimitivos.BICHO, Efectividad.DEBIL);
                put(TiposPrimitivos.DRAGON, Efectividad.NORMAL);
                put(TiposPrimitivos.ELECTRICO, Efectividad.FUERTE);
                put(TiposPrimitivos.FANTASMA, Efectividad.NORMAL);
                put(TiposPrimitivos.FUEGO, Efectividad.FUERTE);
                put(TiposPrimitivos.HIELO, Efectividad.NORMAL);
                put(TiposPrimitivos.LUCHA, Efectividad.NORMAL);
                put(TiposPrimitivos.NORMAL, Efectividad.NORMAL);
                put(TiposPrimitivos.PLANTA, Efectividad.DEBIL);
                put(TiposPrimitivos.PSIQUICO, Efectividad.NORMAL);
                put(TiposPrimitivos.ROCA, Efectividad.FUERTE);
                put(TiposPrimitivos.TIERRA, Efectividad.NORMAL);
                put(TiposPrimitivos.VENENO, Efectividad.FUERTE);
                put(TiposPrimitivos.VOLADOR, Efectividad.INUTIL);
            }}
    ),
    VENENO(
            new HashMap<TiposPrimitivos, Efectividad>(){{
                put(TiposPrimitivos.AGUA, Efectividad.NORMAL);
                put(TiposPrimitivos.BICHO, Efectividad.FUERTE);
                put(TiposPrimitivos.DRAGON, Efectividad.NORMAL);
                put(TiposPrimitivos.ELECTRICO, Efectividad.NORMAL);
                put(TiposPrimitivos.FANTASMA, Efectividad.DEBIL);
                put(TiposPrimitivos.FUEGO, Efectividad.NORMAL);
                put(TiposPrimitivos.HIELO, Efectividad.NORMAL);
                put(TiposPrimitivos.LUCHA, Efectividad.NORMAL);
                put(TiposPrimitivos.NORMAL, Efectividad.NORMAL);
                put(TiposPrimitivos.PLANTA, Efectividad.FUERTE);
                put(TiposPrimitivos.PSIQUICO, Efectividad.NORMAL);
                put(TiposPrimitivos.ROCA, Efectividad.DEBIL);
                put(TiposPrimitivos.TIERRA, Efectividad.DEBIL);
                put(TiposPrimitivos.VENENO, Efectividad.DEBIL);
                put(TiposPrimitivos.VOLADOR, Efectividad.NORMAL);
            }}
    ),
    VOLADOR(
            new HashMap<TiposPrimitivos, Efectividad>(){{
                put(TiposPrimitivos.AGUA, Efectividad.NORMAL);
                put(TiposPrimitivos.BICHO, Efectividad.FUERTE);
                put(TiposPrimitivos.DRAGON, Efectividad.NORMAL);
                put(TiposPrimitivos.ELECTRICO, Efectividad.DEBIL);
                put(TiposPrimitivos.FANTASMA, Efectividad.NORMAL);
                put(TiposPrimitivos.FUEGO, Efectividad.NORMAL);
                put(TiposPrimitivos.HIELO, Efectividad.NORMAL);
                put(TiposPrimitivos.LUCHA, Efectividad.FUERTE);
                put(TiposPrimitivos.NORMAL, Efectividad.NORMAL);
                put(TiposPrimitivos.PLANTA, Efectividad.FUERTE);
                put(TiposPrimitivos.PSIQUICO, Efectividad.NORMAL);
                put(TiposPrimitivos.ROCA, Efectividad.DEBIL);
                put(TiposPrimitivos.TIERRA, Efectividad.NORMAL);
                put(TiposPrimitivos.VENENO, Efectividad.NORMAL);
                put(TiposPrimitivos.VOLADOR, Efectividad.NORMAL);
            }}
    );
    
    private final Map<TiposPrimitivos, Efectividad> efectividadMap;
    private static final Map<Tipos, TiposPrimitivos> tiposToTiposBasicosMap;

    static {
        tiposToTiposBasicosMap = new HashMap<Tipos, TiposPrimitivos>() {{
            put(Tipos.AGUA , TiposPrimitivos.AGUA);
            put(Tipos.BICHO, TiposPrimitivos.BICHO);
            put(Tipos.DRAGON, TiposPrimitivos.DRAGON);
            put(Tipos.ELECTRICO, TiposPrimitivos.ELECTRICO);
            put(Tipos.FANTASMA, TiposPrimitivos.FANTASMA);
            put(Tipos.FUEGO, TiposPrimitivos.FUEGO);
            put(Tipos.HIELO, TiposPrimitivos.HIELO);
            put(Tipos.LUCHA, TiposPrimitivos.LUCHA);
            put(Tipos.NORMAL, TiposPrimitivos.NORMAL);
            put(Tipos.PLANTA, TiposPrimitivos.PLANTA);
            put(Tipos.PSIQUICO, TiposPrimitivos.PSIQUICO);
            put(Tipos.ROCA, TiposPrimitivos.ROCA);
            put(Tipos.TIERRA, TiposPrimitivos.TIERRA);
            put(Tipos.VENENO, TiposPrimitivos.VENENO);
            put(Tipos.VOLADOR, TiposPrimitivos.VOLADOR);
        }};
    }

    Tipos(Map<TiposPrimitivos, Efectividad> efectividadMap) {
        this.efectividadMap = Collections.unmodifiableMap(efectividadMap);
    }

    public TiposPrimitivos toBasico() {
        return tiposToTiposBasicosMap.get(this);
    }
}
