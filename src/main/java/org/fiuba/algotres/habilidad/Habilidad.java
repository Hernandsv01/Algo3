package org.fiuba.algotres.habilidad;

import lombok.Data;
import org.fiuba.algotres.Pokemon;

@Data
public abstract class Habilidad {
    private final String nombre;
    public abstract void accionarHabilidad(Pokemon atacante, Pokemon victima);
}
