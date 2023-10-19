package org.fiuba.algotres.model.habilidad;

import org.fiuba.algotres.model.Pokemon;

public abstract class ModificacionEstadistica extends Habilidad{
    protected final Integer porcentaje;

    public ModificacionEstadistica(String nombre, int usos, Integer porcentaje) {
        super(nombre, usos);
        this.porcentaje = porcentaje;
    }

    /**
     * @param atacante pokemon propio.
     * @param victima pokemon contrario.
     */
    @Override
    public abstract boolean accionarHabilidad(Pokemon atacante, Pokemon victima);
}
