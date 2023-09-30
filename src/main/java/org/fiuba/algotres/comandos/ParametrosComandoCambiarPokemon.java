package org.fiuba.algotres.comandos;

import org.fiuba.algotres.Jugador;

public class ParametrosComandoCambiarPokemon implements ParametrosComando{
    private Jugador jugador;
    private int posPokemon;

    public Jugador getJugador() {
        return jugador;
    }

    public int getPosPokemon() {
        return posPokemon;
    }
}
