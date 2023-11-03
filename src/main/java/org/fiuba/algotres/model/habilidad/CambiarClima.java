package org.fiuba.algotres.model.habilidad;

import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.clima.Clima;

public class CambiarClima extends Habilidad{

    private final Clima clima;

    public CambiarClima(String nombre, int usos, Clima clima){
        super(nombre,usos);
        this.clima = clima;
    }

    @Override
    public boolean accionarHabilidad(Pokemon atacante, Pokemon victima) {
        if (verificarUsos(usos)) {
            this.clima.setTurnosAplicados(0);
            this.clima.getCdb().setClima(this.clima);
            usos--;
            return true;
        }
        return false;
    }
}
