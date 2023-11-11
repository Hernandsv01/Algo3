package org.fiuba.algotres.model.clima;

import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.tipos.Tipos;

import java.util.ArrayList;
import java.util.List;

public class SinClima extends Clima{

    public SinClima(String nombre, CampoDeBatalla cdb) {
        super(nombre, cdb);
        inicializarTiposFavorecidos();
    }
    public SinClima(String nombre) {
        super(nombre);
        inicializarTiposFavorecidos();
    }

    @Override
    public boolean turnoValido() {
        this.setTurnosAplicados(this.getTurnosAplicados() + 1);
        return true;
    }

    private void inicializarTiposFavorecidos(){
        this.setTiposFavorecidos(new ArrayList<>());
    }
}
