package org.fiuba.algotres;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.fiuba.algotres.habilidad.Habilidad;
import org.fiuba.algotres.item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class Jugador {
    private List<Pokemon> pokemonsActivos;
    private List<Pokemon> pokemonsMuertos;
    private List<Item> items;
    private Pokemon pokemonActual;
    private String nombre;

    public Jugador(List<Pokemon> pokemonsActivos, List<Item> items) {
        this.pokemonsActivos = pokemonsActivos;
        this.pokemonsMuertos = new ArrayList<>();
        this.items = items;
    }

    /**
     * Intercambia el pokemon actual con uno de la lista de pokemons vivos
     * @param posPokemon la posición del pokemon en la lista de pokemons activos que se quiere reemplazar como el actual
     * @return true si se cambió de pokemón y false si no hay más pokemons vivos
     */
    public boolean cambiarPokemonActual(int posPokemon) {
        Pokemon pokemonNuevo;
        try {
            pokemonNuevo = pokemonsActivos.remove(posPokemon);
        }catch (IndexOutOfBoundsException e){
            return false;
        }
        pokemonsActivos.add(pokemonActual);
        pokemonActual = pokemonNuevo;

        return true;
    }

    /**
     * Llena la vida del pokemon y lo pone en la lista de pokemons activos
     * @param posPokemon la posición del pokemon a revivir en el array de pokemons muertos
     * @return true si la operación fue exitosa, false si no hay un pokemon en la posición enviada
     */
    public boolean revivirPokemon(int posPokemon) {
        Pokemon pokemon;
        try {
            pokemon = pokemonsMuertos.remove(posPokemon);
        }catch (IndexOutOfBoundsException e){
            return false;
        }
        pokemonsActivos.add(pokemon);
        pokemon.curar();
        return true;
    }

    /**
     * Pone la vida del pokemonActual en cero, lo mueve a la lista de pokemons muertos y pone al siguiente en la lista de vivos en su lugar.
     * Si no hay mas pokemons vivos, se deja nulo.
     */
    public void matarPokemonActual(){
        pokemonActual.matar();
        pokemonsMuertos.add(pokemonActual);
        if(pokemonsActivos.isEmpty()){
            pokemonActual = null;
        }else{
            pokemonActual = pokemonsActivos.remove(0);
        }
    }
}
