package org.fiuba.algotres.persistencia.inicializadores.json.dto;

import lombok.Getter;
import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.clima.*;
import org.fiuba.algotres.model.estado.*;
import org.fiuba.algotres.model.strategies.AtaqueStrategy;
import org.fiuba.algotres.model.strategies.DefensaStrategy;
import org.fiuba.algotres.model.strategies.Strategy;
import org.fiuba.algotres.model.strategies.VidaStrategy;
import org.fiuba.algotres.model.tipos.Tipos;

import java.util.HashMap;
import java.util.Map;

public class Utils {
    private static final Map<String, Tipos> tiposMap = new HashMap<>(){{
        put("AGUA", Tipos.AGUA);
        put("BICHO", Tipos.BICHO);
        put("DRAGON", Tipos.DRAGON);
        put("ELECTRICO", Tipos.ELECTRICO);
        put("FANTASMA", Tipos.FANTASMA);
        put("FUEGO", Tipos.FUEGO);
        put("HIELO", Tipos.HIELO);
        put("LUCHA", Tipos.LUCHA);
        put("NORMAL", Tipos.NORMAL);
        put("PLANTA", Tipos.PLANTA);
        put("PSIQUICO", Tipos.PSIQUICO);
        put("ROCA", Tipos.ROCA);
        put("TIERRA", Tipos.TIERRA);
        put("VENENO", Tipos.VENENO);
        put("VOLADOR", Tipos.VOLADOR);
    }};

    private static final Map<String, Clima> climasMap = new HashMap<>(){{
        put("Huracan", new Huracan("Huracan"));
        put("Lluvia", new Lluvia("Lluvia"));
        put("Niebla", new Niebla("Niebla"));
        put("SinClima", new SinClima("SinClima"));
        put("Soleado", new Soleado("Soleado"));
        put("TormentaArena", new TormentaArena("TormentaArena"));
        put("TormentaRayos", new TormentaRayos("TormentaRayos"));
    }};

    private static final Map<String, Strategy> strategyMap = new HashMap<>(){{
        put("ataque", new AtaqueStrategy());
        put("defensa", new DefensaStrategy());
        put("vida", new VidaStrategy());
    }};

    private static final Map<String, Estado> estadoMap = new HashMap<>(){{
        put("confuso", new Confuso("confuso"));
        put("dormido", new Dormido("dormido"));
        put("envenenado", new Envenenado("envenenado"));
        put("paralizado", new Paralizado("paralizado"));
    }};

    public static Tipos getTipo(String tipo){
        return tiposMap.get(tipo);
    }

    public static Clima getClima(String clima){
        return climasMap.get(clima);
    }

    public static Strategy getStrategy(String estadistica, boolean esPositivo){
        Strategy strat = strategyMap.get(estadistica);
        strat.setEfectoPositivo(esPositivo);
        return strat;
    }

    public static Estado getEstado(String estado){
        return estadoMap.get(estado);
    }
}
