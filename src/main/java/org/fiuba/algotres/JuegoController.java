package org.fiuba.algotres;

import java.util.Comparator;

import static org.fiuba.algotres.io.terminal.Herramientas.imprimirDivisor;
import static org.fiuba.algotres.herramientas.Inicializador.inicializarJuego;

public class JuegoController {
    public static void jugarDefault(CampoDeBatalla cdb){
        cdb.setJugadorInicial(Comparator.comparingInt(jugador -> jugador.getPokemonActual().getVelocidad()));

        while(cdb.getGanador() == -1){
            boolean accionCompletada = cdb.turnoJugador();

            if(accionCompletada){
                cdb.setTurnoActual(cdb.siguienteTurno());
                imprimirDivisor();
            }
        }

        System.out.println(cdb.getJugadores()[cdb.getGanador()].getNombre().toUpperCase() + " ES EL GANADOR!!!");
    }

    public static void main(String[] args) {
        CampoDeBatalla juego = inicializarJuego();
        jugarDefault(juego);
    }
}
