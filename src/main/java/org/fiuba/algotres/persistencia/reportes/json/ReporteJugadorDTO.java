package org.fiuba.algotres.persistencia.reportes.json;

import java.util.List;
import java.util.Map;

public class ReporteJugadorDTO {
    private String nombre;
    private boolean ganador;
    private Map<String, Integer> items;
    private List<ReportePokemonDTO> pokemons;

    public ReporteJugadorDTO(String nombre, boolean ganador, Map<String, Integer> items, List<ReportePokemonDTO> pokemons) {
        this.nombre = nombre;
        this.ganador = ganador;
        this.items = items;
        this.pokemons = pokemons;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isGanador() {
        return ganador;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public List<ReportePokemonDTO> getPokemons() {
        return pokemons;
    }
}
