package org.fiuba.algotres.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.fiuba.algotres.model.item.Item;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class Jugador {
    private List<Pokemon> pokemons;
    private List<Item> items;
    private String nombre;

    public Jugador(List<Pokemon> pokemons, List<Item> items) {
        this.pokemons = pokemons;
        this.items = items;
    }

    /**
     * Intercambia el pokemon actual con uno de la lista de pokemons vivos
     * @param posPokemonVivos la posición del pokemon en la lista de pokemons vivos que se quiere reemplazar con el actual
     * @return true si se cambió de pokemón y false si no hay más pokemons vivos
     */
    public boolean cambiarPokemonActual(int posPokemonVivos) {
        int posPokemonGeneral;
        try {
            posPokemonGeneral = pokemons.indexOf(getPokemonsVivos().get(posPokemonVivos));
        }catch(Exception e){
            return false;
        }

        Collections.swap(pokemons, 0, posPokemonGeneral);

        return true;
    }

    /**
     * Mata a todos los pokemons del jugador
     */
    public void rendirse(){
        pokemons.forEach(Pokemon::matar);
    }

    public Pokemon getPokemonActual(){
        return pokemons.get(0);
    }

    public List<Pokemon> getPokemonsVivos(){
        return pokemons.stream()
                .filter(Pokemon::estaVivo)
                .collect(Collectors.toList());
    }

    public List<Pokemon> getPokemonsMuertos(){
        return pokemons.stream()
                .filter(pokemon -> !pokemon.estaVivo())
                .collect(Collectors.toList());
    }
}
