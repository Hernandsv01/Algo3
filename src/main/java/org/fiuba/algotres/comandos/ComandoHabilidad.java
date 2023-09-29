package org.fiuba.algotres.comandos;

import java.util.Map;

public class ComandoHabilidad implements Comando {
    /**
     * @param parametros Especificar los parametros que deben estar adentro del map
     */
    @Override
    public boolean ejecutar(Map<String, Object> parametros) {
        return false;
    }

    @Override
    public boolean verificarParametros(Map<String, Object> parametros) {
        return false;
    }
}
