package org.fiuba.algotres.model.habilidad;

import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.estado.Estado;

public class ModificacionEstado extends Habilidad {
    private final Estado estado;
    public ModificacionEstado(String nombre, int usos, Estado estado) {
        super(nombre, usos);
        this.estado = estado;
    }
    @Override
    public boolean accionarHabilidad(Pokemon ignorado, Pokemon victima) {
        if (verificarUsos(usos)) {
          if (!victima.getEstados().isEmpty()) {
            victima.agregarEstado(this.estado);
            usos--;
            return true;
            }
        }
      return false;
    }
}
