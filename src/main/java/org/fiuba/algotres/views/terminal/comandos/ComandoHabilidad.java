package org.fiuba.algotres.views.terminal.comandos;

import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.Jugador;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.estado.Estado;
import org.fiuba.algotres.model.habilidad.Habilidad;
import org.fiuba.algotres.views.terminal.HabilidadView;
import org.fiuba.algotres.views.terminal.PokemonView;
import org.fiuba.algotres.views.terminal.Tools;

import org.fiuba.algotres.views.InputUsuario;

public class ComandoHabilidad extends Comando {
    public ComandoHabilidad(String nombre, InputUsuario input) {
        super(nombre, input);
    }

    @Override
    public boolean ejecutar(CampoDeBatalla cdb) {
        System.out.println("Elige la habilidad");
        int opciones = PokemonView.imprimirHabilidadesPokemon(cdb.getJugadorActual().getPokemonActual());
        int opcionElegida = input.obtenerOpcionUsuario(opciones);
        if (opcionElegida == opciones) return false;

        Pokemon pokemonActual = cdb.getJugadorActual().getPokemonActual();

        //Clima
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
                Tools.imprimirMensajeConEspera("El pokemon esta " + estadoInhabilitante + "! No puede hacer nada");
                return true;
            }
            if(!pokemonActual.estaVivo()){
                Tools.imprimirMensajeConEspera("Tu pokemon murio antes de poder hacer nada!");
                reemplazarPokemonMuerto(cdb.getJugadorActual());
                return true;
            }
        }

        // Estados
        cdb.getClima().aplicarEfectos(pokemonActual);
        if(!pokemonActual.estaVivo()) {
            Tools.imprimirMensajeConEspera("Tu pokemon murio antes de poder hacer nada por el clima ");
            reemplazarPokemonMuerto(cdb.getJugadorActual());
            return true;
        }

        // Accionar habilidad
        Habilidad habilidad = pokemonActual.getHabilidades().get(opcionElegida-1);
        boolean habilidadExitosa = habilidad.accionarHabilidad(
                pokemonActual,
                victima
        );
        if (!habilidadExitosa) {
            Tools.imprimirMensajeConEspera("Ya no te quedan usos de " + habilidad.getNombre() + ", elige otra habilidad!");
            return false;
        }
        HabilidadView.mostrarEfectoHabilidad(habilidad, pokemonActual, victima);
        Tools.esperarEnter();

        Jugador siguienteJugador = cdb.getJugadores()[cdb.getSiguienteTurno()];
        if(!siguienteJugador.getPokemonActual().estaVivo()){
            Tools.imprimirMensajeConEspera(siguienteJugador.getPokemonActual().getNombre() + " murio!");
            reemplazarPokemonMuerto(siguienteJugador);
        }

        return true;
    }
}
