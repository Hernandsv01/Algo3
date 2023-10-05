package org.fiuba.algotres.estado;

import org.fiuba.algotres.Pokemon;

public class Envenenado extends Estado{
    public Envenenado(String nombre) {
        super(nombre);
    }

    @Override
    public boolean accionar(Pokemon pokemon) {
        pokemon.danarPorPorcentaje(5);
        return false;
    }
}
