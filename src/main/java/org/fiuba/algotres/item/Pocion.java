package org.fiuba.algotres.item;

import org.fiuba.algotres.Pokemon;

public class Pocion extends Vida{
    //Pocion (cura 20), Mega Pocion (cura 50) e Hiper Pocion (cura 100)
    public Pocion(Integer cantidad, Integer cantidadDeVida) {
        this.cantidad = cantidad;
        this.cantidadDeVida = cantidadDeVida;
    }
    @Override
    public Pokemon Usar(Pokemon pokemon) {
        if ((pokemon.getVidaActual() + cantidadDeVida) > pokemon.getVidaMaxima()) {
            pokemon.setVidaActual(pokemon.getVidaMaxima());
        } else {
            Integer vidaAnterior = pokemon.getVidaActual();
            pokemon.setVidaActual(vidaAnterior + cantidadDeVida);
        }
        cantidad--;
        return pokemon;
    }
}
