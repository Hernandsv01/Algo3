package org.fiuba.algotres.model.clima;

import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.tipos.Tipos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Niebla extends Climas{

    public Niebla(String nombre, CampoDeBatalla cdb){
        super(nombre, cdb);
        this.tiposFavorecidos = new ArrayList<Tipos>(Arrays.asList(
                Tipos.FANTASMA,
                Tipos.PSIQUICO
        ));

    }

}
