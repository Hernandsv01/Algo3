package org.fiuba.algotres.inicializadores.json.dto.items;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("pocionmolestaalumnos")
public class PocionMolestaAlumnosDTO extends ItemDTO {
    private final int porcentajeDeVida;
    public PocionMolestaAlumnosDTO(Integer id, String nombre, Integer cantidad, int porcentajeDeVida) {
        super(id, nombre, cantidad);
        this.porcentajeDeVida = porcentajeDeVida;
    }
}
