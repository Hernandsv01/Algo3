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
        
    public TraductorPokemons() {
        }

    public List<Habilidad> mapearHabilidades(LecturaJSONPokemons a) throws InvalidDefinitionException, JsonParseException, FileNotFoundException, IOException {
        List<Habilidad> listaHabilidades = new ArrayList<>();
        HashMap<Integer, Habilidad> hashHabilidades = traductorHabilidades.traducirHabilidades();
        for (int i = 0; i < a.getHabilidades().size(); i++) {
                int habilidadId = a.getHabilidades().get(i);
                if(hashHabilidades.containsKey(habilidadId)){
                    listaHabilidades.add(hashHabilidades.get(habilidadId));
                }
        }
        return listaHabilidades;
    }
    
    public HashMap<Integer, Pokemon> traducirPokemons() throws StreamReadException, DatabindException, IOException {
        HashMap<Integer, Pokemon> mapeoPokemon = new HashMap<>();
        List<LecturaJSONPokemons> lista = LecturaJSONPokemons.leecturadearchivos();
        for(int i = 0; i< lista.size(); i++){
            List<Habilidad> listaHabilidades = mapearHabilidades(lista.get(i));
            mapeoPokemon.put(lista.get(i).getId(),new Pokemon(lista.get(i).getNombre(), lista.get(i).getNivel(), lista.get(i).getTipo(), lista.get(i).getHistoria(), lista.get(i).getVidaMaxima(), lista.get(i).getVelocidad(), lista.get(i).getDefensa(), lista.get(i).getAtaque(), listaHabilidades)) ;
        }
        return mapeoPokemon;
    }

}
