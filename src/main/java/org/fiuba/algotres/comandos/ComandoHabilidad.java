package org.fiuba.algotres.comandos;

import org.fiuba.algotres.CampoDeBatalla;
import org.fiuba.algotres.habilidad.Habilidad;
import org.fiuba.algotres.views.terminal.InputUsuario;
import org.fiuba.algotres.views.terminal.PokemonView;
import org.fiuba.algotres.views.terminal.Tools;

public class ComandoHabilidad implements Comando {
    
    private final String NOMBRE = "Usar habilidad";
    
    @Override
    public boolean ejecutar(CampoDeBatalla cdb) {
        System.out.println("Elige la habilidad");
        int opciones = PokemonView.imprimirHabilidadesPokemon(cdb.getJugadorActual().getPokemonActual());
        if(opciones == 0){
            Tools.imprimirMensaje("No te quedan mas habilidades en este pokemon :(");
            return false;
        }
        int opcionElegida = InputUsuario.obtenerOpcionUsuario(opciones);
        
        if(opcionElegida == opciones) return false;
        
        Habilidad habilidad = cdb.getJugadorActual().getPokemonActual().getHabilidades().get(opcionElegida-1);
        boolean verificador = habilidad.accionarHabilidad(
                cdb.getJugadorActual().getPokemonActual(),
                cdb.getJugadores()[cdb.getSiguienteTurno()].getPokemonActual()
        );
        if (verificador) {
            Tools.imprimirMensaje("Habilidad " + habilidad.getNombre() + " usada!");
        } else {
            Tools.imprimirMensaje("Ya no te quedan usos de " + habilidad.getNombre() + ", elije otra habilidad!");
            return false;
        }
        return true;
    }

    @Override
    public String getNombre() {
        return NOMBRE;
    }
}
