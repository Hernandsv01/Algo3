package org.fiuba.algotres.item;

import org.fiuba.algotres.Pokemon;

public class Defensa extends Estadistica{
    // solo puede ser usado en el pokemon que se encuentre en el campo de batalla

    public Defensa(int cantidad, String nombre, int porcentaje) {
        super(cantidad, nombre, porcentaje);
    }

    @Override
    public boolean usar(Pokemon pokemon) {
        if (cantidad <= 0) {
            return false;
        }
        int defensaAnterior = pokemon.getDefensa();
        pokemon.setAtaque((porcentaje/100) * defensaAnterior + defensaAnterior);
        cantidad--;
        return true;
    }
}
