package org.fiuba.algotres.habilidad;

import org.fiuba.algotres.Pokemon;
import org.fiuba.algotres.estado.Estado;

public class ModificacionEstado extends Habilidad {
    private final String tipo;
    public ModificacionEstado(String nombre, int usos, String tipo) {
        super(nombre, usos);
        this.tipo = tipo;
    }
    @Override
    public void accionarHabilidad(Pokemon atacante, Pokemon victima) {
        if (victima.getEstado() == null) {
            switch (tipo) {
                case Estado.DORMIDO:
                    victima.setEstado(new Estado("dormido"));
                case Estado.PARALIZADO:
                    victima.setEstado(new Estado("paralizado"));
                case Estado.ENVENENADO:
                    victima.setEstado(new Estado("envenenado"));
            }
        }
    }
}
