package org.fiuba.algotres.model.habilidad;

import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.strategies.Strategy;

public class ModificacionEstadistica extends Habilidad {
    private final Strategy strategy;
    protected final int porcentaje;
    public ModificacionEstadistica(String nombre, int usos, int porcentaje, Strategy strategy) {
        super(nombre, usos);
        this.porcentaje = porcentaje;
        this.strategy = strategy;
    }

    public ModificacionEstadistica(int id, String nombre, int usos, int porcentaje, Strategy strategy) {
        super(id, nombre, usos);
        this.strategy = strategy;
        this.porcentaje = porcentaje;
    }

    /**
     * @param atacante pokemon propio.
     * @param victima pokemon contrario.
     */
    @Override
    public boolean accionarHabilidad(Pokemon atacante, Pokemon victima) {
        if (verificarUsos(usos)) {
            if (strategy.esPositivo()) {
                this.strategy.modificar(atacante, porcentaje);
            } else {
                this.strategy.modificar(victima, porcentaje);
            }
            usos--;
            return true;
        }
        return false;
    }

    public Strategy getStrategy(){
        return this.strategy;
    }
    public int getPorcentaje(){
        return this.porcentaje;
    }
}
