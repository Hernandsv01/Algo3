package org.fiuba.algotres.model.estado;

import lombok.Getter;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.Randomizador;
import org.fiuba.algotres.utils.RandomizadorCustom;

@Getter
public abstract class Estado {
    protected Pokemon pokemon;
    protected int turnosAplicados;
    private final String nombre;

    protected Randomizador randomizador = new RandomizadorCustom();

    public Estado(String nombre) {
        this.turnosAplicados = 0;
        this.nombre = nombre;
    }

    /**
     * @return true en caso de que el pokemon aún asi pueda realizar la operación, false en caso contrario.
     */
    public boolean accionar() {
        return this.pokemon.getEstados().isEmpty();
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
}
