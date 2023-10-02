package org.fiuba.algotres.comandos;

import java.util.List;
import org.fiuba.algotres.CampoDeBatalla;
import org.fiuba.algotres.Jugador;
import org.fiuba.algotres.Pokemon;
import org.fiuba.algotres.item.Item;
import org.fiuba.algotres.views.terminal.InputUsuario;
import org.fiuba.algotres.views.terminal.JugadorView;

public class ComandoItem implements Comando {

    private final String NOMBRE = "Usar item";

    @Override
    public boolean ejecutar(CampoDeBatalla cdb) {
        Jugador jugador = cdb.getJugadorActual();

        int opciones = JugadorView.imprimirItems(jugador);
        int opcionElegida = InputUsuario.obtenerOpcionUsuario(opciones);

        if(opcionElegida == opciones) return false;

        Item itemElegido = jugador.getItems().get(opcionElegida);
        List<Pokemon> pokemons;
        if("Revivir".equals(itemElegido.getNombre())){
            pokemons = jugador.getPokemonsMuertos();
        }else{
            pokemons = jugador.getPokemonsActivos();
        }

        opciones = JugadorView.imprimirPokemons(pokemons);
        opcionElegida = InputUsuario.obtenerOpcionUsuario(opciones);

        if(opcionElegida == opciones) return false;

        return itemElegido.usar(pokemons.get(opcionElegida));
    }

    @Override
    public String getNombre() {
        return NOMBRE;
    }
}
