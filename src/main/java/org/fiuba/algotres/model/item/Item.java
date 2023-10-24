package org.fiuba.algotres.model.item;

import lombok.Getter;
import lombok.Setter;
import org.fiuba.algotres.model.Pokemon;

@Setter @Getter
public abstract class Item {
    protected int cantidad;
    private String nombre;

    public Item(int cantidad, String nombre) {
        this.cantidad = cantidad;
        this.nombre = nombre;
    }

    /**
     * @param pokemon al que se le quiere aplicar el item en cuestion.
     * @return false en caso de que no tenga items o no se haya aplicado porque no cumple con las condiciones;
     * caso contrario devolvera true.
     */
    public abstract boolean usar(Pokemon pokemon);

    boolean verificarCantidad(int cantidad) {
        return cantidad > 0;
    }
}
