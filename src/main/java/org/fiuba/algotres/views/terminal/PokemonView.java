package org.fiuba.algotres.views.terminal;

import org.fiuba.algotres.model.Pokemon;

import java.util.List;

public class PokemonView {
    public static int imprimirHabilidadesPokemon(Pokemon pokemon){
        int res;
        for(res = 1; res <= pokemon.getHabilidades().size(); res++){
            System.out.println("\t" + res + ") " + pokemon.getHabilidades().get(res-1).getNombre());
        }
        System.out.println("\t" + res + ") Volver");
        return res;
    }
    public static int imprimirPokemons(List<Pokemon> pokemons, boolean opcionVolver){
        int res;
        for(res = 1; res <= pokemons.size(); res++){
            System.out.println("\t" + res + ") " + pokemons.get(res-1).getNombre());
        }
        if(opcionVolver) {
            System.out.println("\t" + res + ") Volver");
            return res;
        }else{
            return res-1;
        }
    }
}
