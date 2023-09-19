package org.fiuba.algotres.item;

import org.fiuba.algotres.Pokemon;

public class Defensa extends Estadistica{
    // solo puede ser usado en el pokemon que se encuentre en el campo de batalla
    public Defensa(int cantidad, int porcentaje) {
        this.cantidad = cantidad;
        this.porcentaje = porcentaje;
    }
    @Override
    public Pokemon Usar(Pokemon pokemon) {
        int defensaAnterior = pokemon.getDefensa();
        pokemon.setAtaque((porcentaje/100) * defensaAnterior + defensaAnterior);
        cantidad--;
        return pokemon;
    }
}
