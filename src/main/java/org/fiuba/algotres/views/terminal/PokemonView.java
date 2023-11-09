package org.fiuba.algotres.views.terminal;

import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.habilidad.Habilidad;
import org.fiuba.algotres.views.OutputUsuario;

import java.util.List;

public class PokemonView {

    private static OutputUsuario output = new OutputUsuarioTerminal();

    public static int imprimirHabilidadesPokemon(Pokemon pokemon){
        int res;
        for(res = 1; res <= pokemon.getHabilidades().size(); res++){
            Habilidad habilidad = pokemon.getHabilidades().get(res-1);
            System.out.println("\t" + res + ") " + habilidad.getNombre() + " (" + habilidad.getUsos() + " usos)");
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

    public void setOutput(OutputUsuario output){
        PokemonView.output = output;
    }
}
