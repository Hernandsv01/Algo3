package org.fiuba.algotres.comandos;

import java.util.List;
import org.fiuba.algotres.CampoDeBatalla;
import org.fiuba.algotres.Pokemon;
import org.fiuba.algotres.item.Item;
import org.fiuba.algotres.views.terminal.InputUsuario;
import org.fiuba.algotres.views.terminal.JugadorView;

public class ComandoItem implements Comando {
    
    private final String NOMBRE = "Usar item";
    
    @Override
    public boolean ejecutar(CampoDeBatalla cdb) {
        // Elegir item
        // Elegir pokemon victima
        // Ejecutar item considerando revivir
        
//        int opciones = JugadorView.imprimirItems(jugador);
//        int opcionElegida = InputUsuario.obtenerOpcionUsuario(opciones);
//        
//        if(opcionElegida == opciones) return null;
//        
//        return jugador.getItems().get(opcionElegida);
//        //----------------------------------------------
//        Item item = elegirItem(cdb.getJugadores()[cdb.getTurnoActual()]);
//        if(item == null) return false;
//        List<Pokemon> pokemons;
//        if("Revivir".equals(item.getNombre())){
//            pokemons = cdb.getJugadores()[cdb.getTurnoActual()].getPokemonsMuertos();
//        }else{
//            pokemons = cdb.getJugadores()[cdb.getTurnoActual()].getPokemonsActivos();
//        }
//        Pokemon pokemonElegido = elegirPokemon(pokemons);
//        return item.usar(pokemonElegido);
        return false;
    }

    @Override
    public String getNombre() {
        return NOMBRE;
    }
}
