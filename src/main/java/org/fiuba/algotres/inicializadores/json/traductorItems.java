package org.fiuba.algotres.inicializadores.json;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.fiuba.algotres.inicializadores.json.dto.LecturaJSONItems;
import org.fiuba.algotres.model.item.CuraTodo;
import org.fiuba.algotres.model.item.EstadisticaAtaque;
import org.fiuba.algotres.model.item.EstadisticaDefensa;
import org.fiuba.algotres.model.item.Item;
import org.fiuba.algotres.model.item.Pocion;
import org.fiuba.algotres.model.item.Revivir;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;

public class traductorItems {

    public traductorItems() {
    }

    public HashMap<Integer, Item> traducirItems() throws InvalidDefinitionException, JsonParseException, FileNotFoundException, IOException {
        HashMap<Integer, Item> mapeoItem = new HashMap<>();
        List<LecturaJSONItems> lista = LecturaJSONItems.leecturaDeArchivo();
        for(int i = 0; i< lista.size(); i++){
            if(lista.get(i).getCantidadDeVida() != null){
                Pocion pocion = new Pocion(lista.get(i).getCantidad(), lista.get(i).getNombre(), lista.get(i).getCantidadDeVida());
                mapeoItem.put(lista.get(i).getId(), pocion);
                //System.out.println("pocion");
            }
            else if(lista.get(i).isRevivir()){
                Revivir revivir = new Revivir(lista.get(i).getCantidad(), lista.get(i).getNombre());
                mapeoItem.put(lista.get(i).getId(), revivir);
                //System.out.println("revivir");
            }
            else if(lista.get(i).getEstadisticaDefensa() != null){
                EstadisticaDefensa estadisticaDefensa = new EstadisticaDefensa(lista.get(i).getCantidad(), lista.get(i).getNombre(),  lista.get(i).getEstadisticaDefensa());
                mapeoItem.put(lista.get(i).getId(), estadisticaDefensa);
                //System.out.println("estadistica defensa");
            }
            else if(lista.get(i).getEstadisticaAtaque() != null){
                EstadisticaAtaque estadisticaAtaque = new EstadisticaAtaque(lista.get(i).getCantidad(), lista.get(i).getNombre(),  lista.get(i).getEstadisticaAtaque());
                mapeoItem.put(lista.get(i).getId(), estadisticaAtaque);
                //System.out.println("estadistica ataque");
            }
            else if(lista.get(i).isCuraTodo() != false){
                CuraTodo curaTodo = new CuraTodo(lista.get(i).getCantidad(), lista.get(i).getNombre());
                mapeoItem.put(lista.get(i).getId(), curaTodo);
                //System.out.println("cura todo");
            }

            else{
                System.out.println("error");
            }
        }
        return mapeoItem;
    }

  //public static void main(String[] args) throws InvalidDefinitionException, JsonParseException, FileNotFoundException, IOException {
  //    traductorItems traductor = new traductorItems();
  //    HashMap<Integer, Item> items = traductor.traducirItems();

  //}
}
