package org.fiuba.algotres.inicializadores.json.dto.items;

import com.fasterxml.jackson.annotation.JsonTypeName;
import org.fiuba.algotres.model.strategies.Strategy;

@JsonTypeName("estadistica")
public class EstadisticaDTO extends ItemDTO {
    private final String estadistica;
    private final boolean esPositivo;
    protected int porcentaje;

    public EstadisticaDTO(Integer id, String nombre, Integer cantidad, String estadistica, boolean esPositivo) {
        super(id, nombre, cantidad);
        this.estadistica = estadistica;
        this.esPositivo = esPositivo;
    }
}
