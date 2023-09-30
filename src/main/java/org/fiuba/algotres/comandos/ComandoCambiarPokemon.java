package org.fiuba.algotres.comandos;

public class ComandoCambiarPokemon implements Comando<ParametrosComandoCambiarPokemon> {
    @Override
    public boolean ejecutar(ParametrosComandoCambiarPokemon parametros) {
        return parametros.getJugador().cambiarPokemonActual(parametros.getPosPokemon());
    }
}
