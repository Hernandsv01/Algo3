package org.fiuba.algotres;

import lombok.Getter;
import lombok.Setter;
import org.fiuba.algotres.io.InputUsuario;
import org.fiuba.algotres.io.Output;

import java.util.Arrays;
import java.util.Comparator;
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
     * @return True si se pudo completar, false en caso contrario
     */
    public boolean turnoJugador(){
        mostrarCampo();
        campoDeBatallaView.mostrar("Opciones:");
        campoDeBatallaView.mostrarListado(Arrays.stream(opciones).toList());

        int opcionElegida = inputUsuario.obtenerOpcionNumerica(opciones.length);

        mostrarCampo();
        int res;
        switch (opcionElegida) {
            case 1:
                res = jugadores[turnoActual].elegirHabilidad();
                if(!operacionExitosa(res, "No hay habilidades disponibles")) return false;

                jugadores[turnoActual].getPokemonActual().getHabilidades().get(res).accionarHabilidad(null, null);
                break;

            case 2:
                res = jugadores[turnoActual].elegirItem();
                if(!operacionExitosa(res, "No tenes items para utilizar")) return false;

                res = jugadores[turnoActual].usarItem(res);
                if(!operacionExitosa(res, "No podes usar ese item en ese pokemon")) return false;
                break;

            case 3:
                res = jugadores[turnoActual].cambiarPokemonActual();
                if(!operacionExitosa(res, "No te quedan más pokemons")) return false;
                break;

            case 4:
                jugadores[turnoActual].getPokemonsActivos()
                        .forEach(pokemon -> {
                            jugadores[turnoActual].getPokemonsMuertos().add(pokemon);
                            pokemon.setVidaActual(0);
                        });
                jugadores[turnoActual].getPokemonsActivos().clear();
                break;

            default: throw new UnsupportedOperationException("Esa opción todavía no fue implementada");
        }


        /* Es muy raro esto, hablarlo con el grupo */
        jugadores[turnoActual].getPokemonActual().getEstado().aplicar(jugadores[turnoActual].getPokemonActual());
        return true;
    }

    /**
     * Le pide a cada jugador elegir un nombre y su pokemon inicial usando InputUsuario
     */
    public void comenzarBatalla(){
        campoDeBatallaView.mostrar("Bienvenidos a nuestro simulador de batallas pokemon!\n\n");

        for(int i = 0; i < jugadores.length; i++) {
            campoDeBatallaView.mostrar("Jugador " + (i+1) + ", elija un nombre: ");
            jugadores[i].setNombre(inputUsuario.obtenerCualquierDato(false));

            campoDeBatallaView.mostrar("Esta es su lista de pokemons, elija uno para iniciar:");
            campoDeBatallaView.mostrarListado(jugadores[i].getPokemonsActivos().stream().map(Pokemon::getNombre).collect(Collectors.toList()));
            jugadores[i].setPokemonActual(jugadores[i].getPokemonsActivos().remove(inputUsuario.obtenerOpcionNumerica(jugadores[i].getPokemonsActivos().size())-1));
            campoDeBatallaView.mostrar("Pokemon elegido: " + jugadores[i].getPokemonActual().getNombre());
        }
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
     * Compara a los dos jugadores utilizando la función enviada por parámetro y setea el turno inicial al valor mayor
     * @param comparator función comparadora
     */
    public void setJugadorInicial(Comparator<Jugador> comparator){
        turnoActual = comparator.compare(jugadores[0], jugadores[1]) > 0 ? 0 : 1;
    }

    /**
     * Verifica el turno actual y devuelve el id del otro jugador
     * @return El id del otro jugador
     */
    public int siguienteTurno(){
        return turnoActual==0 ? 1 : 0;
    }

    /**
     * Llama a la función mostrar del Output con el string de la información del campo
     */
    public void mostrarCampo(){
        campoDeBatallaView.mostrar(
                "Entrenador " + jugadores[0].getNombre() + " \n" +
                        jugadores[0].getPokemonActual().getNombre() + " (" + /*jugadores[0].getPokemonActual().getEstado().getTipo() + */")\n" +
                        jugadores[0].getPokemonActual().getHealthString() + " \n" +
                        "\n" +
                        "Entrenador " + jugadores[1].getNombre() + " \n" +
                        jugadores[1].getPokemonActual().getNombre() + " (" + /*jugadores[1].getPokemonActual().getEstado().getTipo() + */")\n" +
                        jugadores[1].getPokemonActual().getHealthString() + " \n" +
                        "\n" +
                        "Turno: " + jugadores[turnoActual].getNombre()
                );

        /* LAYOUT CAMPO
         Entrenador {nombreJugador1}
         {nombrePokemon1} ({estadoPokemon/nada})
         {vidaPokemon1}

         Entrenador {nombreJugador2}
         {nombrePokemon2} ({estadoPokemon/nada})
         {vidaPokemon2}

         Turno: {nombreJugador}
        */
    }

    private boolean operacionExitosa(int res, String mensaje){
        if(res <= 0){
            if(res == -1) {
                campoDeBatallaView.mostrar(mensaje);
            }
            return false;
        }
        return true;
    }

}