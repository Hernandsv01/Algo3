package org.fiuba.algotres.item;

import org.fiuba.algotres.Pokemon;

public class Pocion extends Vida{
    //Pocion (cura 20), Mega Pocion (cura 50) e Hiper Pocion (cura 100)
    public Pocion(int cantidad, int cantidadDeVida) {
        this.cantidad = cantidad;
        this.cantidadDeVida = cantidadDeVida;
    }
    @Override
    public void usar(Pokemon pokemon) {
        if ((pokemon.getVidaActual() + cantidadDeVida) > pokemon.getVidaMaxima()) {
            pokemon.setVidaActual(pokemon.getVidaMaxima());
        } else {
            int vidaAnterior = pokemon.getVidaActual();
            pokemon.setVidaActual(vidaAnterior + cantidadDeVida);
        }
        cantidad--;
    }
}
