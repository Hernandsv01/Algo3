package org.fiuba.algotres;

import lombok.Getter;
import lombok.Setter;
import org.fiuba.algotres.habilidad.Habilidad;
import org.fiuba.algotres.io.InputUsuario;
import org.fiuba.algotres.io.Output;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
public class CampoDeBatalla {
    private Jugador[] jugadores;
    private int turnoActual;

    private final Output campoDeBatallaView;
    private final InputUsuario inputUsuario;

    private final String[] opciones = {"Usar habilidad", "Usar item", "Cambiar pokemon", "Rendirse"};

    public CampoDeBatalla(Jugador[] jugadores, Output campoDeBatallaView, InputUsuario inputUsuario){
        this.jugadores = jugadores;
        this.campoDeBatallaView = campoDeBatallaView;
        this.inputUsuario = inputUsuario;
    }

    /**
     * Ejecuta el ciclo completo de un turno de un jugador
     * @return si se pudo completar
     */
    public boolean turnoJugador(){
        mostrarCampo();
        campoDeBatallaView.mostrar("Opciones:");
        campoDeBatallaView.mostrarListado(Arrays.stream(opciones).toList());

        //==============================================================================

        // Obtener opción de usuario y accionar
        int opcionElegida = inputUsuario.obtenerOpcionNumerica(opciones.length);
        switch (opcionElegida) {
            case 1 -> {
                int habilidadElegida = jugadores[turnoActual].elegirHabilidad();
                if(habilidadElegida == -1){
                    return false;
                }
                jugadores[turnoActual].getPokemonActual().getHabilidades().get(habilidadElegida).accionarHabilidad(null, null);
            }
            case 2 -> {
                int itemElegido = jugadores[turnoActual].elegirItem();
                if(itemElegido == -1){
                    return false;
                }
                jugadores[turnoActual].aplicarItem(itemElegido);
            }
            case 3 -> {
                accionCompletada = cdb.getJugadores()[cdb.getTurnoActual()].cambiarPokemonActual(cdb);
            }
            case 4 -> {
                cdb.getJugadores()[cdb.getTurnoActual()].getPokemonsActivos().stream()
                        .peek(pokemon -> pokemon.setVidaActual(0))
                        .forEach(cdb.getJugadores()[cdb.getTurnoActual()].getPokemonsMuertos()::add);
                accionCompletada = true;
            }
            default -> {
                System.out.println("Esa opción todavía no fue implementada");
                continue;
            }
        }

        return false;
    }

    /**
     * Le pide a cada jugador elegir un nombre y su pokemon inicial
     */
    public void comenzarBatalla(){
        // Ingreso de nombre y seleccion de pokemon inicial de jugador 1
        System.out.println("Bienvenidos a nuestro simulador de batallas pokemon!\n\n" +
                "Jugador 1, elija un nombre: ");
        cdb.getJugadores()[0].setNombre(obtenerCualquierDato(false));

        System.out.println("Esta es su lista de pokemons, elija uno para iniciar:");
        for(int i = 1; i <= cdb.getJugadores()[0].getPokemonsActivos().size(); i++){
            System.out.println(i + ") " + cdb.getJugadores()[0].getPokemonsActivos().get(i-1).getNombre());
        }
        cdb.getJugadores()[0].setPokemonActual(cdb.getJugadores()[0].getPokemonsActivos().remove(obtenerOpcionUsuario(cdb.getJugadores()[0].getPokemonsActivos().size())-1));
        System.out.println("Elegiste " + cdb.getJugadores()[0].getPokemonActual().getNombre() + "!");
        System.out.println("-----------------------------------------------------");

        // Ingreso de nombre y seleccion de pokemon inicial de jugador 2
        System.out.println("Jugador 2, elija un nombre: ");
        cdb.getJugadores()[1].setNombre(obtenerCualquierDato(false));
        System.out.println("Esta es su lista de pokemons, elija uno para iniciar:");
        for(int i = 1; i <= cdb.getJugadores()[1].getPokemonsActivos().size(); i++){
            System.out.println(i + ") " + cdb.getJugadores()[1].getPokemonsActivos().get(i-1).getNombre());
        }
        cdb.getJugadores()[1].setPokemonActual(cdb.getJugadores()[1].getPokemonsActivos().remove(obtenerOpcionUsuario(cdb.getJugadores()[1].getPokemonsActivos().size())-1));
        System.out.println("Elegiste " + cdb.getJugadores()[1].getPokemonActual().getNombre() + "!");
        System.out.println("-----------------------------------------------------");

        turnoActual = jugadores[0].getPokemonActual().getVelocidad() >= jugadores[1].getPokemonActual().getVelocidad() ? 0 : 1;
    }

    /**
     * Verifica la vida de cada uno de los pokemons de los jugadores para ver si alguno tiene vida
     * @return El número del jugador que ganó o -1 en caso de que ambos tengan pokemons con vida.
     */
    public int getGanador(){
        if(jugadores[0].getPokemonsActivos().isEmpty()) return 1;
        if(jugadores[1].getPokemonsActivos().isEmpty()) return 0;
        return -1;
    }

    /**
     * Verifica el turno actual y devuelve el id del otro jugador
     * @return El id del otro jugador
     */
    public int siguienteTurno(){
        return turnoActual==0 ? 1 : 0;
    }

    public void mostrarCampo(){
        String infoCampo =
                "Jugador 1 \n" +
                jugadores[0].getPokemonActual().getNombre() + " \n" +
                jugadores[0].getPokemonActual().getHealthString() + " \n" +
                "\n" +
                "Jugador 2 \n" +
                jugadores[1].getPokemonActual().getNombre() + " \n" +
                jugadores[1].getPokemonActual().getHealthString() + " \n" +
                "\n" +
                "Turno: jugador " + turnoActual;
        campoDeBatallaView.mostrar(infoCampo);

//        System.out.println(
//                "Nombre jugador1 \n" +
//                "Nombre pokemon jugador 1 (estado si es que tiene) \n" +
//                "Vida pokemon 1 \n" +
//                "\n" +
//                "Nombre jugador2 \n" +
//                "Nombre pokemon jugador 2 (estado si es que tiene) \n" +
//                "Vida pokemon 2 \n" +
//                "\n" +
//                "Turno: jugador " + juego.getTurnoActual() + "\n"
//        );
    }

}