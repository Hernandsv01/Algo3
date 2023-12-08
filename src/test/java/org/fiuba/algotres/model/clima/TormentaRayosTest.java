package org.fiuba.algotres.model.clima;

import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.habilidad.Ataque;
import org.fiuba.algotres.model.habilidad.Habilidad;
import org.fiuba.algotres.model.tipos.Tipos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class TormentaRayosTest {

    private CampoDeBatalla cdb;
    private TormentaRayos tormentaRayos;
    private Pokemon pokemon;
    private Ataque primeraHabilidad;
    private Ataque segundaHabilidad;
    private boolean esValido;
    private int turnoFinal;

    @BeforeEach
    public void setup(){
        cdb = mock(CampoDeBatalla.class);
        tormentaRayos = new TormentaRayos("Tormenta de rayos", cdb);
        pokemon = mock(Pokemon.class);
        primeraHabilidad = mock(Ataque.class);
        segundaHabilidad = mock(Ataque.class);
        esValido = true;
        turnoFinal = 0;

        when(cdb.getClima()).thenReturn(tormentaRayos);
        when(pokemon.getTipos()).thenReturn(Tipos.VOLADOR);
        when(primeraHabilidad.getTipo()).thenReturn(Tipos.FUEGO);
        when(segundaHabilidad.getTipo()).thenReturn(Tipos.VOLADOR);
        when(pokemon.getHabilidades()).thenReturn(new ArrayList<Habilidad>(Arrays.asList(
                primeraHabilidad,
                segundaHabilidad
        )));
    }

    @Test
    void TestTurnoValido(){
        int turnosValidos = 5;

        for(int i = 0; i < turnosValidos; i++) {
            assertEquals(i, tormentaRayos.getTurnosAplicados());
            assertEquals(esValido, tormentaRayos.turnoValido());
        }
        verify(tormentaRayos.getCdb(), times(0)).setClima(new SinClima("Sin clima", cdb));
        assertEquals(!esValido, tormentaRayos.turnoValido());
        assertEquals(turnoFinal, tormentaRayos.getTurnosAplicados());
    }

    @Test
    void TestPotenciarPokemon(){
        tormentaRayos.potenciarPokemon(pokemon);
        verify(primeraHabilidad, times(0)).setPoder(anyInt());
        verify(segundaHabilidad, times(0)).setPoder(anyInt());

        when(pokemon.getTipos()).thenReturn(Tipos.ELECTRICO);

        tormentaRayos.potenciarPokemon(pokemon);
        verify(primeraHabilidad, times(1)).setPoder(anyInt());
        verify(segundaHabilidad, times(1)).setPoder(anyInt());
    }

    @Test
    void TestAplicarEfectos(){
        int turnosAplicados = 1;

        tormentaRayos.aplicarEfectos(pokemon);
        verify(pokemon, times(1)).danarPorPorcentaje(anyInt());
        assertEquals(turnosAplicados, tormentaRayos.getTurnosAplicados());
        verify(primeraHabilidad, times(0)).setPoder(anyInt());
        verify(segundaHabilidad, times(0)).setPoder(anyInt());

        turnosAplicados++;
        when(pokemon.getTipos()).thenReturn(Tipos.ELECTRICO);

        tormentaRayos.aplicarEfectos(pokemon);
        verify(pokemon, times(1)).danarPorPorcentaje(anyInt());
        assertEquals(turnosAplicados, tormentaRayos.getTurnosAplicados());
        verify(primeraHabilidad, times(1)).setPoder(anyInt());
        verify(segundaHabilidad, times(1)).setPoder(anyInt());
    }
}
