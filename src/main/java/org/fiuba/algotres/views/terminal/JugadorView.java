package org.fiuba.algotres.views.terminal;

import org.fiuba.algotres.model.Jugador;
import org.fiuba.algotres.model.item.Item;
import org.fiuba.algotres.views.OutputUsuario;

public class JugadorView {

    private static OutputUsuario output = new OutputUsuarioTerminal();

    public static int imprimirItems(Jugador jugador){
        int res;
        for(res = 1; res <= jugador.getItems().size(); res++){
            Item item = jugador.getItems().get(res-1);
            output.mostrarLinea("\t" + res + ") " + item.getNombre() + " (" + item.getCantidad() + " usos)");
        }
        output.mostrarLinea("\t" + res + ") Volver");
        return res;
    }

    public void setOutput(OutputUsuario output){
        JugadorView.output = output;
    }
}
