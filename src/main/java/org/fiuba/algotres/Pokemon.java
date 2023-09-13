package org.fiuba.algotres;

import org.fiuba.algotres.estado.Estado;
import org.fiuba.algotres.habilidad.Habilidad;

import java.util.List;

public class Pokemon {
    private final String nombre;
    private final Integer nivel;
    private final Tipos tipos;
    private final String historia;
    private final Integer vidaMaxima;
    private final Integer velocidad;
    private final Integer defensa;
    private final Integer ataque;
    private Estado estado;
    private final List<Habilidad> habilidades;

    public Pokemon(
            String nombre,
            Integer nivel,
            Tipos tipos,
            String historia,
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
        this.vidaMaxima = vidaMaxima;
        this.velocidad = velocidad;
        this.defensa = defensa;
        this.ataque = ataque;
        this.estado = null;
        this.habilidades = habilidades;
    }
}
