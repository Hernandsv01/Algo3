package org.fiuba.algotres.item;

import org.fiuba.algotres.Pokemon;

public class Ataque extends Estadistica{
    // solo puede ser usado en el pokemon que se encuentre en el campo de batalla

    public Ataque(int cantidad, String nombre, int porcentaje) {
        super(cantidad, nombre, porcentaje);
    }

    @Override
    public boolean usar(Pokemon pokemon) {
        if (cantidad <= 0) {
            return false;
        }
        int ataqueAnterior = pokemon.getAtaque();
        pokemon.setAtaque((porcentaje/100) * ataqueAnterior + ataqueAnterior);
        cantidad--;
        return true;
    }
}
