package org.fiuba.algotres.views.terminal;

import java.io.File;
import java.util.Map;
import java.util.Objects;

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
    
    public static void imprimirMensaje(String mensaje){
        System.out.println(mensaje);
        System.out.println("Presione enter para continuar");
        InputUsuario.obtenerCualquierDato(true);
    }

    public static void inicializarComandos(Map<Integer, Comando> comandos) {
        File directory = new File("target/classes/org/fiuba/algotres/comandos");

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            for (int i = 0; i < Objects.requireNonNull(files).length; i++) {
                File file = files[i];
                if (file.isFile() && file.getName().startsWith("Comando") && file.getName().endsWith(".class") && file.getName().length() > "Comando.class".length()) {
                    try {
                        String className = "org.fiuba.algotres.comandos." + file.getName().replace(".class", "");

                        Object instance = Class.forName(className).getDeclaredConstructor().newInstance();

                        comandos.put(i, (Comando)instance);

                    } catch (ClassNotFoundException e) {
                        System.err.println("Class not found: " + e.getMessage());
                    } catch (ClassCastException e) {
                        System.err.println("Class not of Comando type: " + e.getMessage());
                    } catch (NoSuchMethodException e) {
                        System.err.println("Empty class constructor not found: " + e.getMessage());
                    } catch (Exception e) {
                        System.err.println("Error instantiating class: " + e.getMessage());
                    }
                }
            }
        } else {
            System.err.println("Directory does not exist or is not a directory.");
        }
    }
}
