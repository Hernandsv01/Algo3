package org.fiuba.algotres.persistencia.inicializadores.json.dto.habilidades;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.fiuba.algotres.model.habilidad.CambiarClima;
import org.fiuba.algotres.model.habilidad.Habilidad;
import org.fiuba.algotres.persistencia.inicializadores.json.dto.Utils;

@JsonTypeName("cambiarclima")
public class CambiarClimaDTO extends HabilidadDTO {
    private String clima;

    @JsonCreator
    public CambiarClimaDTO(@JsonProperty("id") int id, @JsonProperty("nombre") String nombre, @JsonProperty("usos") int usos, @JsonProperty("clima") String clima) {
        super(id, nombre, usos);
        this.clima = clima;
    }

    @Override
    public Habilidad toHabilidad() {
        return new CambiarClima(getId(), getNombre(), getUsos(), Utils.getClima(clima));
    }
}
