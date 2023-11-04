package org.fiuba.algotres.model.clima;

import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.tipos.Tipos;

import java.util.ArrayList;
import java.util.List;

public class SinClima extends Clima{

    public SinClima(String nombre, CampoDeBatalla cdb) {
        super(nombre, cdb);
        this.setTiposFavorecidos(new ArrayList<>());
    }

    @Override
    public boolean turnoValido() {
        this.setTurnosAplicados(this.getTurnosAplicados() + 1);
        return true;
    }

    public void potenciarPokemon(Pokemon pokemon){};
}
