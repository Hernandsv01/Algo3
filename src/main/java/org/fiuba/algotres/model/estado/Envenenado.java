package org.fiuba.algotres.model.estado;

import org.fiuba.algotres.model.Pokemon;

public class Envenenado extends Estado{
    private final int DANO = 5;
    public Envenenado(String nombre) {
        super(nombre);
    }

    @Override
    public boolean accionar(Pokemon pokemon) {
        pokemon.danarPorPorcentaje(DANO);
        return true;
    }
}
