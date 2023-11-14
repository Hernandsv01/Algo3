package org.fiuba.algotres.model.item;

import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.strategies.Strategy;

public class Estadistica extends Item {
    private final Strategy strategy;
    protected int porcentaje;

    public Estadistica(int cantidad, String nombre, int porcentaje, Strategy strategy) {
        super(cantidad, nombre);
        this.porcentaje = porcentaje;
        this.strategy = strategy;
    }

    public Estadistica(String nombre, int porcentaje, Strategy strategy, int id) {
        super(nombre, id);
        this.strategy = strategy;
        this.porcentaje = porcentaje;
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
}