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

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class SinClimaTest {

    private CampoDeBatalla cdb;
    private SinClima sinClima;
    private Pokemon pokemon;
    private Ataque habilidadAtaque;
    private boolean esValido;
    private int turnosValidos;

    @BeforeEach
    public void setup(){
        cdb = mock(CampoDeBatalla.class);
        sinClima = new SinClima("Sin clima", cdb);
        pokemon = mock(Pokemon.class);
        habilidadAtaque = mock(Ataque.class);
        turnosValidos = 50;
        esValido = true;

        when(pokemon.getTipos()).thenReturn(Tipos.VOLADOR);
        when(habilidadAtaque.getTipo()).thenReturn(Tipos.FUEGO);
        when(cdb.getClima()).thenReturn(sinClima);
        when(pokemon.getHabilidades()).thenReturn(new ArrayList<Habilidad>(Arrays.asList(
                habilidadAtaque
        )));
    }

    @Test
    void TestTurnoValido(){
        for(int i = 0; i < turnosValidos; i++) {
            assertEquals(i, sinClima.getTurnosAplicados());
            assertEquals(esValido, sinClima.turnoValido());
        }
    }

    @Test
    void TestPotenciarPokemon(){
        sinClima.potenciarPokemon(pokemon);
        verify(habilidadAtaque, times(0)).setPoder(anyInt());
        verify(pokemon, times(0)).danarPorPorcentaje(anyInt());
    }

    @Test
    void TestAplicarEfectos(){
        for(int i = 1; i < turnosValidos; i++) {
            sinClima.aplicarEfectos(pokemon);
            assertEquals(i, sinClima.getTurnosAplicados());;
            verify(habilidadAtaque, times(0)).setPoder(anyInt());
        }
    };
}
