package org.fiuba.algotres.persistencia.reportes.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.estado.Estado;
import org.fiuba.algotres.model.item.Item;
import org.fiuba.algotres.persistencia.reportes.GeneradorReporte;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GeneradorReporteJSON implements GeneradorReporte {

    public void GenerarReporte(CampoDeBatalla cdb){
        List<ReporteJugadorDTO> reporte = objectToDTO(cdb);

        ObjectMapper mapper = new ObjectMapper();
        File outputFile = new File("src/main/resources/json/reportes/informe_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH-mm-ss")) + ".json");
        System.out.println("Intentando guardar reporte en: " + outputFile.getPath());
        try {
            mapper.writeValue(outputFile, reporte);
            System.out.println("Reporte de partida guardado de forma exitosa");
        } catch (IOException e) {
            System.out.println("Error guardando reporte de partida: " + e.getMessage());
        }
    }

    private static List<ReporteJugadorDTO> objectToDTO(CampoDeBatalla cdb){
        List<ReporteJugadorDTO> reporte = new ArrayList<>();
        for(int i = 0; i < cdb.getJugadores().length; i++) {
            reporte.add(
                    new ReporteJugadorDTO(
                            cdb.getJugadores()[i].getNombre(),
                            cdb.getGanador() == i,
                            cdb.getJugadores()[i].getItems().stream().collect(Collectors.toMap(item -> ""+item.getId(), Item::getCantidad)),
                            cdb.getJugadores()[i].getPokemons().stream().map(pokemon ->
                                    new ReportePokemonDTO(pokemon.getId(), pokemon.getVidaMaxima()-pokemon.getVidaActual(), pokemon.getEstados().stream().map(Estado::getNombre).toList())
                            ).toList()
                    )
            );
        }
        return reporte;
    }
}
