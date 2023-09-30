package org.fiuba.algotres.comandos;

import org.fiuba.algotres.Jugador;
import org.fiuba.algotres.Pokemon;
import org.fiuba.algotres.habilidad.Habilidad;
import org.fiuba.algotres.item.Item;

import java.util.Map;

public class ComandoItem implements Comando<ParametrosComandoItem> {
    @Override
    public boolean ejecutar(ParametrosComandoItem parametros) {
        return false;
    }
}
