package org.fiuba.algotres.model.item;

import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.strategies.Strategy;

public class Estadistica extends ItemAbstracto {
    private final Strategy strategy;
    protected int porcentaje;

    public Estadistica(int cantidad, String nombre, int porcentaje, Strategy strategy) {
        super(cantidad, nombre);
        this.porcentaje = porcentaje;
        this.strategy = strategy;
    }

    @Override
    public boolean usar(Pokemon pokemon) {
        if (verificarCantidad(cantidad)) {
            this.strategy.modificar(pokemon, porcentaje);
            cantidad--;
            return true;
        }
        return false;
    }

    @Override
    public int getEficiencia() {
        return porcentaje;
    }
}