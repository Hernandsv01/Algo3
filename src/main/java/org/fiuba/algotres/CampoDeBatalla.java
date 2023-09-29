package org.fiuba.algotres;

import lombok.Getter;
import lombok.Setter;
import org.fiuba.algotres.comandos.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@Getter @Setter
public class CampoDeBatalla {
    private Jugador[] jugadores;
    private int turnoActual;

    private Map<Integer, Comando> comandoMap = new HashMap<>();

    public CampoDeBatalla(Jugador[] jugadores){
        this.jugadores = jugadores;
        inicializarComandos();
    }

    private void inicializarComandos(){
        comandoMap.put(1, new ComandoHabilidad());
        comandoMap.put(2, new ComandoItem());
        comandoMap.put(3, new ComandoCambiarPokemon());
        comandoMap.put(4, new ComandoRendirse());
    }

    /**
     * Ejecuta el ciclo completo de un turno de un jugador
     * @return True si se pudo completar, false en caso contrario
     */
    public boolean turnoJugador(){

        int opcionElegida = 1;/*Acá iría inputUsuario*/

        int res;
        switch (opcionElegida) {
            case 1:
                res = jugadores[turnoActual].elegirHabilidad();
                if(res<=0) return false;

                jugadores[turnoActual].getPokemonActual().getHabilidades().get(res).accionarHabilidad(null, null);
                break;

            case 2:
                res = jugadores[turnoActual].elegirItem();
                if(res<=0) return false;

                res = jugadores[turnoActual].usarItem(res);
                if(res<=0) return false;
                break;

            case 3:
                res = jugadores[turnoActual].cambiarPokemonActual();
                if(res<=0) return false;
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

    private boolean operacionExitosa(int res, String mensaje){
        return res > 0;
    }

}