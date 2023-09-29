package org.fiuba.algotres.comandos;

import org.fiuba.algotres.CampoDeBatalla;

import java.util.Map;

public interface Comando {
    boolean ejecutar(Map<String, Object> parametros);
    boolean verificarParametros(Map<String, Object> parametros);
}
