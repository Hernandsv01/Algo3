package org.fiuba.algotres.comandos;

import org.fiuba.algotres.Pokemon;
import org.fiuba.algotres.habilidad.Habilidad;

import java.util.Map;

public class ComandoHabilidad implements Comando<ParametrosComandoHabilidad> {
    /**
     * @param parametros Especificar los parametros que deben estar adentro del map
     */
    @Override
    public boolean ejecutar(ParametrosComandoHabilidad parametros) {
        return false;
    }
}
