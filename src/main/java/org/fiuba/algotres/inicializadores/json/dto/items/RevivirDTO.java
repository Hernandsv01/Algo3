package org.fiuba.algotres.inicializadores.json.dto.items;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("revivir")
public class RevivirDTO extends ItemDTO {
    public RevivirDTO(Integer id, String nombre, Integer cantidad) {
        super(id, nombre, cantidad);
    }
}
