package org.fiuba.algotres;

import java.util.Optional;

import static org.fiuba.algotres.herramientas.EntradaSalida.*;

public class Juego {
    private int ganador;
    private Jugador jugador1;
    private Jugador jugador2;
    private int turnoActual;

    public Juego(Jugador jugador1, Jugador jugador2){
        this.ganador = 0;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.turnoActual = primerTurno();
    }

    public void jugar(){
        System.out.println("Acá iría nuestro juego... Si tuvieramos uno");

        while(ganador == 0){
            limpiarConsola();
            imprimirCampo(this);
            /*
            lógica de juego
                1) Imprimir campo (jugador, nombre del pokemon, vida)
                2) Imprimir opciones
                3) reimprimir campo cada vez que se elija algo
             */

//            turnoActual = turnoActual==1 ? 2 : 1;
//            ganador = juegoTerminado();
            ganador = obtenerOpcionUsuario(3);
        }

        System.out.println("EL JUGADOR " + ganador + " ES EL GANADOR!!!");
    }

    /**
     * Verifica la vida de cada uno de los pokemons de los jugadores para ver si alguno tiene vida
     * @return El número del jugador que ganó o 0 en caso de que ninguno haya perdido
     */
    public int juegoTerminado(){
        Optional<Pokemon> res1 = jugador1.getPokemons().stream()
                .filter(pokemon -> pokemon.getVidaActual() > 0)
                .findAny();
        if(res1.isEmpty()) return 2;

        Optional<Pokemon> res2 = jugador2.getPokemons().stream()
                .filter(pokemon -> pokemon.getVidaActual() > 0)
                .findAny();
        if(res2.isEmpty()) return 1;

        return 0;
    }

    /**
     * Verifica quien comienza jugando basado en la velocidad del pokemon de cada jugador
     * @return El número del jugador que comienza
     */
    public int primerTurno(){
        return jugador1.getPokemonActual().getVelocidad()>=jugador2.getPokemonActual().getVelocidad()?1:2;

//        int veloz1;
//        int veloz2;
//
//        veloz1 = jugador1.getPokemons().stream()
//                .map(Pokemon::getVelocidad)
//                .max(Integer::compare)
//                .get();
//
//        veloz2 = jugador2.getPokemons().stream()
//                .map(Pokemon::getVelocidad)
//                .max(Integer::compare)
//                .get();
//
//        return veloz1>=veloz2?1:2;
    }

    public static void main(String[] args) {
        Juego miJuego = new Juego(new Jugador(), new Jugador());
        miJuego.jugar();
    }
}