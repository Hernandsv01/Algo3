package org.fiuba.algotres.controllers.terminal;

import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.views.InputUsuario;
import org.fiuba.algotres.views.terminal.CampoDeBatallaView;
import org.fiuba.algotres.views.terminal.PokemonView;
import org.fiuba.algotres.views.terminal.Tools;
import org.fiuba.algotres.views.terminal.comandos.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TerminalController {

    private static InputUsuario input;
    private static List<Comando> comandos;
    
    public static void jugar(CampoDeBatalla cdb){
        setupInicial(cdb);

        cdb.setJugadorInicialPorAtributo(Comparator.comparingInt(jugador -> jugador.getPokemonActual().getVelocidad()));
        Tools.imprimirDivisor(false);
        Tools.imprimirMensajeConEspera("Comienza " + cdb.getJugadorActual().getNombre() + " por tener el pokemon mas rapido!");

        while(cdb.getGanador() == -1){
            Tools.imprimirDivisor(true);
            boolean turnoCompletado = turno(cdb);
            if(turnoCompletado){
                cdb.setSiguienteTurno();
            }
        }

        System.out.println(cdb.getJugadores()[cdb.getGanador()].getNombre().toUpperCase() + " ES EL GANADOR!!!");
    }
    
    public static void inicializarConfiguracion(InputUsuario input){
        TerminalController.input = input;

        TerminalController.comandos = new ArrayList<>(List.of(
                new ComandoHabilidad("Usar habilidad", input),
                new ComandoItem("Usar item", input),
                new ComandoCambiarPokemon("Cambiar Pokemon", input),
                new ComandoRendirse("Rendirse", input)
        ));
    }
    
    public static void setupInicial(CampoDeBatalla cdb){
        System.out.println("Bienvenido a nuestro simulador de batallas pokemon!");

        String nombreUsuario;
        int opciones;
        int pokemonElegido;

        for(int i = 0; i < cdb.getJugadores().length; i++) {
            Tools.imprimirDivisor(false);
            System.out.println("Jugador " + (i+1) + ", ingrese su nombre");
            nombreUsuario = input.obtenerCualquierDato(false);
            cdb.getJugadores()[i].setNombre(nombreUsuario);

            System.out.println("Elija su pokemon inicial");
            opciones = PokemonView.imprimirPokemons(cdb.getJugadores()[i].getPokemons(), false);
            pokemonElegido = input.obtenerOpcionUsuario(opciones);

            cdb.getJugadores()[i].cambiarPokemonActual(pokemonElegido-1);

            Tools.imprimirMensajeConEspera("Eligio el pokemon: " + cdb.getJugadores()[i].getPokemonActual().getNombre());
        }

        Tools.imprimirMensajeConEspera("El clima sorteado es: " + cdb.getClima().getNombre());
    }

    public static boolean turno(CampoDeBatalla cdb){
        CampoDeBatallaView.imprimirCampo(cdb);

        System.out.println("Elija una opcion");
        int opciones = Tools.imprimirComandos(comandos);
        int opcionElegida = input.obtenerOpcionUsuario(opciones);

        Tools.imprimirDivisor(false);
        return comandos.get(opcionElegida - 1).ejecutar(cdb);
    }

    public static InputUsuario getInput() {
        return input;
    }

    public static void setInput(InputUsuario input) {
        TerminalController.input = input;
    }

    public static List<Comando> getComandos() {
        return comandos;
    }

    public static void setComandos(List<Comando> comandos) {
        TerminalController.comandos = comandos;
    }
}   