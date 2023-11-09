package org.fiuba.algotres.views.terminal;

import org.fiuba.algotres.views.OutputUsuario;

public class OutputUsuarioTerminal implements OutputUsuario {
    @Override
    public void mostrar(String mensaje) {
        System.out.print(mensaje);
    }

    @Override
    public void mostrarLinea(String mensaje) {
        System.out.println(mensaje);
    }

    public void siguienteLinea(){
        System.out.println();
    }
}
