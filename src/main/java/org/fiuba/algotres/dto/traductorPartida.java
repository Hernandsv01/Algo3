package org.fiuba.algotres.dto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.fiuba.algotres.model.Jugador;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.item.Item;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;

public class traductorPartida {
    
    public traductorPartida() {
    }


    public static List<Item> mapearItemsJugador2() throws InvalidDefinitionException, JsonParseException, FileNotFoundException, IOException {
        List<Item> listaItems = new ArrayList<>();
        List<LecturaJSONPartida> listaInicial =LecturaJSONPartida.leecturaDeArchivo();
        HashMap<String, Integer> lista = listaInicial.get(1).getItems();
        HashMap<Integer, Item> hashItems = new traductorItems().traducirItems();
        for (String itemIdStr : lista.keySet()) {
            int itemId = Integer.parseInt(itemIdStr);
            System.out.println(itemId);
            if (hashItems.containsKey(itemId)) {
                Item item = hashItems.get(itemId);
                if (item != null) {
                    listaItems.add(item);
                } else {
                    System.out.println("El valor del ítem con ID " + itemId + " es nulo.");
                }
            } else {
                System.out.println("error");
            }
        }
        System.out.println(listaItems);
        return listaItems;
    }
    
    public static List<Item> mapearItemsJugador1() throws InvalidDefinitionException, JsonParseException, FileNotFoundException, IOException {
        List<Item> listaItems = new ArrayList<>();
        List<LecturaJSONPartida> listaInicial =LecturaJSONPartida.leecturaDeArchivo();
        HashMap<String, Integer> lista = listaInicial.get(0).getItems();
        HashMap<Integer, Item> hashItems = new traductorItems().traducirItems();
        for (String itemIdStr : lista.keySet()) {
            int itemId = Integer.parseInt(itemIdStr);
            System.out.println(itemId);
            if (hashItems.containsKey(itemId)) {
                Item item = hashItems.get(itemId);
                if (item != null) {
                    listaItems.add(item);
                } else {
                    System.out.println("El valor del ítem con ID " + itemId + " es nulo.");
                }
            } else {
                System.out.println("error");
            }
        }
        System.out.println(listaItems);
        return listaItems;
    }

    public static ArrayList<Pokemon> mapearPokemonsJugador1() throws StreamReadException, DatabindException, IOException{
        List<LecturaJSONPartida> listaInicial =LecturaJSONPartida.leecturaDeArchivo();
        List<Integer> lista = listaInicial.get(0).getPokemons();
        System.out.println(lista);
        ArrayList<Pokemon> listaPokemons = new ArrayList<>();
        HashMap<Integer, Pokemon> hashPokemons = new TraductorPokemons().traducirPokemons();
        for(int i = 0; i< lista.size(); i++){
            if(hashPokemons.containsKey(lista.get(i))){
                Pokemon pokemon = hashPokemons.get(lista.get(i));
                if(pokemon != null){
                    listaPokemons.add(pokemon);
                    System.out.println(pokemon.getHabilidades());
                }
                else{
                    System.out.println("El valor del pokemon con ID " + lista.get(i) + " es nulo.");
                }
            }
            else{
                System.out.println("error");
            }
        }
        System.out.println(listaPokemons);
        return listaPokemons;
    }

        public static ArrayList<Pokemon> mapearPokemonsJugador2() throws StreamReadException, DatabindException, IOException{
        List<LecturaJSONPartida> listaInicial =LecturaJSONPartida.leecturaDeArchivo();
        List<Integer> lista = listaInicial.get(1).getPokemons();
        System.out.println(lista);
        ArrayList<Pokemon> listaPokemons = new ArrayList<>();
        HashMap<Integer, Pokemon> hashPokemons = new TraductorPokemons().traducirPokemons();
        for(int i = 0; i< lista.size(); i++){
            if(hashPokemons.containsKey(lista.get(i))){
                Pokemon pokemon = hashPokemons.get(lista.get(i));
                if(pokemon != null){
                    listaPokemons.add(pokemon);
                    System.out.println(pokemon.getHabilidades());
                }
                else{
                    System.out.println("El valor del pokemon con ID " + lista.get(i) + " es nulo.");
                }
            }
            else{
                System.out.println("error");
            }
        }
        System.out.println(listaPokemons);
        return listaPokemons;
    }


    public static Jugador jugador1() throws StreamReadException, DatabindException, IOException{
        List<LecturaJSONPartida> listaInicial =LecturaJSONPartida.leecturaDeArchivo();
        listaInicial.get(0).getNombre();
        Jugador jugador1 = new Jugador(listaInicial.get(0).getNombre();, mapearPokemonsJugador1(), mapearItemsJugador1());
        return jugador1;
    }

    public static Jugador jugador2() throws StreamReadException, DatabindException, IOException{
        List<LecturaJSONPartida> listaInicial =LecturaJSONPartida.leecturaDeArchivo();
        listaInicial.get(0).getNombre();
        Jugador jugador2 = new Jugador(listaInicial.get(1).getNombre();, mapearPokemonsJugador2(), mapearItemsJugador2());
        return jugador2;
    }

}
