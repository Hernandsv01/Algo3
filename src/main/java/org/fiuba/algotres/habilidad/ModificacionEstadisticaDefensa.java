package org.fiuba.algotres.habilidad;

import org.fiuba.algotres.Pokemon;

public class ModificacionEstadisticaDefensa extends ModificacionEstadistica{
    public ModificacionEstadisticaDefensa(String nombre, int usos, Integer porcentaje) {
        super(nombre, usos, porcentaje);
    }

    @Override
    public void accionarHabilidad(Pokemon atacante, Pokemon victima) {
        super.accionarHabilidad(atacante, victima);
        if (atacante == victima) {
            atacante.modificarDefensa(porcentaje);
        } else {
            victima.modificarDefensa(-porcentaje);
        }
        usos--;
    }
}
