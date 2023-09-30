package org.fiuba.algotres.comandos;

import org.fiuba.algotres.Jugador;

public class ParametrosComandoRendirse implements ParametrosComando{
    private Jugador jugador;

    public ParametrosComandoRendirse(Jugador jugador) {
        this.jugador = jugador;
    }

    public Jugador getJugador() {
        return jugador;
    }
}
