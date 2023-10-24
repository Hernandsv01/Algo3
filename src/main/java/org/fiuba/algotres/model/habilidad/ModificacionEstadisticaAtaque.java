package org.fiuba.algotres.model.habilidad;

import org.fiuba.algotres.model.Pokemon;

public class ModificacionEstadisticaAtaque extends ModificacionEstadistica {
    public ModificacionEstadisticaAtaque(String nombre, int usos, Integer porcentaje) {
        super(nombre, usos, porcentaje);
    }

    @Override
    public boolean accionarHabilidad(Pokemon atacante, Pokemon victima) {
        if (verificarUsos(usos)) {
            if (atacante == victima) {
                atacante.modificarAtaque(porcentaje);
            } else {
                victima.modificarAtaque(-porcentaje);
            }
            usos--;
            return true;
        }
        return false;
    }
}
