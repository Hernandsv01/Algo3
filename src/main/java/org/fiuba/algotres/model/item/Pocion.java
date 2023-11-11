package org.fiuba.algotres.model.item;

import org.fiuba.algotres.model.Pokemon;

public class Pocion extends Item{
    private final int cantidadDeVida;

    public Pocion(int cantidad, String nombre, int cantidadDeVida) {
        super(cantidad, nombre);
        this.cantidadDeVida = cantidadDeVida;
    }

    public Pocion(String nombre, int cantidadDeVida, int id) {
        super(nombre, id);
        this.cantidadDeVida = cantidadDeVida;
    }

    @Override
    public boolean usar(Pokemon pokemon) {
        if (verificarCantidad(cantidad)) {
            pokemon.curarPorPuntos(cantidadDeVida);
            cantidad--;
            return true;
        }
        return false;
    }
}
