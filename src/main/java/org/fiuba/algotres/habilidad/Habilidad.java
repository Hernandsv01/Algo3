package org.fiuba.algotres.habilidad;

import lombok.Data;
import org.fiuba.algotres.Pokemon;

@Data
public abstract class Habilidad {
    private final String nombre;
    protected int usos;

    public Habilidad(String nombre, int usos) {
        this.nombre = nombre;
        this.usos = usos;
    }

    public abstract void accionarHabilidad(Pokemon atacante, Pokemon victima);
}
