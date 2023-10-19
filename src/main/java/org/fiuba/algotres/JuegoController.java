package org.fiuba.algotres;

import org.fiuba.algotres.comandos.*;
import org.fiuba.algotres.views.terminal.CampoDeBatallaView;
import org.fiuba.algotres.views.terminal.InputUsuario;
import org.fiuba.algotres.views.terminal.PokemonView;
import org.fiuba.algotres.views.terminal.Tools;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static org.fiuba.algotres.herramientas.Inicializador.inicializarJuego;

public class JuegoController {
    
    private static final Map<Integer, Comando> comandos = new HashMap<>(){{
        put(1, new ComandoHabilidad("Usar habilidad"));
        put(2, new ComandoItem("Usar item"));
        put(3, new ComandoCambiarPokemon("Cambiar Pokemon"));
        put(4, new ComandoRendirse("Rendirse"));
    }};
    
    public static void jugar(CampoDeBatalla cdb){
        setupInicial(cdb);

        cdb.setJugadorInicialPorAtributo(Comparator.comparingInt(jugador -> jugador.getPokemonActual().getVelocidad()));
        Tools.imprimirDivisor(false);
        Tools.imprimirMensaje("Comienza " + cdb.getJugadorActual().getNombre() + " por tener el pokemon mas rapido!");

        while(cdb.getGanador() == -1){
            Tools.imprimirDivisor(true);
            boolean turnoCompletado = turno(cdb);
            if(turnoCompletado){
                cdb.setSiguienteTurno();
            }
        }

        System.out.println(cdb.getJugadores()[cdb.getGanador()].getNombre().toUpperCase() + " ES EL GANADOR!!!");
    }
    
    public static void setupInicial(CampoDeBatalla cdb){
        System.out.println("Bienvenido a nuestro simulador de batallas pokemon!");

        String nombreUsuario;
        int opciones;
        int pokemonElegido;

        for(int i = 0; i < cdb.getJugadores().length; i++) {
            Tools.imprimirDivisor(false);
            System.out.println("Jugador " + (i+1) + ", ingrese su nombre");
            nombreUsuario = InputUsuario.obtenerCualquierDato(false);
            cdb.getJugadores()[i].setNombre(nombreUsuario);

            System.out.println("Elija su pokemon inicial");
            opciones = PokemonView.imprimirPokemons(cdb.getJugadores()[i].getPokemons(), false);
            pokemonElegido = InputUsuario.obtenerOpcionUsuario(opciones);

            cdb.getJugadores()[i].cambiarPokemonActual(pokemonElegido-1);

            Tools.imprimirMensaje("Eligio el pokemon: " + cdb.getJugadores()[i].getPokemonActual().getNombre());
        }
    }

    public static boolean turno(CampoDeBatalla cdb){
        CampoDeBatallaView.imprimirCampo(cdb);

        System.out.println("Elija una opcion");
        int opciones = Tools.imprimirComandos(comandos);
        int opcionElegida = InputUsuario.obtenerOpcionUsuario(opciones);

        Tools.imprimirDivisor(false);
        return comandos.get(opcionElegida).ejecutar(cdb);
    }

    public static void main(String[] args) {
        CampoDeBatalla juego = inicializarJuego();
        jugar(juego);
    }
}   