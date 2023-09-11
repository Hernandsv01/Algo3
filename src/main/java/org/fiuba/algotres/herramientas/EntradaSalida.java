package org.fiuba.algotres.herramientas;

import org.fiuba.algotres.Juego;

import java.util.Scanner;

public class EntradaSalida {
    public static void limpiarConsola(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int obtenerOpcionUsuario(int limite){
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        String inputLine = "";

        do {
            inputLine = scanner.nextLine();
            try {
                result = Integer.parseInt(inputLine);
                if(result <= 0 || result > limite){
                    result = 0;
                    throw new RuntimeException();
                }
            } catch (Exception e) {
                System.out.println("Eso no es un número válido, no intentes romper nuestro juego :(");
            }
        }while(result == 0);

        return result;
    }

    public static void imprimirCampo(Juego juego){
        System.out.println(
                """
                        Nombre jugador1\s
                        Nombre pokemon jugador 1 (estado si es que tiene)\s
                        Vida pokemon 1\s

                        Nombre jugador2\s
                        Nombre pokemon jugador 2 (estado si es que tiene)\s
                        Vida pokemon 2\s
                        """
        );
    }
}
