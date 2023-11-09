package org.fiuba.algotres.model.clima;

import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.tipos.Tipos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lluvia extends Clima{

    public Lluvia(String nombre, CampoDeBatalla cdb){
        super(nombre, cdb);
        this.setTiposFavorecidos(new ArrayList<Tipos>(Arrays.asList(
                Tipos.AGUA,
                Tipos.PLANTA
        )));
    }

}
