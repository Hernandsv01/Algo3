package org.fiuba.algotres;

import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.fiuba.algotres.comandos.*;

import static org.fiuba.algotres.herramientas.Inicializador.inicializarJuego;
import static org.fiuba.algotres.views.terminal.Tools.imprimirComandos;
import static org.fiuba.algotres.views.terminal.Tools.inicializarComandos;

import org.fiuba.algotres.views.terminal.InputUsuario;

public class JuegoController {
    
    private static final Map<Integer, Comando> comandos = new HashMap<>();
    
    public static void jugar(CampoDeBatalla cdb){
        setupInicial(cdb);
        cdb.setJugadorInicialPorAtributo(Comparator.comparingInt(jugador -> jugador.getPokemonActual().getVelocidad()));

        while(cdb.getGanador() == -1){
            boolean turnoCompletado = turno(cdb);
            if(turnoCompletado){
                cdb.setSiguienteTurno();
            }
        }

        System.out.println(cdb.getJugadores()[cdb.getGanador()].getNombre().toUpperCase() + " ES EL GANADOR!!!");
    }
    
    public static void setupInicial(CampoDeBatalla cdb){
        cdb.getJugadores()[0].setNombre("Juan");
        cdb.getJugadores()[1].setNombre("Diego");
        cdb.getJugadores()[0].setPokemonActual(cdb.getJugadores()[0].getPokemonsActivos().remove(0));
        cdb.getJugadores()[1].setPokemonActual(cdb.getJugadores()[1].getPokemonsActivos().remove(0));
        /* HACER BIEN */
    }

    public static boolean turno(CampoDeBatalla cdb){
        int opciones = imprimirComandos(comandos);
        int opcionElegida = InputUsuario.obtenerOpcionUsuario(opciones);
        return comandos.get(opcionElegida).ejecutar(cdb);
    }

    public static void main(String[] args) {
        inicializarComandos(comandos);
        CampoDeBatalla juego = inicializarJuego();
        jugar(juego);
    }
}   