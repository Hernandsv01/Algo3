package org.fiuba.algotres.io.terminal;

import org.fiuba.algotres.io.Output;

import java.util.List;

public class OutputTerminal implements Output {
    @Override
    public void mostrar(String mensaje) {
        System.out.println(mensaje);
    }

    @Override
    public void mostrarListado(List<String> elementos) {
        for(int i = 0; i < elementos.size(); i++){
            System.out.println("\t" + (i+1) + ") " + elementos.get(i));
        }
    }
}
