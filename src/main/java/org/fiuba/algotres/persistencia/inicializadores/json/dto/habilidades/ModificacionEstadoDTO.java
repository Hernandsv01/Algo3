package org.fiuba.algotres.persistencia.inicializadores.json.dto.habilidades;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.fiuba.algotres.persistencia.inicializadores.json.dto.Utils;
import org.fiuba.algotres.model.habilidad.Habilidad;
import org.fiuba.algotres.model.habilidad.ModificacionEstado;

@JsonTypeName("modificacionestado")
public class ModificacionEstadoDTO extends HabilidadDTO{
    private final String estado;

    @JsonCreator
    public ModificacionEstadoDTO(@JsonProperty("id") int id, @JsonProperty ("nombre") String nombre, @JsonProperty ("usos") int usos, @JsonProperty ("estado") String estado) {
        super(id, nombre, usos);
        this.estado = estado;
    }

    @Override
    public Habilidad toHabilidad() {
        return new ModificacionEstado(getId(), getNombre(), getUsos(), Utils.getEstado(estado));
    }
}
