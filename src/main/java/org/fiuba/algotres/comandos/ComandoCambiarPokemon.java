package org.fiuba.algotres.comandos;

import org.fiuba.algotres.CampoDeBatalla;
import org.fiuba.algotres.views.terminal.InputUsuario;
import org.fiuba.algotres.views.terminal.JugadorView;

public class ComandoCambiarPokemon implements Comando {
    
    private final String NOMBRE = "Cambiar Pokemon";
    
    @Override
    public boolean ejecutar(CampoDeBatalla cdb) {
        int opciones;
        int opcionElegida;
        opciones = JugadorView.imprimirPokemonsActivos(cdb.getJugadores()[cdb.getTurnoActual()]);
        if(opciones == 0) return false;
        opcionElegida = InputUsuario.obtenerOpcionUsuario(opciones);
        if(opcionElegida == opciones) return false;
        return cdb.getJugadores()[cdb.getTurnoActual()].cambiarPokemonActual(opcionElegida);
    }

    @Override
    public String getNombre() {
        return NOMBRE;
    }
}
