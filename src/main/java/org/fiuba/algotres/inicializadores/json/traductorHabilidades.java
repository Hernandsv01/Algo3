package org.fiuba.algotres.inicializadores.json;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.fiuba.algotres.inicializadores.json.dto.LecturaJSONHabilidades;
import org.fiuba.algotres.model.habilidad.Ataque;
import org.fiuba.algotres.model.habilidad.Habilidad;
import org.fiuba.algotres.model.habilidad.ModificacionEstadisticaAtaque;
import org.fiuba.algotres.model.habilidad.ModificacionEstadisticaDefensa;
import org.fiuba.algotres.model.habilidad.ModificacionEstadisticaVida;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;

public class traductorHabilidades {
    
    public traductorHabilidades() {
    }

    public static HashMap<Integer, Habilidad> traducirHabilidades() throws InvalidDefinitionException, JsonParseException, FileNotFoundException, IOException {
        HashMap<Integer, Habilidad> mapeoHabilidades = new HashMap<>();
        List<LecturaJSONHabilidades> lista = LecturaJSONHabilidades.leecturadearchivos();
        for(int i = 0; i< lista.size(); i++){
            if(lista.get(i).getPoder() != null){
                Ataque ataque = new Ataque(lista.get(i).getNombre(), lista.get(i).getUsos(), lista.get(i).getPoder(), lista.get(i).getTipo());
                mapeoHabilidades.put(lista.get(i).getId(), ataque);
            }
            else if(lista.get(i).getPorcentajeDefensa() != null){
                ModificacionEstadisticaDefensa modificacionDefensa = new ModificacionEstadisticaDefensa(lista.get(i).getNombre(), lista.get(i).getUsos(), lista.get(i).getPorcentajeDefensa());
                mapeoHabilidades.put(lista.get(i).getId(), modificacionDefensa);
            }
            else if(lista.get(i).getPorcentajeAtaque() != null){
                ModificacionEstadisticaAtaque modificacionAtaque = new ModificacionEstadisticaAtaque(lista.get(i).getNombre(), lista.get(i).getUsos(), lista.get(i).getPorcentajeAtaque());
                mapeoHabilidades.put(lista.get(i).getId(), modificacionAtaque);
            }
            else if(lista.get(i).getPorcentajeVida() != null){
                ModificacionEstadisticaVida modificacionVida = new ModificacionEstadisticaVida(lista.get(i).getNombre(), lista.get(i).getUsos(), lista.get(i).getPorcentajeVida());
                mapeoHabilidades.put(lista.get(i).getId(), modificacionVida);
            }
            else if(lista.get(i).getEstado() != null){
                //Estado estado = new Estado(lista.get(i).getNombre(), lista.get(i).getUsos(),new lista.get(i).getEstado());
                //System.out.println("estado");
            }
            else if(lista.get(i).getClima() != null){
                //Clima clima = new Clima(lista.get(i).getNombre());
                //System.out.println("clima");
            }
            else{
                //System.out.println("error");
            }}
        return mapeoHabilidades;


    
}
  // public static void main(String[] args) throws InvalidDefinitionException, JsonParseException, FileNotFoundException, IOException {
  //     traductorHabilidades traductor = new traductorHabilidades();
  //     System.out.println(traductor.traducirHabilidades());
  // }
}
