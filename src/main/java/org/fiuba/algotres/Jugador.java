package org.fiuba.algotres;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.fiuba.algotres.herramientas.EntradaSalida.*;

@Getter @Setter
public class Jugador {
    private List<Pokemon> pokemonsActivos;
    private List<Pokemon> pokemonsMuertos;
    private List<Item> items;
    private Pokemon pokemonActual;
    private String nombre;

    public Jugador(List<Pokemon> pokemonsActivos, List<Pokemon> pokemonsMuertos, List<Item> items, Pokemon pokemonActual, String nombre) {
        this.pokemonsActivos = pokemonsActivos;
        this.pokemonsMuertos = pokemonsMuertos;
        this.items = items;
        this.pokemonActual = pokemonActual;
        this.nombre = nombre;
    }
    public Jugador(List<Pokemon> pokemonsActivos, List<Item> items){
        this.pokemonsActivos = pokemonsActivos;
        this.items = items;
    }

    /**
     *
     * @return True si la acción se pudo completar, false en caso contrario
     */
    public boolean elegirHabilidad(Juego juego) {
        // Imprimir información
        imprimirCampo(juego);
        System.out.println("Opciones:");
        for(int i = 0; i < pokemonActual.getHabilidades().size(); i++){
            System.out.println("\t" + (i+1) + ") " + pokemonActual.getHabilidades().get(i).getNombre());
        }

        // Obtener opción y accionar
        int opcionElegida = obtenerOpcionUsuario(pokemonActual.getHabilidades().size()+1);
        if(opcionElegida != pokemonActual.getHabilidades().size()+1){
            pokemonActual.getHabilidades().get(opcionElegida-1).accionarHabilidad(pokemonActual, juego.getTurnoActual() == 1 ? juego.getJugador2().getPokemonActual() : juego.getJugador1().getPokemonActual());
            return true;
        }else{
            return false;
        }
    }

    /**
     *
     * @return True si la acción se pudo completar, false en caso contrario
     */
     public boolean elegirItem(Juego juego) {
        boolean seguir = false;
        do{
            System.out.println("Que item queres usar: ");
            for(int i = 0; i < items.size(); i++){
                System.out.println("\t" + (i+1) + ") " + jugador.getItems().get(i).getNombre());
            }
            int opcionElegida = obtenerOpcionUsuario(items.size()+1);
            if(opcionElegida != jugador.getItems().size()+1){
                if(this.items.getItems(opcionElegida-1).getNombre() == "Pocion" || this.items.getItems(opcionElegida-1).getNombre(opcionElegida-1)== "Mega Pocion" || this.items.getItems(opcionElegida-1).getNombre(opcionElegida-1)== "Hiper Pocion" || this.items.getItems(opcionElegida-1).getNombre()== "Cura Todo"){
                System.out.println("En que pokemon queres utilizar este item: ");
                for(int i = 0; 0 <= pokemonsActivos.size(); i++){
                    System.out.println("\t" + (i+1) + ") " + pokemonsActivos.get(i));
                }
                int opcionElegida = obtenerOpcionUsuario(pokemonsActivos.size()+1);
                this.items.getItems(opcionElegida).usar(pokemonsActivos.get(opcionElegida-1));
                seguir = true;
                }
                if(this.items.getItems(opcionElegida-1).getNombre() == "Revivir" && !pokemonsMuertos.isEmpty()){
                    System.out.println("En que pokemon queres utilizar este item: ");
                    for(int i = 0; 0 <= pokemonsMuertos.size(); i++){
                        System.out.println("\t" + (i+1) + ") " + pokemonsMuertos.get(i));
                    }
                    int opcionElegida = obtenerOpcionUsuario(pokemonsMuertos.size()+1);
                    this.items.getItems(opcionElegida).usar(pokemonsMuertos.get(opcionElegida-1));
                    pokemonsActivos.add(pokemonsMuertos.get(opcionElegida-1));
                    pokemonsMuertos.remove(pokemonsMuertos.get(opcionElegida-1));
                    seguir = true;}
                if(this.items.getItems(opcionElegida-1).getNombre() == "Revivir" && pokemonsMuertos.isEmpty()){
                    System.out.println("No hay pokemons muertos");
                }}
            else{ return false;}
            }while(!seguir);
        return true;
        }        

    /**
     *
     * @return True si la acción se pudo completar, false en caso contrario
     */
    public boolean cambiarPokemonActual(Juego juego) {
        // Imprimir info
        limpiarConsola();
        //imprimirCampo(juego);
        System.out.println("Pokemones disponibles:");
        for(int i = 0; i < pokemonsActivos.size(); i++){
            System.out.println("\t" + (i+1) + ") " + pokemonsActivos.get(i));
        }

        // Obtener opcion elegida
        int opcionElegida = obtenerOpcionUsuario(pokemons.size()+1);

        // Verificar si la opción elegida fue volver
        if(opcionElegida == pokemonsActivos.size()+1){
            return false;
        }

        // Intercambiar
        Pokemon aux = pokemonActual;
        pokemonActual = pokemons.get(opcionElegida-1);
        pokemons.set(opcionElegida-1, aux);

        return true;
    }
}
