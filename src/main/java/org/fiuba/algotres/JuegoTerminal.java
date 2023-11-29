package org.fiuba.algotres;

import org.fiuba.algotres.controllers.terminal.TerminalController;
import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.views.terminal.InputUsuarioTerminal;

import static org.fiuba.algotres.persistencia.inicializadores.java.Inicializador.inicializarJuego;
import static org.fiuba.algotres.persistencia.inicializadores.json.JSONInitializer.loadCampoDeBatalla;

public class JuegoTerminal {

    public static void main(String[] args) {
        // Loaders
//        CampoDeBatalla juego = inicializarJuego();
        CampoDeBatalla juego = loadCampoDeBatalla();

        // Inicio juego consola
        TerminalController.inicializarConfiguracion(new InputUsuarioTerminal());
        TerminalController.jugar(juego);
    }
}
