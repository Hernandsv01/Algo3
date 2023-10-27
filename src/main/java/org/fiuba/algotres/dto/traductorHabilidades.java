package org.fiuba.algotres.dto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.fiuba.algotres.model.estado.Estado;
import org.fiuba.algotres.model.habilidad.Ataque;
import org.fiuba.algotres.model.habilidad.ModificacionEstadisticaAtaque;
import org.fiuba.algotres.model.habilidad.ModificacionEstadisticaDefensa;
import org.fiuba.algotres.model.habilidad.ModificacionEstadisticaVida;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;

public class traductorHabilidades {
    
    public traductorHabilidades() {
    }

    public void traducirHabilidades() throws InvalidDefinitionException, JsonParseException, FileNotFoundException, IOException {
        //LecturaJSONHabilidades lector = new LecturaJSONHabilidades();
        
        List<LecturaJSONHabilidades> lista = LecturaJSONHabilidades.leecturadearchivos();
        for(int i = 0; i< lista.size(); i++){
            if(lista.get(i).getPoder() != null){
                Ataque ataque = new Ataque(lista.get(i).getNombre(), lista.get(i).getUsos(), lista.get(i).getPoder(), lista.get(i).getTipo());
            }
            else if(lista.get(i).getPorcentajeDefensa() != null){
                ModificacionEstadisticaDefensa defensa = new ModificacionEstadisticaDefensa(lista.get(i).getNombre(), lista.get(i).getUsos(), lista.get(i).getPorcentajeDefensa());
            }
            else if(lista.get(i).getPorcentajeAtaque() != null){
                ModificacionEstadisticaAtaque ataque = new ModificacionEstadisticaAtaque(lista.get(i).getNombre(), lista.get(i).getUsos(), lista.get(i).getPorcentajeAtaque());
            }
            else if(lista.get(i).getPorcentajeVida() != null){
                ModificacionEstadisticaVida ataque = new ModificacionEstadisticaVida(lista.get(i).getNombre(), lista.get(i).getUsos(), lista.get(i).getPorcentajeVida());
            }
            else if(lista.get(i).getEstado() != null){
                //Estado estado = new Estado(lista.get(i).getNombre(), lista.get(i).getUsos(),new lista.get(i).getEstado());
                System.out.println("estado");
            }
            else if(lista.get(i).getClima() != null){
                //Clima clima = new Clima(lista.get(i).getNombre());
                System.out.println("clima");
            }
            else{
                System.out.println("error");
            }

    }
}
public static void main(String[] args) throws InvalidDefinitionException, JsonParseException, FileNotFoundException, IOException {
        traductorHabilidades traductor = new traductorHabilidades();
        traductor.traducirHabilidades();
        System.out.println("aaaaa");
    }
}
