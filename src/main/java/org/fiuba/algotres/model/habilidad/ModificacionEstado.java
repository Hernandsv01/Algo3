package org.fiuba.algotres.model.habilidad;

import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.estado.Estado;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ModificacionEstado extends Habilidad {
    private final Estado estado;
    @JsonCreator
    public ModificacionEstado(@JsonProperty ("nombre") String nombre,@JsonProperty ("usos") int usos,@JsonProperty ("estado") Estado estado) {
        super(nombre, usos);
        this.estado = estado;
    }
    @Override
    public boolean accionarHabilidad(Pokemon ignorado, Pokemon victima) {
        if (verificarUsos(usos)) {
            victima.agregarEstado(this.estado);
            usos--;
            return true;
        }
      return false;
    }

    public Estado getEstado(){
        return this.estado;
    }
}
