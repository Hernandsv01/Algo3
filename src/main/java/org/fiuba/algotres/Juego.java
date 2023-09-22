package org.fiuba.algotres;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

import static org.fiuba.algotres.herramientas.EntradaSalida.*;
import static org.fiuba.algotres.herramientas.Inicializador.*;

@Getter @Setter
public class Juego {
    private int ganador;
    private final Jugador jugador1;
    private final Jugador jugador2;
    private int turnoActual;

    private final String[] opciones = {"Usar habilidad", "Usar item", "Cambiar pokemon", "Rendirse"};

    public Juego(Jugador jugador1, Jugador jugador2){
        this.ganador = 0;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        inicioJuego();
        this.turnoActual = jugador1.getPokemonActual().getVelocidad()>=jugador2.getPokemonActual().getVelocidad()?1:2;
    }

    public void jugar(){
        int opcionElegida;
        boolean accionCompletada;

        /* FALTA APLICAR ESTADOS */

        label:
        while(ganador == 0){
            // Imprimir información
            imprimirCampo(this);
            System.out.println("Opciones:");
            for(int i = 0; i < opciones.length; i++){
                System.out.println("\t" + (i+1) + ") " + opciones[i]);
            }

            // Obtener opción de usuario y accionar
            opcionElegida = obtenerOpcionUsuario(opciones.length);
            switch (opcionElegida) {
                case 1:
                    accionCompletada = (turnoActual == 1 ? jugador1 : jugador2).elegirHabilidad(this);
                    break;
                case 2:
                    accionCompletada = (turnoActual == 1 ? jugador1 : jugador2).elegirItem(this);
                    break;
                case 3:
                    accionCompletada = (turnoActual == 1 ? jugador1 : jugador2).cambiarPokemonActual(this);
                    break;
                case 4:
                    ganador = turnoActual == 1 ? 2 : 1;
                    break label;
                default:
                    System.out.println("Esa opción todavía no fue implementada");
                    continue;
            }

            // Si se salió, se repite el bucle con el turno del mismo jugador, sino se pasa al siguiente
            if(accionCompletada){
                turnoActual = turnoActual==1 ? 2 : 1;
            }

            ganador = juegoTerminado();
            imprimirDivisor();
        }

        System.out.println("EL JUGADOR " + ganador + " ES EL GANADOR!!!");
    }

    /**
     * Le pide a cada jugador elegir un nombre y su pokemon inicial
     */
    public void inicioJuego(){
        // Ingreso de nombre y seleccion de pokemon inicial de jugador 1
        System.out.println("Bienvenidos a nuestro simulador de batallas pokemon!\n\n" +
                "Jugador 1, elija un nombre: ");
        jugador1.setNombre(obtenerCualquierDato(false));

        System.out.println("Esta es su lista de pokemons, elija uno para iniciar:");
        for(int i = 1; i <= jugador1.getPokemonsActivos().size(); i++){
            System.out.println(i + ") " + jugador1.getPokemonsActivos().get(i-1).getNombre());
        }
        jugador1.setPokemonActual(jugador1.getPokemonsActivos().remove(obtenerOpcionUsuario(jugador1.getPokemonsActivos().size())-1));
        System.out.println("Elegiste " + jugador1.getPokemonActual().getNombre() + "!");
        System.out.println("-----------------------------------------------------");

        // Ingreso de nombre y seleccion de pokemon inicial de jugador 2
        System.out.println("Jugador 2, elija un nombre: ");
        jugador2.setNombre(obtenerCualquierDato(false));
        System.out.println("Esta es su lista de pokemons, elija uno para iniciar:");
        for(int i = 1; i <= jugador2.getPokemonsActivos().size(); i++){
            System.out.println(i + ") " + jugador2.getPokemonsActivos().get(i-1).getNombre());
        }
        jugador2.setPokemonActual(jugador2.getPokemonsActivos().remove(obtenerOpcionUsuario(jugador2.getPokemonsActivos().size())-1));
        System.out.println("Elegiste " + jugador2.getPokemonActual().getNombre() + "!");
        System.out.println("-----------------------------------------------------");
    };

    /**
     * Verifica la vida de cada uno de los pokemons de los jugadores para ver si alguno tiene vida
     * @return El número del jugador que ganó o 0 en caso de que ambos tengan pokemons con vida.
     */
    public int juegoTerminado(){
        if(jugador1.getPokemonsActivos().isEmpty()) return 2;
        if(jugador2.getPokemonsActivos().isEmpty()) return 1;
        return 0;
    }

    public static void main(String[] args) {
        inicializarJuego().jugar();
    }
}