package org.fiuba.algotres.model.habilidad;

import org.fiuba.algotres.model.Pokemon;

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
        if (verificarUsos(usos)) {
            atacante.curarPorPorcentaje(porcentaje);
            usos--;
            return true;
        }
        return false;
    }
}
