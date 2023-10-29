package org.fiuba.algotres.views.terminal;

import org.fiuba.algotres.model.CampoDeBatalla;

public class CampoDeBatallaView {
    public static void imprimirCampo(CampoDeBatalla cdb){
        for(int i = 0; i < cdb.getJugadores().length; i++) {
            System.out.println(cdb.getJugadores()[i].getNombre());

            System.out.print(cdb.getJugadores()[i].getPokemonActual().getNombre());
            if (cdb.getJugadores()[i].getPokemonActual().getEstado() != null) {
                System.out.println(" (" + cdb.getJugadores()[i].getPokemonActual().getEstado().getNombre() + ")");
            } else {
                System.out.println();
            }

            System.out.println(cdb.getJugadores()[i].getPokemonActual().getVidaActual() + "❤️/"
                             + cdb.getJugadores()[i].getPokemonActual().getVidaMaxima() + "❤\uFE0F");
            System.out.println();
        }
        System.out.println("Clima actual: " + cdb.getClima().getNombre());
        System.out.println("Turno actual: " + cdb.getJugadorActual().getNombre());
        System.out.println();
    }
}
