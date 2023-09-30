package org.fiuba.algotres.comandos;

import java.util.Map;

public interface Comando<T extends ParametrosComando> {
    boolean ejecutar(T parametros);
}
