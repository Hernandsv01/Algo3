package org.fiuba.algotres;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.fiuba.algotres.herramientas.EntradaSalida.*;

@Getter @Setter
public class Jugador {
    private ArrayList<Pokemon> pokemonsActivos/* = new ArrayList<Pokemon>(Arrays.asList(
            new Pokemon(), new Pokemon(), new Pokemon(), new Pokemon(), new Pokemon()
    ))*/;
    private ArrayList<Pokemon> pokemonsMuertos;
    private ArrayList<Item> items;
    private Pokemon pokemonActual/* = new Pokemon()*/;
    private String nombre;

    /**
     *
     * @return True si la acción se pudo completar, false en caso contrario
     */
    public boolean elegirHabilidad(Juego juego) {
        limpiarConsola();
        System.out.println("Habilidades disponibles:");
        for(int i = 0; i < pokemonActual.habilidades.size(); i++){
            System.out.println("\t" + (i+1) + ") " + pokemonActual.habilidades.get(i));
        }

        // Obtener opcion elegida
        int opcionElegida = obtenerOpcionUsuario(pokemons.size()+1);

        // Verificar si la opción elegida fue volver
        if(opcionElegida == pokemonActual.habilidades.size()+1){
            return false;
        }
        // Verificar si la opción elegida fue la habilidad 1
        else if (opcionElegida == 1) {
            pokemonActual.habilidades[opcionElegid-1
                    g].accionarHabilidad((turnoActual == 1 ? jugador1 : jugador2).pokemonActual,(turnoActual == 1 ? jugador2 : jugador1).pokemonActual)
        }
        // Verificar si la opción elegida fue la habilidad 2
        else if (opcionElegida == 2) {
            pokemonActual.habilidades[opcionElegid-1].accionarHabilidad((turnoActual == 1 ? jugador1 : jugador2).pokemonActual,(turnoActual == 1 ? jugador2 : jugador1).pokemonActual)

        }
        // Verificar si la opción elegida fue la habilidad 3
        else if (opcionElegida == 3) {
            pokemonActual.habilidades[opcionElegid-1].accionarHabilidad((turnoActual == 1 ? jugador1 : jugador2).pokemonActual,(turnoActual == 1 ? jugador2 : jugador1).pokemonActual)
        }
        // Verificar si la opción elegida fue la habilidad 4
        else if (opcionElegida == 4) {
            pokemonActual.habilidades[opcionElegid-1].accionarHabilidad((turnoActual == 1 ? jugador1 : jugador2).pokemonActual,(turnoActual == 1 ? jugador2 : jugador1).pokemonActual)
        }
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
        //imprimirCampo(juego);
        System.out.println("Pokemones disponibles:");
        for(int i = 0; i < pokemonsActivos.size(); i++){
            System.out.println("\t" + (i+1) + ") " + pokemonsActivos.get(i));
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
