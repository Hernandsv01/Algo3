package org.fiuba.algotres.model.habilidad;

import org.fiuba.algotres.model.Pokemon;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class ModificacionEstadisticaVida extends ModificacionEstadistica {

    @JsonCreator
    public ModificacionEstadisticaVida(@JsonProperty ("nombre") String nombre,@JsonProperty ("usos") int usos,@JsonProperty ("porcentaje") Integer porcentaje) {
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
        }
        return true;
    }
}
