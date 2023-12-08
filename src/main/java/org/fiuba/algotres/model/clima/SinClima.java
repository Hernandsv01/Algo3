package org.fiuba.algotres.model.clima;

import org.fiuba.algotres.model.CampoDeBatalla;

import java.util.ArrayList;

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
