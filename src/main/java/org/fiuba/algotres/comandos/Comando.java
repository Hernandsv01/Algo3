package org.fiuba.algotres.comandos;

import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.Jugador;
import org.fiuba.algotres.views.terminal.InputUsuario;
import org.fiuba.algotres.views.terminal.PokemonView;
import org.fiuba.algotres.views.terminal.Tools;

public abstract class Comando {
    private final String nombre;

    public Comando(String nombre){
        this.nombre = nombre;
    }

    public abstract boolean ejecutar(CampoDeBatalla cdb);

    public void reemplazarPokemonMuerto(Jugador jugador){
        if(jugador.getPokemonsVivos().isEmpty()) {
            return;
        }
        System.out.println("Elija el pokemon de reemplazo");
        int opciones = PokemonView.imprimirPokemons(jugador.getPokemonsVivos(), false);
        int opcionElegida = InputUsuario.obtenerOpcionUsuario(opciones);

        jugador.cambiarPokemonActual(opcionElegida-1);
        Tools.imprimirMensaje(jugador.getPokemonActual().getNombre() + " entra a la batalla!");
    }

    public String getNombre(){
        return nombre;
    };
}
