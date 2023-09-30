package org.fiuba.algotres.comandos;

import org.fiuba.algotres.Jugador;
import org.fiuba.algotres.Pokemon;
import org.fiuba.algotres.item.Item;

import java.util.Map;

public class ComandoRendirse implements Comando<ParametrosComandoRendirse> {
    @Override
    public boolean ejecutar(ParametrosComandoRendirse parametros) {
        return false;
    }
}
