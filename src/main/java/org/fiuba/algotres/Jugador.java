package org.fiuba.algotres;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.fiuba.algotres.habilidad.Habilidad;
import org.fiuba.algotres.item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class Jugador {
    private List<Pokemon> pokemonsActivos;
    private List<Pokemon> pokemonsMuertos;
    private List<Item> items;
    private Pokemon pokemonActual;
    private String nombre;

    public Jugador(List<Pokemon> pokemonsActivos, List<Item> items) {
        this.pokemonsActivos = pokemonsActivos;
        this.pokemonsMuertos = new ArrayList<>();
        this.items = items;
    }

    private <T> int elegirElemento(List<T> elementos, String mensaje) {
        if (elementos.isEmpty()) return -1;

        List<String> opciones = elementos.stream()
                .map(Object::toString)
                .collect(Collectors.toList());
        opciones.add("Volver");

        int opcionElegida = 1 /*Acá iría función de inputUsuario*/;
        if (opcionElegida == elementos.size() + 1) return 0;

        return opcionElegida;
    }

    /**
     * Le permite al usuario elegir una habilidad de su pokemon
     * @return la posicion de la habilidad elegida + 1, 0 si se volvió y -1 si no hay habilidades disponibles
     */
    public int elegirHabilidad() {
        return elegirElemento(pokemonActual.getHabilidades(), "Habilidades disponibles: ");
    }

    /**
     * Le permite al usuario elegir un item entre los que tiene
     * @return la posición del item elegido + 1, 0 si se volvió y -1 si no hay items disponibles
     */
    public int elegirItem() {
        return elegirElemento(items, "Items:");
    }

    /**
     * Le permite al usuario elegir el pokemon sobre el que quiere aplicar su item y lo aplica
     * @param item Posición del item que se va a usar
     * @return 1 si el item se usó correctamente, 0 si se volvió, -1 si hubo algún error
     */
    public int usarItem(int item) {
        Item itemElegido = items.get(item);
        boolean esRevivir = "Revivir".equals(itemElegido.getClass().getName());
        List<Pokemon> lista = esRevivir ? pokemonsMuertos : pokemonsActivos;

        int opcionElegida = elegirElemento(lista, "Elija un pokemon al que aplicarle el item: ");
        if(opcionElegida <= 0) return opcionElegida;

        boolean res = itemElegido.usar(lista.get(opcionElegida - 1));

        if(res && esRevivir){
            Pokemon pokemon = lista.get(opcionElegida - 1);
            pokemonsMuertos.remove(pokemon);
            pokemonsActivos.add(pokemon);
        }

        return res? 1 : -1;
    }

    /**
     * Le permite al usuario elegir el pokemon que quiere tener como actual y lo reemplaza
     * @return 1 si se cambió de pokemón, 0 si se volvió y -1 si no hay pokemons disponibles
     */
    public int cambiarPokemonActual() {
        int opcionElegida = elegirElemento(pokemonsActivos, "Pokemones disponibles:");

        if(opcionElegida == 0 || opcionElegida == -1) return opcionElegida;

        Pokemon aux = pokemonActual;
        pokemonActual = pokemonsActivos.get(opcionElegida - 1);
        pokemonsActivos.set(opcionElegida - 1, aux);

        return 1;
    }
}
