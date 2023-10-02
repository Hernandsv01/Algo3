package org.fiuba.algotres.comandos;

import org.fiuba.algotres.CampoDeBatalla;

public interface Comando {
    boolean ejecutar(CampoDeBatalla cdb);
    String getNombre();
}
