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

public class NieblaTest {

    private CampoDeBatalla cdb;
    private Niebla niebla;
    private Pokemon pokemon;
    private Ataque primeraHabilidad;
    private Ataque segundaHabilidad;
    private boolean esValido;
    private int turnoFinal;

    @BeforeEach
    public void setup(){
        cdb = mock(CampoDeBatalla.class);
        niebla = new Niebla("Niebla", cdb);
        pokemon = mock(Pokemon.class);
        primeraHabilidad = mock(Ataque.class);
        segundaHabilidad = mock(Ataque.class);
        esValido = true;
        turnoFinal = 0;

        when(pokemon.getTipos()).thenReturn(Tipos.VOLADOR);
        when(primeraHabilidad.getTipo()).thenReturn(Tipos.AGUA);
        when(segundaHabilidad.getTipo()).thenReturn(Tipos.VOLADOR);
        when(cdb.getClima()).thenReturn(niebla);
        when(pokemon.getHabilidades()).thenReturn(new ArrayList<Habilidad>(Arrays.asList(
                primeraHabilidad,
                segundaHabilidad
        )));
    }

    @Test
    void TestTurnoValido(){
        int turnosValidos = 5;

        for(int i = 0; i < turnosValidos; i++) {
            assertEquals(i, niebla.getTurnosAplicados());
            assertEquals(esValido, niebla.turnoValido());
        }
        verify(niebla.getCdb(), times(0)).setClima(new SinClima("Sin clima", cdb));
        assertEquals(!esValido, niebla.turnoValido());
        assertEquals(turnoFinal, niebla.getTurnosAplicados());
    }

    @Test
    void TestPotenciarPokemon(){
        niebla.potenciarPokemon(pokemon);
        verify(primeraHabilidad, times(0)).setPoder(anyInt());
        verify(segundaHabilidad, times(0)).setPoder(anyInt());

        when(pokemon.getTipos()).thenReturn(Tipos.FANTASMA);

        niebla.potenciarPokemon(pokemon);
        verify(primeraHabilidad, times(1)).setPoder(anyInt());
        verify(segundaHabilidad, times(1)).setPoder(anyInt());

        when(pokemon.getTipos()).thenReturn(Tipos.PSIQUICO);

        niebla.potenciarPokemon(pokemon);
        verify(primeraHabilidad, times(2)).setPoder(anyInt());
        verify(segundaHabilidad, times(2)).setPoder(anyInt());
    }

    @Test
    void TestAplicarEfectos(){
        int turnosAplicados = 1;

        niebla.aplicarEfectos(pokemon);
        assertEquals(turnosAplicados, niebla.getTurnosAplicados());
        verify(primeraHabilidad, times(0)).setPoder(anyInt());
        verify(segundaHabilidad, times(0)).setPoder(anyInt());

        turnosAplicados++;
        when(pokemon.getTipos()).thenReturn(Tipos.PSIQUICO);

        niebla.aplicarEfectos(pokemon);
        assertEquals(turnosAplicados, niebla.getTurnosAplicados());
        verify(primeraHabilidad, times(1)).setPoder(anyInt());
        verify(segundaHabilidad, times(1)).setPoder(anyInt());

        turnosAplicados++;
        when(pokemon.getTipos()).thenReturn(Tipos.FANTASMA);

        niebla.aplicarEfectos(pokemon);
        assertEquals(turnosAplicados, niebla.getTurnosAplicados());
        verify(primeraHabilidad, times(2)).setPoder(anyInt());
        verify(segundaHabilidad, times(2)).setPoder(anyInt());
    }
}
