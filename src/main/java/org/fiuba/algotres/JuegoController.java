package org.fiuba.algotres;

import static org.fiuba.algotres.io.terminal.Herramientas.imprimirDivisor;
import static org.fiuba.algotres.herramientas.Inicializador.inicializarJuego;

public class JuegoController {
    public static void jugar(CampoDeBatalla cdb){
        cdb.comenzarBatalla();

        int opcionElegida;
        boolean accionCompletada;

        /* FALTA APLICAR ESTADOS */

        while(cdb.getGanador() == -1){
            accionCompletada = cdb.turnoJugador();

            if(accionCompletada){
                cdb.setTurnoActual(cdb.siguienteTurno());
                imprimirDivisor();
            }
        }

        System.out.println("EL JUGADOR " + cdb.getGanador() + " ES EL GANADOR!!!");
    }

    public static void main(String[] args) {
        CampoDeBatalla juego = inicializarJuego();
        jugar(juego);
    }
}
