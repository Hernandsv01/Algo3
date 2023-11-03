package org.fiuba.algotres.views.terminal;

import java.util.Scanner;
import org.fiuba.algotres.views.InputUsuario;

public class InputUsuarioTerminal implements InputUsuario {

    /**
     * Función que espera input de usuario entre 1 y {límite}
     * @param limite INCLUÍDO en el rango
     * @return El resultado ingresado por el usuario
     */
    @Override
    public int obtenerOpcionUsuario(int limite){
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
    @Override
    public String obtenerCualquierDato(boolean puedeEstarVacio){
        Scanner scanner = new Scanner(System.in);
        String res;
        do{
            res = scanner.nextLine();
        }while(!puedeEstarVacio && (res == null || "".equals(res.trim())));

        return res;
    }
}
