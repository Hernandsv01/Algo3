package org.fiuba.algotres.model.clima;

import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.tipos.Tipos;

import java.util.ArrayList;
import java.util.Arrays;

public class Soleado extends Clima{

    public Soleado(String nombre, CampoDeBatalla cdb){
        super(nombre, cdb);
        inicializarTiposFavorecidos();
    }
    public Soleado(String nombre){
        super(nombre);
        inicializarTiposFavorecidos();
    }

    private void inicializarTiposFavorecidos(){
        this.setTiposFavorecidos(new ArrayList<Tipos>(Arrays.asList(
                Tipos.FUEGO
        )));
    }

}
