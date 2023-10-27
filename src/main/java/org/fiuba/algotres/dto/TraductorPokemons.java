package org.fiuba.algotres.dto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.fiuba.algotres.dto.traductorHabilidades;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.habilidad.Habilidad;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;

public class TraductorPokemons {
    private List<Habilidad> habilidades =  new ArrayList<>();
        
    public TraductorPokemons() {
        }

    public List<Habilidad> mapearHabilidades(List<LecturaJSONPokemons> a) throws InvalidDefinitionException, JsonParseException, FileNotFoundException, IOException {
        List<Habilidad> listaHabilidades = new ArrayList<>();
        HashMap<Integer, Habilidad> hashHabilidades = traductorHabilidades.traducirHabilidades();
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).getHabilidades().size(); j++){
                int habilidadId = a.get(i).getHabilidades().get(j);
                if(hashHabilidades.containsKey(habilidadId)){
                    listaHabilidades.add(hashHabilidades.get(habilidadId));
                }
                else{
                    System.out.println("error");
            }}
        }
        return listaHabilidades;
    }
    
    public void traducirPokemons() throws StreamReadException, DatabindException, IOException {
            
        List<LecturaJSONPokemons> lista = LecturaJSONPokemons.leecturadearchivos();
        for(int i = 0; i< lista.size(); i++){
            //Pokemon pokemon = new Pokemon(lista.get(i).getNombre(), lista.get(i).getNivel(), lista.get(i).getTipo(), lista.get(i).getHistoria(), lista.get(i).getVidaMaxima(), lista.get(i).getVelocidad(), lista.get(i).getDefensa(), lista.get(i).getAtaque(), lista.get(i).getHabilidades());
        }
    }
}
