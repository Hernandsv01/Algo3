package org.fiuba.algotres.comandos;

import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.estado.Estado;
import org.fiuba.algotres.views.InputUsuario;
import org.fiuba.algotres.views.terminal.InputUsuarioTerminal;
import org.fiuba.algotres.views.terminal.PokemonView;
import org.fiuba.algotres.views.terminal.Tools;

public class ComandoCambiarPokemon extends Comando {
    public ComandoCambiarPokemon(String nombre, InputUsuario input) {
        super(nombre, input);
    }

    @Override
    public boolean ejecutar(CampoDeBatalla cdb) {
        System.out.println("Elija el pokemon");
        int opciones = PokemonView.imprimirPokemons(cdb.getJugadorActual().getPokemonsVivos().subList(1, cdb.getJugadorActual().getPokemonsVivos().size()), true);
        int opcionElegida = input.obtenerOpcionUsuario(opciones);
        if(opcionElegida == opciones) return false;

        Pokemon pokemonActual = cdb.getJugadorActual().getPokemonActual();

        if(!pokemonActual.getEstados().isEmpty()) {
            for(Estado estado : pokemonActual.getEstados()) {
                estado.accionar();
                if (!pokemonActual.estaVivo()) {
                    System.out.println(pokemonActual.getNombre() + " murio por estar " + estado.getNombre());
                    opcionElegida--;
                    break;
                }
            }
        }
        cdb.getClima().aplicarEfectos(pokemonActual);
        if(!pokemonActual.estaVivo()) {
            System.out.println(pokemonActual.getNombre() + " murio por el clima ");
            opcionElegida--;
        }
        boolean opExitosa = cdb.getJugadorActual().cambiarPokemonActual(opcionElegida);
        if(opExitosa){
            Tools.imprimirMensajeConEspera(input, cdb.getJugadorActual().getPokemonActual().getNombre() + " entra a la batalla!");
        }
        return opExitosa;
    }
}
