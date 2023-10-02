package org.fiuba.algotres.habilidad;

import org.fiuba.algotres.Pokemon;
import org.fiuba.algotres.estado.Estado;

public class ModificacionEstado extends Habilidad {
    private final Estado estado;
    public ModificacionEstado(String nombre, int usos, Estado estado) {
        super(nombre, usos);
        this.estado = estado;
    }
    @Override
    public void accionarHabilidad(Pokemon ignorado, Pokemon victima) {
        if (usos <= 0) {
            return;
        }
        if (victima.getEstado() == null) {
            victima.setEstado(this.estado);
            }
        usos--;
    }
}
