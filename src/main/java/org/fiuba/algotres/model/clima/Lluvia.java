package org.fiuba.algotres.model.clima;

import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.tipos.Tipos;

import java.util.ArrayList;
import java.util.Arrays;

public class Lluvia extends Clima{

    public Lluvia(String nombre, CampoDeBatalla cdb){
        super(nombre, cdb);
        inicializarTiposFavorecidos();
    }
    public Lluvia(String nombre){
        super(nombre);
        inicializarTiposFavorecidos();
    }
    private void inicializarTiposFavorecidos(){
        this.setTiposFavorecidos(new ArrayList<Tipos>(Arrays.asList(
                Tipos.AGUA,
                Tipos.PLANTA
        )));
    }

}
