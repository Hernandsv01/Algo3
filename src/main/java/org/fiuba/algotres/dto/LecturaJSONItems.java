package org.fiuba.algotres.dto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.fiuba.algotres.model.habilidad.Ataque;
import org.fiuba.algotres.model.item.Item;
import org.fiuba.algotres.model.tipos.Tipos;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;

public class LecturaJSONItems {
    
        public static void main(String[] args) throws IOException, FileNotFoundException, InvalidDefinitionException, JsonParseException {
        ObjectMapper mapper = new ObjectMapper();
        File pathLeer = new File("src\\main\\java\\org\\fiuba\\algotres\\items.json");


       List<Item> a = mapper.readValue(pathLeer, new TypeReference<List<Item>>(){});
        for(int i = 0; i< a.size(); i++){
            System.out.println(a.get(i).getNombre());
            System.out.println(a.get(i).getCantidad());
        }
        
    }
}
