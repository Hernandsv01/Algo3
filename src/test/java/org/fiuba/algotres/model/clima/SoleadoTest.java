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

public class SoleadoTest {

    private CampoDeBatalla cdb;
    private Soleado soleado;
    private Pokemon pokemon;
    private Ataque primeraHabilidad;
    private Ataque segundaHabilidad;
    private boolean esValido;
    private int turnoFinal;

    @BeforeEach
    public void setup(){
        cdb = mock(CampoDeBatalla.class);
        soleado = new Soleado("Soleado", cdb);
        pokemon = mock(Pokemon.class);
        primeraHabilidad = mock(Ataque.class);
        segundaHabilidad = mock(Ataque.class);
        esValido = true;
        turnoFinal = 0;

        when(pokemon.getTipos()).thenReturn(Tipos.VOLADOR);
        when(primeraHabilidad.getTipo()).thenReturn(Tipos.AGUA);
        when(segundaHabilidad.getTipo()).thenReturn(Tipos.VOLADOR);
        when(pokemon.getHabilidades()).thenReturn(new ArrayList<Habilidad>(Arrays.asList(
                primeraHabilidad,
                segundaHabilidad
        )));
        when(cdb.getClima()).thenReturn(soleado);
    }

    @Test
    void TestTurnoValido(){
        int turnosValidos = 5;

        for(int i = 0; i < turnosValidos; i++) {
            assertEquals(i, soleado.getTurnosAplicados());
            assertEquals(esValido, soleado.turnoValido());
        }
        verify(soleado.getCdb(), times(0)).setClima(new SinClima("Sin clima", cdb));
        assertEquals(!esValido, soleado.turnoValido());
        assertEquals(turnoFinal, soleado.getTurnosAplicados());
    }

    @Test
    void TestPotenciarPokemon(){
        soleado.potenciarPokemon(pokemon);
        verify(primeraHabilidad, times(0)).setPoder(anyInt());
        verify(segundaHabilidad, times(0)).setPoder(anyInt());

        when(pokemon.getTipos()).thenReturn(Tipos.FUEGO);

        soleado.potenciarPokemon(pokemon);
        verify(primeraHabilidad, times(1)).setPoder(anyInt());
        verify(segundaHabilidad, times(1)).setPoder(anyInt());
    }

    @Test
    void TestAplicarEfectos(){
        int turnosAplicados = 1;

        soleado.aplicarEfectos(pokemon);
        assertEquals(turnosAplicados, soleado.getTurnosAplicados());
        verify(primeraHabilidad, times(0)).setPoder(anyInt());
        verify(segundaHabilidad, times(0)).setPoder(anyInt());

        turnosAplicados++;
        when(pokemon.getTipos()).thenReturn(Tipos.FUEGO);

        soleado.aplicarEfectos(pokemon);
        assertEquals(turnosAplicados, soleado.getTurnosAplicados());
        verify(primeraHabilidad, times(1)).setPoder(anyInt());
        verify(segundaHabilidad, times(1)).setPoder(anyInt());
    }
}
