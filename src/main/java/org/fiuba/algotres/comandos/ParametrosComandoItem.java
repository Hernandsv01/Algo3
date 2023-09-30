package org.fiuba.algotres.comandos;

import org.fiuba.algotres.Pokemon;
import org.fiuba.algotres.item.Item;

public class ParametrosComandoItem implements ParametrosComando {
    private Item item;
    private Pokemon pokemon;

    public Item getItem() {
        return item;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }
}
