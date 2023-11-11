package org.fiuba.algotres.model.habilidad;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.fiuba.algotres.inicializadores.json.dto.habilidades.CambiarClimaDTO;
import org.fiuba.algotres.model.Pokemon;

@Setter @Getter
public abstract class Habilidad {
    private int id;
    private final String nombre;
    protected int usos;

    public Habilidad(int id, String nombre, int usos) {
        this.id = id;
        this.nombre = nombre;
        this.usos = usos;
    }

    public Habilidad(String nombre, int usos) {
        this.nombre = nombre;
        this.usos = usos;
    }

    public abstract boolean accionarHabilidad(Pokemon atacante, Pokemon victima);

    boolean verificarUsos(int usos) {
        return usos > 0;
    }
}
