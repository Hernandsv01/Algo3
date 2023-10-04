package org.fiuba.algotres.comandos;

import org.fiuba.algotres.CampoDeBatalla;
import org.fiuba.algotres.views.terminal.InputUsuario;
import org.fiuba.algotres.views.terminal.JugadorView;
import org.fiuba.algotres.views.terminal.Tools;

public class ComandoCambiarPokemon implements Comando {
    
    private final String NOMBRE = "Cambiar Pokemon";
    
    @Override
    public boolean ejecutar(CampoDeBatalla cdb) {
        System.out.println("Elija el pokemon");
        int opciones = JugadorView.imprimirPokemons(cdb.getJugadorActual().getPokemonsActivos());
        if(opciones == 0){
            Tools.imprimirMensaje("No te quedan mas pokemons con vida :(");
            return false;
        }

        int opcionElegida = InputUsuario.obtenerOpcionUsuario(opciones);
        if(opcionElegida == opciones) return false;

        boolean opExitosa = cdb.getJugadorActual().cambiarPokemonActual(opcionElegida-1);
        if(opExitosa){
            Tools.imprimirMensaje(cdb.getJugadorActual().getPokemonActual().getNombre() + " entra a la batalla!");
        }
        return opExitosa;
    }

    @Override
    public String getNombre() {
        return NOMBRE;
    }
}
