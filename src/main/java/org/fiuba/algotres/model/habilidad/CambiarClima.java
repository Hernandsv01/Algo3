package org.fiuba.algotres.model.habilidad;

import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.clima.Climas;

public class CambiarClima extends Habilidad{

    private final Climas clima;

    public CambiarClima(String nombre, int usos, Climas clima){
        super(nombre,usos);
        this.clima = clima;
    }

    @Override
    public boolean accionarHabilidad(Pokemon atacante, Pokemon victima) {
        if (usos <= 0) {
            return false;
        }
        this.clima.getCdb().setClima(this.clima);
        usos--;
        return true;
    }
}
