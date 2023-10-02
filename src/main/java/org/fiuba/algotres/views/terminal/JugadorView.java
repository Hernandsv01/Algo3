package org.fiuba.algotres.views.terminal;

import org.fiuba.algotres.Jugador;
import org.fiuba.algotres.Pokemon;

public class JugadorView {
    public static int imprimirItems(Jugador jugador){
        int res;
        for(res = 1; res <= jugador.getItems().size(); res++){
            System.out.println("\t" + res + ") " + jugador.getItems().get(res-1));
        }
        System.out.println("\t" + res + ") Volver");
        return res;
    }
    public static int imprimirPokemonsActivos(Jugador jugador){
        int res;
        for(res = 1; res <= jugador.getPokemonsActivos().size(); res++){
            System.out.println("\t" + res + ") " + jugador.getPokemonsActivos().get(res-1));
        }
        System.out.println("\t" + res + ") Volver");
        return res;
    }
    public static int imprimirMuertos(Jugador jugador){
        int res;
        for(res = 1; res <= jugador.getPokemonsMuertos().size(); res++){
            System.out.println("\t" + res + ") " + jugador.getPokemonsMuertos().get(res-1));
        }
        System.out.println("\t" + res + ") Volver");
        return res;
    }
}
