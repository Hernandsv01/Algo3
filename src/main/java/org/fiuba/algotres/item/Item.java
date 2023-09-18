package org.fiuba.algotres.item;

import org.fiuba.algotres.Pokemon;

public abstract class Item {
    protected Integer cantidad;

    public Pokemon Usar(Pokemon pokemon) { return pokemon; }
}
