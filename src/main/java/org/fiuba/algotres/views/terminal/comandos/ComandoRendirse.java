package org.fiuba.algotres.views.terminal.comandos;

import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.views.InputUsuario;

public class ComandoRendirse extends Comando {
    public ComandoRendirse(String nombre, InputUsuario input) {
        super(nombre, input);
    }

    @Override
    public boolean ejecutar(CampoDeBatalla cdb) {
        cdb.getJugadorActual().rendirse();
        return true;
    }
}
