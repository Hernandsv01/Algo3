package org.fiuba.algotres.inicializadores.json.dto.habilidades;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;
import org.fiuba.algotres.inicializadores.json.dto.Utils;
import org.fiuba.algotres.model.habilidad.Ataque;
import org.fiuba.algotres.model.habilidad.Habilidad;
import org.fiuba.algotres.model.tipos.Tipos;

@Getter @Setter
@JsonTypeName("ataque")
public class AtaqueDTO extends HabilidadDTO {
    private int poder;
    private String tipo;


    @JsonCreator
    public AtaqueDTO(@JsonProperty("id") int id, @JsonProperty("nombre") String nombre, @JsonProperty("usos") int usos, @JsonProperty("poder") int poder, @JsonProperty("tipo") String tipo) {
        super(id, nombre, usos);
        this.poder = poder;
        this.tipo = tipo;
    }

    @Override
    public Habilidad toHabilidad() {
        return new Ataque(getId(), this.getNombre(), this.getUsos(), poder, Utils.getTipo(tipo));
    }
}
