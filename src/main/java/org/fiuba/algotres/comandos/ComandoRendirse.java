package org.fiuba.algotres.comandos;

import org.fiuba.algotres.CampoDeBatalla;

public class ComandoRendirse extends Comando {
    public ComandoRendirse(String nombre) {
        super(nombre);
    }

    @Override
    public boolean ejecutar(CampoDeBatalla cdb) {
        cdb.getJugadorActual().rendirse();
        return true;
    }
}
