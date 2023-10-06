package org.fiuba.algotres.comandos;

import org.fiuba.algotres.CampoDeBatalla;
import org.fiuba.algotres.Jugador;
import org.fiuba.algotres.Pokemon;
import org.fiuba.algotres.item.Item;
import org.fiuba.algotres.views.terminal.InputUsuario;
import org.fiuba.algotres.views.terminal.JugadorView;
import org.fiuba.algotres.views.terminal.Tools;

import java.util.List;

public class ComandoItem implements Comando {

    private final String NOMBRE = "Usar item";

    @Override
    public boolean ejecutar(CampoDeBatalla cdb) {
        Jugador jugador = cdb.getJugadorActual();

        System.out.println("Elige un item");
        int opciones = JugadorView.imprimirItems(jugador);
        int opcionElegida = InputUsuario.obtenerOpcionUsuario(opciones);

        if(opcionElegida == opciones){
            Tools.imprimirMensaje("No te quedan mas items :(");
            return false;
        }

        Item itemElegido = jugador.getItems().get(opcionElegida-1);
        List<Pokemon> pokemons;
        if("Revivir".equals(itemElegido.getNombre())){
            pokemons = jugador.getPokemonsMuertos();
        }else{
            pokemons = jugador.getPokemonsActivos();
        }

        System.out.println("Elige a qué pokemon le quieres aplicar " + itemElegido.getNombre());
        opciones = JugadorView.imprimirPokemons(pokemons);
        opcionElegida = InputUsuario.obtenerOpcionUsuario(opciones);

        if(opcionElegida == opciones) return false;

        if(cdb.getJugadorActual().getPokemonActual().getEstado() != null) {
            cdb.getJugadorActual().getPokemonActual().getEstado().accionar(cdb.getJugadorActual().getPokemonActual());
        }

        boolean opExitosa = itemElegido.usar(pokemons.get(opcionElegida-1));
        if(opExitosa){
            Tools.imprimirMensaje(itemElegido.getNombre() + " usado en " + pokemons.get(opcionElegida-1).getNombre() + "!");
            if("Revivir".equals(itemElegido.getNombre())){
                cdb.getJugadorActual().revivirPokemon(opcionElegida-1);
            }
        }else{
            Tools.imprimirMensaje("No se puede usar ese item en ese pokemon :/");
        }
        return opExitosa;
    }

    @Override
    public String getNombre() {
        return NOMBRE;
    }
}
