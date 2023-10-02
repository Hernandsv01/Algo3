package org.fiuba.algotres;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.fiuba.algotres.comandos.Comando;
import org.fiuba.algotres.comandos.ComandoCambiarPokemon;
import org.fiuba.algotres.comandos.ComandoHabilidad;
import org.fiuba.algotres.comandos.ComandoItem;
import org.fiuba.algotres.comandos.ComandoRendirse;

import static org.fiuba.algotres.herramientas.Inicializador.inicializarJuego;
import org.fiuba.algotres.views.terminal.InputUsuario;
import org.fiuba.algotres.views.terminal.Tools;

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
        
    public static void inicializarComandos(){
        comandos.put(1, new ComandoCambiarPokemon());
        comandos.put(2, new ComandoHabilidad());
        comandos.put(3, new ComandoItem());
        comandos.put(4, new ComandoRendirse());
    }
    
    public static void setupInicial(CampoDeBatalla cdb){
        cdb.getJugadores()[0].setPokemonActual(cdb.getJugadores()[0].getPokemonsActivos().remove(0));
        cdb.getJugadores()[1].setPokemonActual(cdb.getJugadores()[1].getPokemonsActivos().remove(0));
        /* HACER BIEN */
    }

    public static boolean turno(CampoDeBatalla cdb){
        int opciones = Tools.imprimirComandos(comandos);
        int opcionElegida = InputUsuario.obtenerOpcionUsuario(opciones);
        
        if(opcionElegida == opciones) return false;
        
        return comandos.get(opcionElegida).ejecutar(cdb);
    }

    public static void main(String[] args) {
        CampoDeBatalla juego = inicializarJuego();
        jugar(juego);
    }
}   