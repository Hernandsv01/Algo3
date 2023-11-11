package org.fiuba.algotres.inicializadores.json.dto.items;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("pocion")
public class PocionDTO extends ItemDTO {
    private final int cantidadDeVida;
    public PocionDTO(Integer id, String nombre, Integer cantidad, int cantidadDeVida) {
        super(id, nombre, cantidad);
        this.cantidadDeVida = cantidadDeVida;
    }
}
