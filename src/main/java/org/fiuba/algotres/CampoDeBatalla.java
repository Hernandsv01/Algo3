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

    private Map<Integer, Comando> comandoMap;

    public CampoDeBatalla(Jugador[] jugadores){
        this.jugadores = jugadores;
        this.comandoMap = new HashMap<>();
        inicializarComandosDefault();
    }

    /**
     * Inicializa el map de comandos con los predeterminados para el juego
     */
    private void inicializarComandosDefault(){
        comandoMap.put(1, new ComandoHabilidad());
        comandoMap.put(2, new ComandoItem());
        comandoMap.put(3, new ComandoCambiarPokemon());
        comandoMap.put(4, new ComandoRendirse());
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
    public int siguienteTurno(){
        return turnoActual==0 ? 1 : 0;
    }

    /**
     * Agrega un nuevo comando al map de comandos, si ya existe un comando con esa clave, lo reemplaza
     * @param clave la clave que querés que tenga el comando que vas a agregar
     * @param valor el comando a agregar
     */
    public void agregarComando(Integer clave, Comando valor){
        comandoMap.put(clave, valor);
    }

    /**
     * Elimina el comando que tengo esa clave, no hace nada en caso de no existir
     * @param clave la clave del comando que se quiere remover
     */
    public void eliminarComando(Integer clave){
        comandoMap.remove(clave);
    }

}