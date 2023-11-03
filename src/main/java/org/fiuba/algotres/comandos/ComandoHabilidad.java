package org.fiuba.algotres.comandos;

import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.Jugador;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.estado.Estado;
import org.fiuba.algotres.model.habilidad.Habilidad;
import org.fiuba.algotres.views.terminal.PokemonView;
import org.fiuba.algotres.views.terminal.Tools;

import java.util.ArrayList;
import org.fiuba.algotres.views.InputUsuario;

public class ComandoHabilidad extends Comando {
    public ComandoHabilidad(String nombre, InputUsuario input) {
        super(nombre, input);
    }

    @Override
    public boolean ejecutar(CampoDeBatalla cdb) {
        System.out.println("Elige la habilidad");
        int opciones = PokemonView.imprimirHabilidadesPokemon(cdb.getJugadorActual().getPokemonActual());
        if (opciones == 0) {
            Tools.imprimirMensajeConEspera(input, "No te quedan mas habilidades en este pokemon :(");
            return false;
        }
        int opcionElegida = input.obtenerOpcionUsuario(opciones);

        if (opcionElegida == opciones) return false;

        Pokemon pokemonActual = cdb.getJugadorActual().getPokemonActual();

        Pokemon victima = cdb.getJugadores()[cdb.getSiguienteTurno()].getPokemonActual();
        if(!pokemonActual.getEstados().isEmpty()) {
            boolean puedeAccionar = true;
            String estadoInhabilitante = "";
            for(Estado estado : pokemonActual.getEstados()) {
                puedeAccionar = estado.accionar();
                if (!puedeAccionar && estadoInhabilitante.equals("")) {
                    estadoInhabilitante = estado.getNombre();
                }
            }
            pokemonActual.limpiarEstados();
            if(!puedeAccionar){
                Tools.imprimirMensaje("El pokemon esta " + estadoInhabilitante + "! No puede hacer nada");
                return true;
            }
            if(!pokemonActual.estaVivo()){
                Tools.imprimirMensajeConEspera(input, "Tu pokemon murio antes de poder hacer nada!");
                reemplazarPokemonMuerto(cdb.getJugadorActual());
                return true;
            }
        }
        cdb.getClima().aplicarEfectos(pokemonActual);
        if(!pokemonActual.estaVivo()) {
            Tools.imprimirMensajeConEspera(input, "Tu pokemon murio antes de poder hacer nada por el clima ");
            reemplazarPokemonMuerto(cdb.getJugadorActual());
            return true;
        }
        Habilidad habilidad = pokemonActual.getHabilidades().get(opcionElegida-1);
        boolean habilidadExitosa = habilidad.accionarHabilidad(
                pokemonActual,
                victima
        );
        if (!habilidadExitosa) {
            Tools.imprimirMensajeConEspera(input, "Ya no te quedan usos de " + habilidad.getNombre() + ", elige otra habilidad!");
            return false;
        }
        Tools.imprimirMensajeConEspera(input, "Habilidad " + habilidad.getNombre() + " usada!");

        Jugador siguienteJugador = cdb.getJugadores()[cdb.getSiguienteTurno()];
        if(!siguienteJugador.getPokemonActual().estaVivo()){
            Tools.imprimirMensajeConEspera(input, siguienteJugador.getPokemonActual().getNombre() + " murio!");
            reemplazarPokemonMuerto(siguienteJugador);
        }

        return true;
    }
}
