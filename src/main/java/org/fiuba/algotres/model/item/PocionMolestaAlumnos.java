package org.fiuba.algotres.model.item;

import org.fiuba.algotres.model.Pokemon;

public class PocionMolestaAlumnos extends Item {
    private final int porcentajeDeVida;

    public PocionMolestaAlumnos(int cantidad, String nombre, int porcentajeDeVida) {
        super(cantidad, nombre);
        this.porcentajeDeVida = porcentajeDeVida;
    }

    public PocionMolestaAlumnos(String nombre, int porcentajeDeVida, int id) {
        super(nombre, id);
        this.porcentajeDeVida = porcentajeDeVida;
    }

    public PocionMolestaAlumnos(String nombre, int porcentajeDeVida) {
        super(nombre);
        this.porcentajeDeVida = porcentajeDeVida;
    }

    @Override
    public boolean usar(Pokemon pokemon) {
        if (verificarCantidad(cantidad)) {
            pokemon.curarPorPorcentaje(porcentajeDeVida);
            cantidad--;
            return true;
        }
        return false;
    }
}
