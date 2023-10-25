package org.fiuba.algotres.comandos;

import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.Jugador;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.estado.Estado;
import org.fiuba.algotres.model.habilidad.Habilidad;
import org.fiuba.algotres.views.terminal.InputUsuario;
import org.fiuba.algotres.views.terminal.PokemonView;
import org.fiuba.algotres.views.terminal.Tools;

import java.util.ArrayList;

public class ComandoHabilidad extends Comando {
    public ComandoHabilidad(String nombre) {
        super(nombre);
    }

    @Override
    public boolean ejecutar(CampoDeBatalla cdb) {
        System.out.println("Elige la habilidad");
        int opciones = PokemonView.imprimirHabilidadesPokemon(cdb.getJugadorActual().getPokemonActual());
        if (opciones == 0) {
            Tools.imprimirMensaje("No te quedan mas habilidades en este pokemon :(");
            return false;
        }
        int opcionElegida = InputUsuario.obtenerOpcionUsuario(opciones);

        if (opcionElegida == opciones) return false;

        Pokemon pokemonActual = cdb.getJugadorActual().getPokemonActual();

        Pokemon victima = cdb.getJugadores()[cdb.getSiguienteTurno()].getPokemonActual();
        if(!pokemonActual.getEstados().isEmpty()) {
            boolean puedeAccionar = true;
            ArrayList<String> estadosInhabilitantes = new ArrayList<>();
            for(Estado estado : pokemonActual.getEstados()) {
                if ("Confuso".equals(estado.getNombre()) && !estado.accionar(pokemonActual)) {
                    victima = pokemonActual;
                } else {
                    puedeAccionar = estado.accionar(pokemonActual);
                    estadosInhabilitantes.add(estado.getNombre());
                }
            }
            if(!puedeAccionar){
                for (String strEstado: estadosInhabilitantes) {
                    Tools.imprimirMensaje("El pokemon esta " + strEstado + "! No puede hacer nada");
                }
                return true;
            }
            if(!pokemonActual.estaVivo()){
                Tools.imprimirMensaje("Tu pokemon murio antes de poder hacer nada!");
                reemplazarPokemonMuerto(cdb.getJugadorActual());
                return true;
            }
        }

        Habilidad habilidad = pokemonActual.getHabilidades().get(opcionElegida-1);
        boolean habilidadExitosa = habilidad.accionarHabilidad(
                pokemonActual,
                victima
        );
        if (!habilidadExitosa) {
            Tools.imprimirMensaje("Ya no te quedan usos de " + habilidad.getNombre() + ", elige otra habilidad!");
            return false;
        }
        Tools.imprimirMensaje("Habilidad " + habilidad.getNombre() + " usada!");

        Jugador siguienteJugador = cdb.getJugadores()[cdb.getSiguienteTurno()];
        if(!siguienteJugador.getPokemonActual().estaVivo()){
            Tools.imprimirMensaje(siguienteJugador.getPokemonActual().getNombre() + " murio!");
            reemplazarPokemonMuerto(siguienteJugador);
        }

        return true;
    }
}
