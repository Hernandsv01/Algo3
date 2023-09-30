package org.fiuba.algotres.comandos;

import org.fiuba.algotres.Jugador;
import org.fiuba.algotres.Pokemon;

import java.util.Map;

public class ComandoCambiarPokemon implements Comando {
    @Override
    public boolean ejecutar(Map<String, Object> parametros) {
        if(!parametrosValidos(parametros)){
            return false;
        }

        try{
            Jugador jugador = (Jugador) parametros.get("jugador");
            int posicionPokemon = (int) parametros.get("posicionPokemon");
            return jugador.cambiarPokemonActual(posicionPokemon);
        }catch(ClassCastException e){
            System.out.println("Error en la ejecución de cambio de pokemon actual por parametros erroneos: " + e.getMessage());
            return false;
        }catch(Exception e){
            System.out.println("Los parametros eran del tipo correcto pero algo salió mal cambiando el pokemon: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean parametrosValidos(Map<String, Object> parametros) {
        return parametros.containsKey("jugador") &&
                parametros.containsKey("posicionPokemon");
    }
}
