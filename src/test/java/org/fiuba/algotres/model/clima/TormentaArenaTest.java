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

public class TormentaArenaTest {

    private CampoDeBatalla cdb;
    private TormentaArena tormentaArena;
    private Pokemon pokemon;
    private Ataque primeraHabilidad;
    private Ataque segundaHabilidad;
    private boolean esValido;
    private int turnoFinal;

    @BeforeEach
    public void setup(){
        cdb = mock(CampoDeBatalla.class);
        tormentaArena = new TormentaArena("Tormenta de arena", cdb);
        pokemon = mock(Pokemon.class);
        segundaHabilidad = mock(Ataque.class);
        primeraHabilidad = mock(Ataque.class);
        esValido = true;
        turnoFinal = 0;

        when(cdb.getClima()).thenReturn(tormentaArena);
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
            assertEquals(i, tormentaArena.getTurnosAplicados());
            assertEquals(esValido, tormentaArena.turnoValido());
        }
        verify(tormentaArena.getCdb(), times(0)).setClima(new SinClima("Sin clima", cdb));
        assertEquals(!esValido, tormentaArena.turnoValido());
        assertEquals(turnoFinal, tormentaArena.getTurnosAplicados());
    }

    @Test
    void TestPotenciarPokemon(){
        tormentaArena.potenciarPokemon(pokemon);
        verify(primeraHabilidad, times(0)).setPoder(anyInt());
        verify(segundaHabilidad, times(0)).setPoder(anyInt());

        when(pokemon.getTipos()).thenReturn(Tipos.TIERRA);

        tormentaArena.potenciarPokemon(pokemon);
        verify(primeraHabilidad, times(1)).setPoder(anyInt());
        verify(segundaHabilidad, times(1)).setPoder(anyInt());

        when(pokemon.getTipos()).thenReturn(Tipos.ROCA);

        tormentaArena.potenciarPokemon(pokemon);
        verify(primeraHabilidad, times(2)).setPoder(anyInt());
        verify(segundaHabilidad, times(2)).setPoder(anyInt());
    }

    @Test
    void TestAplicarEfectos(){
        int turnosAplicados = 1;

        tormentaArena.aplicarEfectos(pokemon);
        verify(pokemon, times(1)).danarPorPorcentaje(anyInt());
        assertEquals(turnosAplicados, tormentaArena.getTurnosAplicados());
        verify(primeraHabilidad, times(0)).setPoder(anyInt());
        verify(segundaHabilidad, times(0)).setPoder(anyInt());

        turnosAplicados++;
        when(pokemon.getTipos()).thenReturn(Tipos.TIERRA);

        tormentaArena.aplicarEfectos(pokemon);
        verify(pokemon, times(1)).danarPorPorcentaje(anyInt());
        assertEquals(turnosAplicados, tormentaArena.getTurnosAplicados());
        verify(primeraHabilidad, times(1)).setPoder(anyInt());
        verify(segundaHabilidad, times(1)).setPoder(anyInt());

        turnosAplicados++;
        when(pokemon.getTipos()).thenReturn(Tipos.ROCA);

        tormentaArena.aplicarEfectos(pokemon);
        verify(pokemon, times(1)).danarPorPorcentaje(anyInt());
        assertEquals(turnosAplicados, tormentaArena.getTurnosAplicados());
        verify(primeraHabilidad, times(2)).setPoder(anyInt());
        verify(segundaHabilidad, times(2)).setPoder(anyInt());
    }
}
