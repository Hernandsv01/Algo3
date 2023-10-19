package org.fiuba.algotres.views.terminal;

import org.fiuba.algotres.model.Jugador;

public class JugadorView {
    public static int imprimirItems(Jugador jugador){
        int res;
        for(res = 1; res <= jugador.getItems().size(); res++){
            System.out.println("\t" + res + ") " + jugador.getItems().get(res-1).getNombre());
        }
        System.out.println("\t" + res + ") Volver");
        return res;
    }
}
