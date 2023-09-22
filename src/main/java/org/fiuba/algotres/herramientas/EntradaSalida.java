package org.fiuba.algotres.herramientas;

import org.fiuba.algotres.Juego;

import java.util.Scanner;

public class EntradaSalida {
    public static void limpiarConsola(){
        String os = System.getProperty("os.name").toLowerCase();
        if(os.contains("windows")){
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }else if(os.contains("linux")){
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

    /**
     * Función que espera input de usuario entre 1 y {límite}
     * @param limite INCLUÍDO en el rango
     * @return El resultado ingresado por el usuario
     */
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
                System.out.println("Eso no es un numero valido, no intentes romper nuestro juego :(");
            }
        }while(result == 0);

        return result;
    }

    /**
     * Función que espera cualquier tipo de input de usuario
     * @param puedeEstarVacio Indica si lo ingresado puede estar vacío o no
     * @return El resultado ingresado por el usuario
     */
    public static String obtenerCualquierDato(boolean puedeEstarVacio){
        Scanner scanner = new Scanner(System.in);
        String res;
        do{
            res = scanner.nextLine();
        }while(!puedeEstarVacio && "".trim().equals(res));

        return res;
    }

    public static void imprimirCampo(Juego juego){
        limpiarConsola();
        System.out.println(
                "Jugador 1 \n" +
                juego.getJugador1().getPokemonActual().getNombre() + " \n" +
                juego.getJugador1().getPokemonActual().getHealthString() + " \n" +
                "\n" +
                "Jugador 2 \n" +
                juego.getJugador2().getPokemonActual().getNombre() + " \n" +
                juego.getJugador2().getPokemonActual().getHealthString() + " \n" +
                "\n" +
                "Turno: jugador " + juego.getTurnoActual());
//        System.out.println(
//                "Nombre jugador1 \n" +
//                "Nombre pokemon jugador 1 (estado si es que tiene) \n" +
//                "Vida pokemon 1 \n" +
//                "\n" +
//                "Nombre jugador2 \n" +
//                "Nombre pokemon jugador 2 (estado si es que tiene) \n" +
//                "Vida pokemon 2 \n" +
//                "\n" +
//                "Turno: jugador " + juego.getTurnoActual() + "\n"
//        );
    }

    public static void imprimirDivisor(){
        System.out.println("------------------------------");
    }
}
