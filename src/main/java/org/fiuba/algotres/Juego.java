package org.fiuba.algotres;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

import static org.fiuba.algotres.herramientas.EntradaSalida.*;

@Getter @Setter
public class Juego {
    private int ganador;
    private final Jugador jugador1;
    private final Jugador jugador2;
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
        boolean accionCompletada;

        /* FALTA ELEGIR POKEMON INICIAL Y APLICAR ESTADOS */

        label:
        while(ganador == 0){
            // Imprimir información
            limpiarConsola();
            imprimirCampo(this);
            System.out.println("Opciones:");
            for(int i = 1; i < opciones.length; i++){
                System.out.println("\t" + i + ") " + opciones[i]);
            }

            // Obtener opción de usuario y accionar
            opcionElegida = obtenerOpcionUsuario(opciones.length-1);
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
     * Verifica la vida de cada uno de los pokemons de los jugadores para ver si alguno tiene vida
     * @return El número del jugador que ganó o 0 en caso de que ambos tengan pokemons con vida.
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