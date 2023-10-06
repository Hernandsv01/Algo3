package org.fiuba.algotres;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

@Getter @Setter
public class CampoDeBatalla {
    private Jugador[] jugadores;
    private int turnoActual;

    public CampoDeBatalla(Jugador[] jugadores){
        this.jugadores = jugadores;
    }

    /**
     * Verifica la vida de cada uno de los pokemons de los jugadores para ver si alguno tiene vida
     * @return El número del jugador que ganó o -1 en caso de que ambos tengan pokemons con vida.
     */
    public int getGanador(){
        if(jugadores[0].getPokemonsActivos().isEmpty() && jugadores[0].getPokemonActual() == null) return 1;
        if(jugadores[1].getPokemonsActivos().isEmpty() && jugadores[1].getPokemonActual() == null) return 0;
        return -1;
    }

    /**
     * Compara a los dos jugadores utilizando la función enviada por parámetro y setea el turno inicial al valor mayor
     * @param comparator función comparadora
     */
    public void setJugadorInicialPorAtributo(Comparator<Jugador> comparator){
        turnoActual = comparator.compare(jugadores[0], jugadores[1]) > 0 ? 0 : 1;
    }

    /**
     * Verifica el turno actual y devuelve el id del otro jugador
     * @return El id del otro jugador
     */
    public int getSiguienteTurno(){
        return turnoActual==0 ? 1 : 0;
    }
    
    public void setSiguienteTurno(){
        turnoActual = turnoActual==0 ? 1 : 0;
    }
    
    public Jugador getJugadorActual(){
        return jugadores[turnoActual];
    }

}