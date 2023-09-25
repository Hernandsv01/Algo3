package org.fiuba.algotres.item;

import org.fiuba.algotres.Pokemon;

public class Pocion extends Item{
    //Pocion (cura 20), Mega Pocion (cura 50) e Hiper Pocion (cura 100)
    protected int cantidadDeVida;

    public Pocion(int cantidad, String nombre, int cantidadDeVida) {
        super(cantidad, nombre);
        this.cantidadDeVida = cantidadDeVida;
    }

    @Override
    public boolean usar(Pokemon pokemon) {
        if (cantidad <= 0) {
            return false;
        }
        if ((pokemon.getVidaActual() + cantidadDeVida) > pokemon.getVidaMaxima()) {
            pokemon.setVidaActual(pokemon.getVidaMaxima());
        } else {
            int vidaAnterior = pokemon.getVidaActual();
            pokemon.setVidaActual(vidaAnterior + cantidadDeVida);
        }
        cantidad--;
        return true;
    }
}
