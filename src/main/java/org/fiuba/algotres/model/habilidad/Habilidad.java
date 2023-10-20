package org.fiuba.algotres.model.habilidad;

import lombok.Getter;
import lombok.Setter;
import org.fiuba.algotres.model.Pokemon;

@Setter @Getter
public abstract class Habilidad {
    private final String nombre;
    protected int usos;

    public Habilidad(String nombre, int usos) {
        this.nombre = nombre;
        this.usos = usos;
    }

    public abstract boolean accionarHabilidad(Pokemon atacante, Pokemon victima);

    boolean verificarUsos(int usos) {
        return usos > 0;
    }
}
