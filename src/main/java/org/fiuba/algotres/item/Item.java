package org.fiuba.algotres.item;

import lombok.Getter;
import lombok.Setter;
import org.fiuba.algotres.Accionable;
import org.fiuba.algotres.Pokemon;

@Setter @Getter
public abstract class Item implements Accionable {
    protected int cantidad;
    private String nombre;

    public Item(int cantidad, String nombre) {
        this.cantidad = cantidad;
        this.nombre = nombre;
    }

    /**
     * @param pokemon al que se le quiere aplicar el item en cuestion.
     * @param ignorado debe ser null.
     * @return false en caso de que no tenga items o no se haya aplicado porque no cumple con las condiciones;
     * caso contrario devolvera true.
     */
    public boolean accionar(Pokemon pokemon, Pokemon ignorado) {
        return cantidad > 0;
    }

    @Override
    public String toString() {
        return getNombre() + "(" + getCantidad() + "cantidad)";
    }
}
