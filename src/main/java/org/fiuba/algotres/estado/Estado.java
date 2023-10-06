package org.fiuba.algotres.estado;

import lombok.Getter;
import org.fiuba.algotres.Pokemon;

@Getter
public abstract class Estado {
    protected int turnosAplicados;
    private final String nombre;

    public Estado(String nombre) {
        this.turnosAplicados = 0;
        this.nombre = nombre;
    }

    /**
     * @param pokemon que puede o no tener un estado aplicado.
     * @return true en caso de que el pokemon aún asi pueda realizar la operación, false en caso contrario.
     */
    public boolean accionar(Pokemon pokemon) {
        return pokemon.getEstado() == null;
    }

    @Override
    public String toString() {
        return getNombre();
    }
}
