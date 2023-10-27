package org.fiuba.algotres.dto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.fiuba.algotres.model.item.CuraTodo;
import org.fiuba.algotres.model.item.EstadisticaAtaque;
import org.fiuba.algotres.model.item.EstadisticaDefensa;
import org.fiuba.algotres.model.item.Pocion;
import org.fiuba.algotres.model.item.Revivir;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;

public class traductorItems {

    public traductorItems() {
    }

    public void traducirItems() throws InvalidDefinitionException, JsonParseException, FileNotFoundException, IOException {
        
        List<LecturaJSONItems> lista = LecturaJSONItems.leecturadearchivos();
        for(int i = 0; i< lista.size(); i++){
            if(lista.get(i).getCantidadDeVida() != null){
                Pocion pocion = new Pocion(lista.get(i).getCantidad(), lista.get(i).getNombre(), lista.get(i).getCantidadDeVida());
                System.out.println("pocion");
            }
            else if(lista.get(i).getEstadisticaDefensa() != null){
                EstadisticaDefensa estadisticaDefensa = new EstadisticaDefensa(lista.get(i).getCantidad(), lista.get(i).getNombre(),  lista.get(i).getEstadisticaDefensa());
                System.out.println("estadistica defensa");
            }
            else if(lista.get(i).getEstadisticaAtaque() != null){
                EstadisticaAtaque estadisticaAtaque = new EstadisticaAtaque(lista.get(i).getCantidad(), lista.get(i).getNombre(),  lista.get(i).getEstadisticaAtaque());
                System.out.println("estadistica ataque");
            }
            else if(lista.get(i).isCuraTodo() != false){
                CuraTodo curaTodo = new CuraTodo(lista.get(i).getCantidad(), lista.get(i).getNombre());
                System.out.println("cura todo");
            }
            else if(lista.get(i).isRevivir() != false){
                Revivir revivir = new Revivir(lista.get(i).getCantidad(), lista.get(i).getNombre());
                System.out.println("revivir");
            }
            else{
                System.out.println("error");
            }
        }
    }

    public static void main(String[] args) throws InvalidDefinitionException, JsonParseException, FileNotFoundException, IOException {
        traductorItems traductor = new traductorItems();
        traductor.traducirItems();

    }
}
