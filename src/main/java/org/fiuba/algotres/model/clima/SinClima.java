package org.fiuba.algotres.model.clima;

import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.tipos.Tipos;

import java.util.ArrayList;
import java.util.List;

public class SinClima extends Climas{

    public SinClima(String nombre, CampoDeBatalla cdb) {
        super(nombre, cdb);
        this.tiposFavorecidos = new ArrayList<>();
    }

}
