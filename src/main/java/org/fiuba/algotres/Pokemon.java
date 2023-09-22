package org.fiuba.algotres;

import lombok.NoArgsConstructor;
import org.fiuba.algotres.estado.Estado;
import org.fiuba.algotres.habilidad.Habilidad;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Pokemon {
    private final String nombre;
    private final Integer nivel;
    private final Tipos tipos;
    private final String historia;
    private Integer vidaActual;
    private final Integer vidaMaxima;
    private final Integer velocidad;
    private Integer defensa;
    private Integer ataque;
    private Estado estado;
    private final List<Habilidad> habilidades;

    public Pokemon(
            String nombre,
            Integer nivel,
            Tipos tipos,
            String historia,
            Integer vidaActual,
            Integer vidaMaxima,
            Integer velocidad,
            Integer defensa,
            Integer ataque,
            List<Habilidad> habilidades
    ) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.tipos = tipos;
        this.historia = historia;
        this.vidaActual = vidaActual;
        this.vidaMaxima = vidaMaxima;
        this.velocidad = velocidad;
        this.defensa = defensa;
        this.ataque = ataque;
        this.estado = null;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return nombre + " (" + vidaActual + "❤\uFE0F/" + vidaMaxima + "❤\uFE0F)";
    }
    public String getHealthString() {
        return "(" + vidaActual + "❤\uFE0F/" + vidaMaxima + "❤\uFE0F)";
    }
}
