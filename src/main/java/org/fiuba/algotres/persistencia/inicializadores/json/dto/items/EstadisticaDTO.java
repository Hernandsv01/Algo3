package org.fiuba.algotres.persistencia.inicializadores.json.dto.items;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.fiuba.algotres.persistencia.inicializadores.json.dto.Utils;
import org.fiuba.algotres.model.item.Estadistica;
import org.fiuba.algotres.model.item.Item;

@JsonTypeName("estadistica")
public class EstadisticaDTO extends ItemDTO {
    private final String estadistica;
    private final boolean esPositivo;
    protected int porcentaje;

    @JsonCreator
    public EstadisticaDTO(@JsonProperty("id") Integer id, @JsonProperty("nombre") String nombre, @JsonProperty("estadistica") String estadistica, @JsonProperty("esPositivo") boolean esPositivo) {
        super(id, nombre);
        this.estadistica = estadistica;
        this.esPositivo = esPositivo;
    }

    @Override
    public Item toItem() {
        return new Estadistica(getNombre(), porcentaje, Utils.getStrategy(estadistica, esPositivo), getId());
    }
}
