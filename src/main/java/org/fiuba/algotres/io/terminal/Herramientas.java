package org.fiuba.algotres.io.terminal;

public class Herramientas {
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
}
