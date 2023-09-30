package org.fiuba.algotres.comandos;

public class ComandoItem implements Comando<ParametrosComandoItem> {
    @Override
    public boolean ejecutar(ParametrosComandoItem parametros) {
        return parametros.getItem().usar(parametros.getPokemon());
    }
}
