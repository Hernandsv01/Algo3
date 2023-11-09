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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class HuracanTest {

    private CampoDeBatalla cdb;
    private Huracan huracan;
    private Pokemon pokemon;
    private Ataque primeraHabilidad;
    private Ataque segundaHabilidad;
    private boolean esValido;
    private int turnoFinal;

    @BeforeEach
    public void setup(){
        cdb = mock(CampoDeBatalla.class);
        huracan = new Huracan("Huracan", cdb);
        pokemon = mock(Pokemon.class);
        primeraHabilidad = mock(Ataque.class);
        segundaHabilidad = mock(Ataque.class);
        esValido = true;
        turnoFinal = 0;

        when(cdb.getClima()).thenReturn(huracan);
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
            assertEquals(i, huracan.getTurnosAplicados());
            assertEquals(esValido, huracan.turnoValido());
        }
        verify(huracan.getCdb(), times(0)).setClima(new SinClima("Sin clima", cdb));
        assertEquals(!esValido, huracan.turnoValido());
        assertEquals(turnoFinal, huracan.getTurnosAplicados());
    }

    @Test
    void TestPotenciarPokemon(){
        huracan.potenciarPokemon(pokemon);
        verify(primeraHabilidad, times(1)).setPoder(anyInt());
        verify(segundaHabilidad, times(1)).setPoder(anyInt());

        when(pokemon.getTipos()).thenReturn(Tipos.FUEGO);

        huracan.potenciarPokemon(pokemon);
        verify(primeraHabilidad, times(1)).setPoder(anyInt());
        verify(segundaHabilidad, times(1)).setPoder(anyInt());
    }

    @Test
    void TestAplicarEfectos(){
        int turnosAplicados = 1;

        huracan.aplicarEfectos(pokemon);
        verify(pokemon, times(0)).danarPorPorcentaje(anyInt());
        assertEquals(turnosAplicados, huracan.getTurnosAplicados());
        verify(primeraHabilidad, times(1)).setPoder(anyInt());
        verify(segundaHabilidad, times(1)).setPoder(anyInt());

        turnosAplicados++;
        when(pokemon.getTipos()).thenReturn(Tipos.FUEGO);

        huracan.aplicarEfectos(pokemon);
        verify(pokemon, times(1)).danarPorPorcentaje(anyInt());
        assertEquals(turnosAplicados, huracan.getTurnosAplicados());
        verify(primeraHabilidad, times(1)).setPoder(anyInt());
        verify(segundaHabilidad, times(1)).setPoder(anyInt());
    }
}
