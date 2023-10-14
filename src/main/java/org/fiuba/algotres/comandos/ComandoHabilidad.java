package org.fiuba.algotres.comandos;

import org.fiuba.algotres.CampoDeBatalla;
import org.fiuba.algotres.Jugador;
import org.fiuba.algotres.Pokemon;
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

        Pokemon pokemonActual = cdb.getJugadorActual().getPokemonActual();
        if(pokemonActual.getEstado() != null){
            boolean puedeAccionar = pokemonActual.getEstado().accionar(pokemonActual);
            if(!puedeAccionar){
                Tools.imprimirMensaje("El pokemon esta " + pokemonActual.getEstado().getNombre() + "! No puede hacer nada");
                return true;
            }
            if(pokemonActual.getVidaActual() <= 0){
                Tools.imprimirMensaje("Tu pokemon murio antes de poder hacer nada por estar " + pokemonActual.getEstado().getNombre());
                cdb.getJugadorActual().getPokemonActual().matar();
                if(!cdb.getJugadorActual().getPokemonsVivos().isEmpty()){
                    cdb.getJugadorActual().cambiarPokemonActual(0);
                }
                return true;
            }
        }

        Habilidad habilidad = pokemonActual.getHabilidades().get(opcionElegida-1);
        boolean habilidadExitosa = habilidad.accionarHabilidad(
                pokemonActual,
                cdb.getJugadores()[cdb.getSiguienteTurno()].getPokemonActual()
        );
        if (!habilidadExitosa) {
            Tools.imprimirMensaje("Ya no te quedan usos de " + habilidad.getNombre() + ", elige otra habilidad!");
            return false;
        }
        Tools.imprimirMensaje("Habilidad " + habilidad.getNombre() + " usada!");

        Jugador siguienteJugador = cdb.getJugadores()[cdb.getSiguienteTurno()];
        if(siguienteJugador.getPokemonActual().getVidaActual() <= 0){
            Tools.imprimirMensaje(siguienteJugador.getPokemonActual().getNombre() + " murio!");
            siguienteJugador.getPokemonActual().matar();
            if(!siguienteJugador.getPokemonsVivos().isEmpty()){
                siguienteJugador.cambiarPokemonActual(0);
            }
        }

        return true;
    }

    @Override
    public String getNombre() {
        return NOMBRE;
    }
}
