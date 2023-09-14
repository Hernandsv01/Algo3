package org.fiuba.algotres;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.fiuba.algotres.herramientas.EntradaSalida.*;

@Getter @Setter
public class Jugador {
    private ArrayList<Pokemon> pokemons/* = new ArrayList<Pokemon>(Arrays.asList(
            new Pokemon(), new Pokemon(), new Pokemon(), new Pokemon(), new Pokemon()
    ))*/;
    private Pokemon pokemonActual/* = new Pokemon()*/;
    private String nombre;

    /**
     *
     * @return True si la acción se pudo completar, false en caso contrario
     */
    public boolean elegirHabilidad(Juego juego) {
        return true;
    }

    /**
     *
     * @return True si la acción se pudo completar, false en caso contrario
     */
    public boolean elegirItem(Juego juego) {
        return false;
    }

    /**
     *
     * @return True si la acción se pudo completar, false en caso contrario
     */
    public boolean cambiarPokemonActual(Juego juego) {
        // Imprimir info
        limpiarConsola();
        imprimirCampo(juego);
        System.out.println("Pokemones disponibles:");
        /* FALTA MOSTRAR SOLO LOS POKEMONS QUE TIENEN VIDA */
        for(int i = 0; i <= pokemons.size(); i++){
            System.out.println("\t" + (i+1) + ") " + (i < pokemons.size() ? pokemons.get(i).toString() : "Volver"));
        }

        // Obtener opcion elegida
        int opcionElegida = obtenerOpcionUsuario(pokemons.size()+1);

        // Verificar si la opción elegida fue volver
        if(opcionElegida == pokemons.size()+1){
            return false;
        }

        // Intercambiar
        Pokemon aux = pokemonActual;
        pokemonActual = pokemons.get(opcionElegida-1);
        pokemons.set(opcionElegida-1, aux);

        return true;
    }
}
