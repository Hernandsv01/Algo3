package org.fiuba.algotres.estado;

import org.fiuba.algotres.Pokemon;

public class Envenenado extends Estado{
    public Envenenado(String nombre) {
        super(nombre);
    }

    @Override
    public boolean accionar(Pokemon pokemon, Pokemon ignorado) {
        pokemon.setVidaActual((int) (pokemon.getVidaActual() - pokemon.getVidaMaxima() * 0.05));
        return false;
    }
}
