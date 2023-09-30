package org.fiuba.algotres.comandos;

public interface Comando<T extends ParametrosComando> {
    boolean ejecutar(T parametros);
}
