package org.fiuba.algotres.item;

import org.fiuba.algotres.Accionable;
import org.fiuba.algotres.Pokemon;

public abstract class Estadistica extends Item {
    protected int porcentaje;

    public Estadistica(int cantidad, String nombre, int porcentaje) {
        super(cantidad, nombre);
        this.porcentaje = porcentaje;
    }

    public boolean accionar(Pokemon pokemon, Pokemon ignorado) {
        return super.accionar(pokemon, ignorado);
    }
//        if (super.usar(pokemon)) {
//            switch (tipo) {
//                case ATAQUE:
//                    int ataqueAnterior = pokemon.getAtaque();
//                    pokemon.setAtaque((porcentaje / 100) * ataqueAnterior + ataqueAnterior);
//                    cantidad--;
//                    return true;
//                case DEFENSA:
//                    int defensaAnterior = pokemon.getDefensa();
//                    pokemon.setDefensa((porcentaje / 100) * defensaAnterior + defensaAnterior);
//                    cantidad--;
//                    return true;
//            }
//        }
//        return false;
//    }
}