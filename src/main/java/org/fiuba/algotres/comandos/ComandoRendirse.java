package org.fiuba.algotres.comandos;

public class ComandoRendirse implements Comando<ParametrosComandoRendirse> {
    @Override
    public boolean ejecutar(ParametrosComandoRendirse parametros) {
        parametros.getJugador().rendirse();
        return true;
    }
}
