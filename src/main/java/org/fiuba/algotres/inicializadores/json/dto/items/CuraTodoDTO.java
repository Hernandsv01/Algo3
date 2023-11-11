package org.fiuba.algotres.inicializadores.json.dto.items;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("curatodo")
public class CuraTodoDTO extends ItemDTO{

    public CuraTodoDTO(Integer id, String nombre, Integer cantidad) {
        super(id, nombre, cantidad);
    }
}
