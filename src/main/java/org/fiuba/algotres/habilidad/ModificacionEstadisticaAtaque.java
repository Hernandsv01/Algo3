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
            int ataquePropio = atacante.getAtaque();
            atacante.setAtaque(Math.round((float) (porcentaje/100) * ataquePropio) + ataquePropio);
        } else {
            int ataqueContrincante = victima.getAtaque();
            victima.setAtaque(ataqueContrincante - Math.round((float) (porcentaje/100) * ataqueContrincante));
        }
        usos--;
    }
}
