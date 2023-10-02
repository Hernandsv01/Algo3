package org.fiuba.algotres.views.terminal;

import java.util.Map;
import org.fiuba.algotres.comandos.Comando;

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

    public static void imprimirDivisor(){
        System.out.println("------------------------------");
    }
    
    public static int imprimirComandos(Map<Integer, Comando> map){
        map.entrySet().forEach(entry -> {
            Integer key = entry.getKey();
            Comando comando = entry.getValue();
            System.out.println("\t" + key + ") " + comando.getNombre());
        });
        System.out.println("\t" + (map.size()+1) + ") Volver");
        return map.size()+1;
    }
    
    public static void imprimirMensaje(String mensaje){
        System.out.println(mensaje);
        InputUsuario.obtenerCualquierDato(true);
    }
}
