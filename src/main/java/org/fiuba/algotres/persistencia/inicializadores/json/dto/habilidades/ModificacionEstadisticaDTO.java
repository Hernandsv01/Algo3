package org.fiuba.algotres.persistencia.inicializadores.json.dto.habilidades;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.fiuba.algotres.persistencia.inicializadores.json.dto.Utils;
import org.fiuba.algotres.model.habilidad.Habilidad;
import org.fiuba.algotres.model.habilidad.ModificacionEstadistica;

@JsonTypeName("modificacionestadistica")
public class ModificacionEstadisticaDTO extends HabilidadDTO {
    private final String estadistica;
    private final boolean esPositivo;
    protected final int porcentaje;

    @JsonCreator
    public ModificacionEstadisticaDTO(@JsonProperty("id") int id, @JsonProperty("nombre") String nombre, @JsonProperty("usos") int usos, @JsonProperty("porcentaje") int porcentaje, @JsonProperty("estadistica") String estadistica, @JsonProperty("esPositivo") boolean esPositivo) {
        super(id, nombre, usos);
        this.porcentaje = porcentaje;
        this.estadistica = estadistica;
        this.esPositivo = esPositivo;
    }

    @Override
    public Habilidad toHabilidad() {
        return new ModificacionEstadistica(getId(), getNombre(), getUsos(), porcentaje, Utils.getStrategy(estadistica, esPositivo));
    }
}
