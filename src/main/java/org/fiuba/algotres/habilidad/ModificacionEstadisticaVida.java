package org.fiuba.algotres.habilidad;

import org.fiuba.algotres.Pokemon;

public class ModificacionEstadisticaVida extends ModificacionEstadistica {
    public ModificacionEstadisticaVida(String nombre, int usos, Integer porcentaje) {
        super(nombre, usos, porcentaje);
    }

    /**
     * @inheritDoc
     * @param atacante pokemon propio.
     * @param ignorado debe ser null.
     */
    @Override
    public boolean accionarHabilidad(Pokemon atacante, Pokemon ignorado) {
        if (usos <= 0) {
            return false;
        }
        atacante.curarPorPorcentaje(porcentaje);
        usos--;
        return true;
    }
}
