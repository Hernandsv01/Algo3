package org.fiuba.algotres.views.terminal.comandos;

import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.Jugador;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.estado.Estado;
import org.fiuba.algotres.model.item.Item;
import org.fiuba.algotres.views.InputUsuario;
import org.fiuba.algotres.views.terminal.JugadorView;
import org.fiuba.algotres.views.terminal.PokemonView;
import org.fiuba.algotres.views.terminal.Tools;

import java.util.List;

public class ComandoItem extends Comando {
    public ComandoItem(String nombre, InputUsuario input) {
        super(nombre, input);
    }

    @Override
    public boolean ejecutar(CampoDeBatalla cdb) {
        Jugador jugador = cdb.getJugadorActual();

        System.out.println("Elige un item");
        int opciones = JugadorView.imprimirItems(jugador);
        int opcionElegida = input.obtenerOpcionUsuario(opciones);

        if(opcionElegida == opciones) return false;

        Item itemElegido = jugador.getItems().get(opcionElegida-1);
        List<Pokemon> pokemons;
        if("Revivir".equals(itemElegido.getNombre())){
            pokemons = jugador.getPokemonsMuertos();
        }else{
            pokemons = jugador.getPokemonsVivos();
        }

        System.out.println("Elige a que pokemon le quieres aplicar " + itemElegido.getNombre());
        opciones = PokemonView.imprimirPokemons(pokemons, true);
        opcionElegida = input.obtenerOpcionUsuario(opciones);

        if(opcionElegida == opciones) return false;

        Pokemon pokemonActual = cdb.getJugadorActual().getPokemonActual();
      
        if(!pokemonActual.getEstados().isEmpty()) {
            for(Estado estado : pokemonActual.getEstados()) {
                estado.accionar();
                if (!pokemonActual.estaVivo()) {
                    Tools.imprimirMensajeConEspera("Tu pokemon murio antes de poder hacer nada por estar " + estado.getNombre());
                    reemplazarPokemonMuerto(cdb.getJugadorActual());
                    return true;
                }
            }
            pokemonActual.limpiarEstados();
        }

        cdb.getClima().aplicarEfectos(pokemonActual);
        if(!pokemonActual.estaVivo()) {
            Tools.imprimirMensajeConEspera("Tu pokemon murio por el clima ");
            reemplazarPokemonMuerto(cdb.getJugadorActual());
        }
      
        Pokemon pokemonElegido = pokemons.get(opcionElegida-1);
        boolean opExitosa = itemElegido.usar(pokemonElegido);
        if(opExitosa){
            Tools.imprimirMensajeConEspera(itemElegido.getNombre() + " usado en " + pokemonElegido.getNombre() + "!");
        }else{
            Tools.imprimirMensajeConEspera("No se puede usar ese item en ese pokemon :/");
        }
        return opExitosa;
    }
}
