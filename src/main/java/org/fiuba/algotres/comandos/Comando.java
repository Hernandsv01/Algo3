package org.fiuba.algotres.comandos;

import java.util.Map;

public interface Comando {
    boolean ejecutar(Map<String, Object> parametros);
    boolean parametrosValidos(Map<String, Object> parametros);
}
