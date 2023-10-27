package org.fiuba.algotres.model.habilidad;

import org.fiuba.algotres.model.Pokemon;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ModificacionEstadisticaAtaque extends ModificacionEstadistica {

    @JsonCreator
    public ModificacionEstadisticaAtaque(@JsonProperty ("nombre") String nombre,@JsonProperty ("usos") int usos,@JsonProperty ("porcentaje") Integer porcentaje) {
        super(nombre, usos, porcentaje);
    }

    @Override
    public boolean accionarHabilidad(Pokemon atacante, Pokemon victima) {
        if (verificarUsos(usos)) {
            if (atacante == victima) {
                atacante.modificarAtaque(porcentaje);
            } else {
                victima.modificarAtaque(-porcentaje);
            }
            usos--;
        }
        return true;
    }
}
