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
            int defensaPropio = atacante.getDefensa();
            atacante.setDefensa(Math.round((float) (porcentaje/100) * defensaPropio) + defensaPropio);
        } else {
            int defensaContrincante = victima.getDefensa();
            victima.setDefensa(defensaContrincante - Math.round((float) (porcentaje/100) * defensaContrincante));
        }
        usos--;
    }
}
