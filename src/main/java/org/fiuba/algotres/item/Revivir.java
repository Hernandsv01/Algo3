package org.fiuba.algotres.item;

import org.fiuba.algotres.Jugador;
import org.fiuba.algotres.Pokemon;

import java.util.List;

public class Revivir extends Item {
    // solo puede ser usado en el pokemon que se encuentre muerto
    private final Jugador jugador;

    public Revivir(int cantidad, String nombre, Jugador jugador) {
        super(cantidad, nombre);
        this.jugador = jugador;
    }

    @Override
    public boolean usar(Pokemon pokemon) {
        if (cantidad <= 0) {
            return false;
        }
        if (pokemon.getVidaActual() == 0) {
            pokemon.setVidaActual(pokemon.getVidaMaxima());

            jugador.getPokemonsMuertos().remove(pokemon);
            jugador.getPokemonsActivos().add(pokemon);

            cantidad--;
            return true;
        }
        return false;
    }
}
