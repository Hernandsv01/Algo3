package org.fiuba.algotres.persistencia.reportes.json;

import java.util.List;

public class ReportePokemonDTO {
    private int id;
    private int vidaRestante;
    private List<String> estados;

    public ReportePokemonDTO(int id, int vidaRestante, List<String> estados) {
        this.id = id;
        this.vidaRestante = vidaRestante;
        this.estados = estados;
    }

    public int getId() {
        return id;
    }

    public int getVidaRestante() {
        return vidaRestante;
    }

    public List<String> getEstados() {
        return estados;
    }
}
