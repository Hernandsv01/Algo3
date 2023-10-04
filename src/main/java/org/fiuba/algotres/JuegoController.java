package org.fiuba.algotres;

import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.fiuba.algotres.comandos.*;

import static org.fiuba.algotres.herramientas.Inicializador.inicializarJuego;
import static org.fiuba.algotres.views.terminal.Tools.*;

import org.fiuba.algotres.views.terminal.CampoDeBatallaView;
import org.fiuba.algotres.views.terminal.InputUsuario;
import org.fiuba.algotres.views.terminal.PokemonView;
import org.fiuba.algotres.views.terminal.Tools;

public class JuegoController {
    
    private static final Map<Integer, Comando> comandos = new HashMap<>();
    
    public static void jugar(CampoDeBatalla cdb){
        setupInicial(cdb);

        cdb.setJugadorInicialPorAtributo(Comparator.comparingInt(jugador -> jugador.getPokemonActual().getVelocidad()));
        Tools.imprimirDivisor(false);
        Tools.imprimirMensaje("Comienza " + cdb.getJugadorActual().getNombre() + " por tener el pokemon mas rápido!");

        while(cdb.getGanador() == -1){
            imprimirDivisor(true);
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
            imprimirDivisor(false);
            System.out.println("Jugador " + (i+1) + ", ingrese su nombre");
            nombreUsuario = InputUsuario.obtenerCualquierDato(false);
            cdb.getJugadores()[i].setNombre(nombreUsuario);

            System.out.println("Elija su pokemon inicial");
            opciones = PokemonView.imprimirPokemons(cdb.getJugadores()[i].getPokemonsActivos(), false);
            pokemonElegido = InputUsuario.obtenerOpcionUsuario(opciones);
            cdb.getJugadores()[i].setPokemonActual(cdb.getJugadores()[i].getPokemonsActivos().remove(pokemonElegido-1));

            Tools.imprimirMensaje("Eligió el pokemon: " + cdb.getJugadores()[i].getPokemonActual().getNombre());
        }
    }

    public static boolean turno(CampoDeBatalla cdb){
        CampoDeBatallaView.imprimirCampo(cdb);

        System.out.println("Elija una opción");
        int opciones = imprimirComandos(comandos);
        int opcionElegida = InputUsuario.obtenerOpcionUsuario(opciones);

        Tools.imprimirDivisor(false);
        return comandos.get(opcionElegida).ejecutar(cdb);
    }

    public static void main(String[] args) {
        inicializarComandos(comandos);
        CampoDeBatalla juego = inicializarJuego();
        jugar(juego);
    }
}   