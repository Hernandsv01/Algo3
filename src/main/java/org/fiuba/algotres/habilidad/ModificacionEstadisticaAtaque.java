package org.fiuba.algotres.habilidad;

import org.fiuba.algotres.Pokemon;

public class ModificacionEstadisticaAtaque extends ModificacionEstadistica {
    public ModificacionEstadisticaAtaque(String nombre, int usos, Integer porcentaje) {
        super(nombre, usos, porcentaje);
    }

    @Override
    public void accionarHabilidad(Pokemon atacante, Pokemon victima) {
        super.accionarHabilidad(atacante, victima);
        if (atacante == victima) {
            atacante.modificarAtaque(porcentaje);
        } else {
            victima.modificarAtaque(-porcentaje);
        }
        usos--;
    }
}
