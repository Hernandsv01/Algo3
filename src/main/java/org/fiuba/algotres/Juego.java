package org.fiuba.algotres;

import java.util.Arrays;
import java.util.Optional;

import static org.fiuba.algotres.herramientas.EntradaSalida.*;

public class Juego {
    private int ganador;
    private Jugador jugador1;
    private Jugador jugador2;
    private int turnoActual;

    private final String[] opciones = {"", "Usar habilidad", "Usar item", "Cambiar pokemon", "Rendirse"};

    public Juego(Jugador jugador1, Jugador jugador2){
        this.ganador = 0;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.turnoActual = jugador1.getPokemonActual().getVelocidad()>=jugador2.getPokemonActual().getVelocidad()?1:2;
    }

    public void jugar(){
        int opcionElegida;
        boolean accionCompletada = true;

        while(ganador == 0){
            // Imprimir información
            limpiarConsola();
            imprimirCampo(this);
            System.out.println("Turno: jugador " + turnoActual);
            for(int i = 1; i < opciones.length; i++){
                System.out.println("\t" + i + ") " + opciones[i]);
            }

            // Obtener opción de usuario y accionar
            opcionElegida = obtenerOpcionUsuario(opciones.length);
            if(opcionElegida == 1){
                accionCompletada = (turnoActual==1?jugador1:jugador2).elegirHabilidad();
            }else if(opcionElegida == 2){
                accionCompletada = (turnoActual==1?jugador1:jugador2).elegirItem();
            }else if(opcionElegida == 3){
                accionCompletada = (turnoActual==1?jugador1:jugador2).cambiarPokemonActual();
            }else{
                ganador = turnoActual==1?2:1;
                break;
            }

            // Si se salió, se repite el bucle con el turno del mismo jugador, sino se pasa al siguiente
            if(accionCompletada){
                turnoActual = turnoActual==1 ? 2 : 1;
            }

            ganador = juegoTerminado();
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
                .findFirst();
        if(res1.isEmpty()) return 2;

        Optional<Pokemon> res2 = jugador2.getPokemons().stream()
                .filter(pokemon -> pokemon.getVidaActual() > 0)
                .findFirst();
        if(res2.isEmpty()) return 1;

        return 0;
    }

    public static void main(String[] args) {
        Juego miJuego = new Juego(new Jugador(), new Jugador());
        miJuego.jugar();
    }
}