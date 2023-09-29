package org.fiuba.algotres.estado;

import lombok.Getter;
import org.fiuba.algotres.Accionable;
import org.fiuba.algotres.Pokemon;

@Getter
public abstract class Estado implements Accionable {
    protected int turnosAplicados;
    private final String nombre;

    public Estado(String nombre) {
        this.turnosAplicados = 0;
        this.nombre = nombre;
    }

    /**
     * @param pokemon que puede o no tener un estado aplicado.
     * @param ignorado debe ser null.
     * @return false en caso de que el estado persista en el pokemon;
     * true en caso de que el pokemon no tenga un estado o se termino el efecto del mismo.
     */
    public boolean accionar(Pokemon pokemon, Pokemon ignorado) {
        return pokemon.getEstado() == null;
    }

    @Override
    public String toString() {
        return getNombre();
    }
}
