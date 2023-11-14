package org.fiuba.algotres.model.clima;

import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.tipos.Tipos;

import java.util.ArrayList;
import java.util.Arrays;

public class TormentaArena extends Clima{

    private final int PORCENTAJE_DANAR = 3;

    public TormentaArena(String nombre, CampoDeBatalla cdb){
        super(nombre, cdb);
        inicializarTiposFavorecidos();
    }
    public TormentaArena(String nombre){
        super(nombre);
        inicializarTiposFavorecidos();
    }

    @Override
    public void aplicarEfectos(Pokemon pokemon) {
        if(this.turnoValido()) {
            potenciarPokemon(pokemon);
            danarPokemon(pokemon);
        }
    }

    /**
     * Dana al pokemon si no se encuentra favorecido con el clima
     * @param pokemon al cual danara o no
     */
    private void danarPokemon(Pokemon pokemon) {
        if( !(this.getTiposFavorecidos().contains(pokemon.getTipos()))) {
            pokemon.danarPorPorcentaje(this.PORCENTAJE_DANAR);
        }
    }

    private void inicializarTiposFavorecidos(){
        this.setTiposFavorecidos(new ArrayList<Tipos>(Arrays.asList(
                Tipos.ROCA,
                Tipos.TIERRA
        )));
    }

}
