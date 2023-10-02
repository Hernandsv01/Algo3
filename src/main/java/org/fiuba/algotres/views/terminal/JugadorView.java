package org.fiuba.algotres.views.terminal;

import org.fiuba.algotres.Jugador;
import org.fiuba.algotres.Pokemon;

import java.util.List;

public class JugadorView {
    public static int imprimirItems(Jugador jugador){
        int res;
        for(res = 1; res <= jugador.getItems().size(); res++){
            System.out.println("\t" + res + ") " + jugador.getItems().get(res-1));
        }
        System.out.println("\t" + res + ") Volver");
        return res;
    }
    public static int imprimirPokemons(List<Pokemon> pokemons){
        int res;
        for(res = 1; res <= pokemons.size(); res++){
            System.out.println("\t" + res + ") " + pokemons.get(res-1));
        }
        System.out.println("\t" + res + ") Volver");
        return res;
    }
}
