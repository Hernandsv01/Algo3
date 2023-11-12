package org.fiuba.algotres.persistencia.inicializadores.json.dto.items;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.fiuba.algotres.model.item.Item;
import org.fiuba.algotres.model.item.PocionMolestaAlumnos;

@JsonTypeName("pocionmolestaalumnos")
public class PocionMolestaAlumnosDTO extends ItemDTO {
    private final int porcentajeDeVida;

    @JsonCreator
    public PocionMolestaAlumnosDTO(@JsonProperty("id") Integer id, @JsonProperty("nombre") String nombre, @JsonProperty("porcentajeDeVida") int porcentajeDeVida) {
        super(id, nombre);
        this.porcentajeDeVida = porcentajeDeVida;
    }

    @Override
    public Item toItem() {
        return new PocionMolestaAlumnos(getNombre(), porcentajeDeVida, getId());
    }
}
