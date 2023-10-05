package org.fiuba.algotres.habilidad;

import org.fiuba.algotres.Pokemon;

public class ModificacionEstadisticaAtaque extends ModificacionEstadistica {
    public ModificacionEstadisticaAtaque(String nombre, int usos, Integer porcentaje) {
        super(nombre, usos, porcentaje);
    }

    @Override
    public boolean accionarHabilidad(Pokemon atacante, Pokemon victima) {
        if (usos <= 0) {
            return false;
        }
        if (atacante == victima) {
            atacante.modificarAtaque(porcentaje);
        } else {
            victima.modificarAtaque(-porcentaje);
        }
        usos--;
        return true;
    }
}
