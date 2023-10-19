package org.fiuba.algotres.model.habilidad;

import org.fiuba.algotres.model.Pokemon;

public class ModificacionEstadisticaDefensa extends ModificacionEstadistica{
    public ModificacionEstadisticaDefensa(String nombre, int usos, Integer porcentaje) {
        super(nombre, usos, porcentaje);
    }

    @Override
    public boolean accionarHabilidad(Pokemon atacante, Pokemon victima) {
        if (usos <= 0) {
            return false;
        }
        if (atacante == victima) {
            atacante.modificarDefensa(porcentaje);
        } else {
            victima.modificarDefensa(-porcentaje);
        }
        usos--;
        return true;
    }
}
