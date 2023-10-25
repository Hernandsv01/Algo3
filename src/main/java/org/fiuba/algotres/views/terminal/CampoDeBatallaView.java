package org.fiuba.algotres.views.terminal;

import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.estado.Estado;

public class CampoDeBatallaView {
    public static void imprimirCampo(CampoDeBatalla cdb){
        for(int i = 0; i < cdb.getJugadores().length; i++) {

            System.out.println(cdb.getJugadores()[i].getNombre());

            System.out.print(cdb.getJugadores()[i].getPokemonActual().getNombre());
            if (!cdb.getJugadores()[i].getPokemonActual().getEstados().isEmpty()) {
                for (Estado estado : cdb.getJugadores()[i].getPokemonActual().getEstados()) {
                    System.out.println(" (" + estado.getNombre() + ")");
                }
            } else {
                System.out.println();
            }

            System.out.println(cdb.getJugadores()[i].getPokemonActual().getVidaActual() + "❤️/"
                             + cdb.getJugadores()[i].getPokemonActual().getVidaMaxima() + "❤\uFE0F");
            System.out.println();
        }
        System.out.println("Turno actual: " + cdb.getJugadorActual().getNombre());
        System.out.println();
    }
}
