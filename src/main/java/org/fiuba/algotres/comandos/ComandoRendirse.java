package org.fiuba.algotres.comandos;

import org.fiuba.algotres.CampoDeBatalla;

public class ComandoRendirse implements Comando {
    
    private final String NOMBRE = "Rendirse";
    
    @Override
    public boolean ejecutar(CampoDeBatalla cdb) {
        cdb.getJugadorActual().rendirse();
        return true;
    }

    @Override
    public String getNombre() {
        return NOMBRE;
    }
}
