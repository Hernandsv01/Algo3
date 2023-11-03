package org.fiuba.algotres.views.terminal;

import org.fiuba.algotres.model.Jugador;
import org.fiuba.algotres.model.item.Item;

public class JugadorView {
    public static int imprimirItems(Jugador jugador){
        int res;
        for(res = 1; res <= jugador.getItems().size(); res++){
            Item item = jugador.getItems().get(res-1);
            System.out.println("\t" + res + ") " + item.getNombre() + " (" + item.getCantidad() + " usos)");
        }
        System.out.println("\t" + res + ") Volver");
        return res;
    }
}
