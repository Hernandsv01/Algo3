package org.fiuba.algotres.inicializadores.json.dto;

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
        put("agua", Tipos.NORMAL);
        put("bicho", Tipos.BICHO);
        put("dragon", Tipos.DRAGON);
        put("electrico", Tipos.ELECTRICO);
        put("fantasma", Tipos.FANTASMA);
        put("fuego", Tipos.FUEGO);
        put("hielo", Tipos.HIELO);
        put("lucha", Tipos.LUCHA);
        put("normal", Tipos.NORMAL);
        put("planta", Tipos.PLANTA);
        put("psiquico", Tipos.PSIQUICO);
        put("roca", Tipos.ROCA);
        put("tierra", Tipos.TIERRA);
        put("veneno", Tipos.VENENO);
        put("volador", Tipos.VOLADOR);
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
