package org.fiuba.algotres.model.clima;

import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.tipos.Tipos;

import java.util.ArrayList;
import java.util.Arrays;

public class TormentaArena extends Climas{

    private final int PORCENTAJEDANAR = 3;

    public TormentaArena(String nombre, CampoDeBatalla cdb){
        super(nombre, cdb);
        this.tiposFavorecidos = new ArrayList<Tipos>(Arrays.asList(
                Tipos.ROCA,
                Tipos.TIERRA
        ));
    }

    public void aplicarEfectos(Pokemon pokemon) {
        if(this.turnoValido()) {
            potenciarPokemon(pokemon);
            danarPokemon(pokemon);
        }
    }

    private void danarPokemon(Pokemon pokemon) {
        if( !(this.tiposFavorecidos.contains(pokemon.getTipos()))) {
            pokemon.danarPorPorcentaje(this.PORCENTAJEDANAR);
        }
    }

}
