package org.fiuba.algotres;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.fiuba.algotres.habilidad.Habilidad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.fiuba.algotres.herramientas.EntradaSalida.*;

@Getter @Setter
public class Jugador {
    private List<Pokemon> pokemonsActivos;
    private List<Pokemon> pokemonsMuertos;
    private Pokemon pokemonActual;
    private String nombre;

    public Jugador(List<Pokemon> pokemonsActivos) {
        this.pokemonsActivos = pokemonsActivos;
        this.pokemonsMuertos = new ArrayList<>();
    }

    /**
     *
     * @return True si la acción se pudo completar, false en caso contrario
     */
    public boolean elegirHabilidad(Juego juego) {
        // Imprimir información
        imprimirCampo(juego);
        System.out.println("Opciones:");
        for(int i = 0; i < pokemonActual.getHabilidades().size(); i++){
            System.out.println("\t" + (i+1) + ") " + pokemonActual.getHabilidades().get(i).getNombre());
        }

        // Obtener opción y accionar
        int opcionElegida = obtenerOpcionUsuario(pokemonActual.getHabilidades().size()+1);
        if(opcionElegida != pokemonActual.getHabilidades().size()+1){
            pokemonActual.getHabilidades().get(opcionElegida-1).accionarHabilidad(pokemonActual, juego.getTurnoActual() == 1 ? juego.getJugador2().getPokemonActual() : juego.getJugador1().getPokemonActual());
            return true;
        }else{
            return false;
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
        imprimirCampo(juego);
        System.out.println("Pokemones disponibles:");
        for(int i = 0; i <= pokemonsActivos.size(); i++){
            System.out.println("\t" + (i+1) + ") " + (i < pokemonsActivos.size() ? pokemonsActivos.get(i).toString() : "Volver"));
        }

        // Obtener opcion elegida
        int opcionElegida = obtenerOpcionUsuario(pokemonsActivos.size()+1);

        // Verificar si la opción elegida fue volver
        if(opcionElegida == pokemonsActivos.size()+1){
            return false;
        }

        // Intercambiar
        Pokemon aux = pokemonActual;
        pokemonActual = pokemonsActivos.get(opcionElegida-1);
        pokemonsActivos.set(opcionElegida-1, aux);

        return true;
    }
}
