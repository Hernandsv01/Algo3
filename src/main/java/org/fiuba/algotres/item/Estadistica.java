package org.fiuba.algotres.item;

import org.fiuba.algotres.Pokemon;

public class Estadistica extends Item{
    public static final String ATAQUE = "ataque";
    public static final String DEFENSA = "defensa";
    protected int porcentaje;
    private final String tipo;
    // si es 10%, tenemos que poner 10

    public Estadistica(int cantidad, String nombre, int porcentaje, String tipo) {
        super(cantidad, nombre);
        this.porcentaje = porcentaje;
        this.tipo = tipo;
    }
    public boolean usar(Pokemon pokemon) {
        if (cantidad <= 0) {
            return false;
        }
        switch (tipo) {
            case ATAQUE:
                int ataqueAnterior = pokemon.getAtaque();
                pokemon.setAtaque((porcentaje/100) * ataqueAnterior + ataqueAnterior);
                cantidad--;
                return true;
            case DEFENSA:
                int defensaAnterior = pokemon.getDefensa();
                pokemon.setDefensa((porcentaje/100) * defensaAnterior + defensaAnterior);
                cantidad--;
                return true;
        }
        return true; // No deberia llegar nunca.
    }
}
