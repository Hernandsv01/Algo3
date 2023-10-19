package org.fiuba.algotres.model.item;

import org.fiuba.algotres.model.Pokemon;

public class Pocion extends Item{
    protected int cantidadDeVida;

    public Pocion(int cantidad, String nombre, int cantidadDeVida) {
        super(cantidad, nombre);
        this.cantidadDeVida = cantidadDeVida;
    }

    @Override
    public boolean usar(Pokemon pokemon) {
        if (super.usar(pokemon)) {
            pokemon.curarPorPuntos(cantidadDeVida);
            cantidad--;
            return true;
        }
        return false;
    }
}
