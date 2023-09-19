package org.fiuba.algotres.item;

import org.fiuba.algotres.Pokemon;

public class Ataque extends Estadistica{
    // solo puede ser usado en el pokemon que se encuentre en el campo de batalla

    public Ataque(int cantidad, int porcentaje) {
        this.cantidad = cantidad;
        this.porcentaje = porcentaje;
    }

    @Override
    public void usar(Pokemon pokemon) {
        int ataqueAnterior = pokemon.getAtaque();
        pokemon.setAtaque((porcentaje/100) * ataqueAnterior + ataqueAnterior);
        cantidad--;
    }
}
