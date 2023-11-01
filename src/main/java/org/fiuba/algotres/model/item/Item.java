package org.fiuba.algotres.model.item;

import org.fiuba.algotres.model.Pokemon;

public interface Item {
    /**
     * @param pokemon al que se le quiere aplicar el item en cuestion.
     * @return false en caso de que no tenga items o no se haya aplicado porque no cumple con las condiciones;
     * caso contrario devolvera true.
     */
    boolean usar(Pokemon pokemon);
    String getNombre();
    int getCantidad();
    int getEficiencia();
}
