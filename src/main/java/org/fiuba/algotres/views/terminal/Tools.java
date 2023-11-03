package org.fiuba.algotres.views.terminal;

import org.fiuba.algotres.comandos.Comando;

import java.util.Map;
import org.fiuba.algotres.views.InputUsuario;

public class Tools {
    public static void limpiarConsola(){
        String os = System.getProperty("os.name").toLowerCase();
        if(os.contains("windows")){
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }catch(Exception ignored){
            }
        }else if(os.contains("linux")){
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

    public static void imprimirDivisor(boolean lineasDobles){
        if(lineasDobles){
            System.out.println("==============================");
        }else{
            System.out.println("------------------------------");
        }
    }
    
    public static int imprimirComandos(Map<Integer, Comando> map){
        map.forEach((key, comando) -> System.out.println("\t" + key + ") " + comando.getNombre()));
        return map.size();
    }
    
    public static void imprimirMensajeConEspera(InputUsuario input, String mensaje){
        System.out.println(mensaje);
        System.out.println("Presione enter para continuar");
        input.obtenerCualquierDato(true);
    }
}
