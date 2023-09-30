package org.fiuba.algotres.comandos;

import org.fiuba.algotres.Pokemon;
import org.fiuba.algotres.habilidad.Habilidad;

public class ParametrosComandoHabilidad implements ParametrosComando{
    private Pokemon atacante;
    private Habilidad habilidad;
    private Pokemon victima;

    public ParametrosComandoHabilidad(Pokemon atacante, Habilidad habilidad, Pokemon victima) {
        this.atacante = atacante;
        this.habilidad = habilidad;
        this.victima = victima;
    }

    public Pokemon getAtacante() {
        return atacante;
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public Pokemon getVictima() {
        return victima;
    }
}
