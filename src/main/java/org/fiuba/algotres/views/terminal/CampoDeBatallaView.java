package org.fiuba.algotres.views.terminal;

import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.estado.Estado;
import org.fiuba.algotres.views.OutputUsuario;

public class CampoDeBatallaView {

    private static OutputUsuario output = new OutputUsuarioTerminal();

    public static void imprimirCampo(CampoDeBatalla cdb){
        for(int i = 0; i < cdb.getJugadores().length; i++) {

            output.mostrarLinea(cdb.getJugadores()[i].getNombre());

            output.mostrar(cdb.getJugadores()[i].getPokemonActual().getNombre());
            if (!cdb.getJugadores()[i].getPokemonActual().getEstados().isEmpty()) {
                for (Estado estado : cdb.getJugadores()[i].getPokemonActual().getEstados()) {
                    output.mostrarLinea(" (" + estado.getNombre() + ")");
                }
            } else {
                output.siguienteLinea();
            }

            output.mostrarLinea(cdb.getJugadores()[i].getPokemonActual().getVidaActual() + "❤️/"
                             + cdb.getJugadores()[i].getPokemonActual().getVidaMaxima() + "❤\uFE0F");
            output.siguienteLinea();
        }
        output.mostrarLinea("Clima actual: " + cdb.getClima().getNombre());
        output.mostrarLinea("Turno actual: " + cdb.getJugadorActual().getNombre());
        output.siguienteLinea();
    }

    public void setOutput(OutputUsuario output){
        CampoDeBatallaView.output = output;
    }
}
