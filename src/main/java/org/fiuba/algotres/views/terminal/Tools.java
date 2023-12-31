package org.fiuba.algotres.views.terminal;

import org.fiuba.algotres.views.InputUsuario;
import org.fiuba.algotres.views.OutputUsuario;
import org.fiuba.algotres.views.terminal.comandos.Comando;

import java.util.List;

public class Tools {

    private static OutputUsuario output = new OutputUsuarioTerminal();
    private static InputUsuario input = new InputUsuarioTerminal();

    public static void limpiarConsola(){
        String os = System.getProperty("os.name").toLowerCase();
        if(os.contains("windows")){
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }catch(Exception ignored){
            }
        }else if(os.contains("linux")){
            output.mostrar("\033[H\033[2J");
            System.out.flush();
        }
    }

    public static void imprimirDivisor(boolean lineasDobles){
        if(lineasDobles){
            output.mostrarLinea("==============================");
        }else{
            output.mostrarLinea("------------------------------");
        }
    }
    
    public static int imprimirComandos(List<Comando> list){
        list.forEach((comando) -> output.mostrarLinea("\t" + (list.indexOf(comando) + 1) + ") " + comando.getNombre()));
        return list.size();
    }
    
    public static void imprimirMensajeConEspera(String mensaje){
        output.mostrarLinea(mensaje);
        output.mostrarLinea("Presione enter para continuar");
        input.obtenerCualquierDato(true);
    }

    public static void esperarEnter() {
        output.mostrarLinea("Presione enter para continuar");
        input.obtenerCualquierDato(true);
    }

    public static void setOutput(OutputUsuario output){
        Tools.output = output;
    }
    public static void setInput(InputUsuario input){
        Tools.input = input;
    }
}
