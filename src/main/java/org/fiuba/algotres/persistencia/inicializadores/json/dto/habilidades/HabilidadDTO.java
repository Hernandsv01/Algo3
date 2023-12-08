package org.fiuba.algotres.persistencia.inicializadores.json.dto.habilidades;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.fiuba.algotres.model.habilidad.Habilidad;

import java.io.File;
import java.io.IOException;
import java.util.List;


@Getter @Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "habilidad")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AtaqueDTO.class, name = "ataque"),
        @JsonSubTypes.Type(value = CambiarClimaDTO.class, name = "cambiarclima"),
        @JsonSubTypes.Type(value = ModificacionEstadisticaDTO.class, name = "modificacionestadistica"),
        @JsonSubTypes.Type(value = ModificacionEstadoDTO.class, name = "modificacionestado")
})
public abstract class HabilidadDTO {

    private Integer id;
    private String nombre;
    private Integer usos;

    @JsonCreator
    public HabilidadDTO(@JsonProperty ("id") Integer id, @JsonProperty("nombre") String nombre, @JsonProperty("usos")Integer usos) {
        this.id = id;
        this.nombre = nombre;
        this.usos = usos;
    }

    public static List<HabilidadDTO> loadHabilidadesJson(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(path);
        return mapper.readValue(file, new TypeReference<>() {});
    }

    public abstract Habilidad toHabilidad();
}
