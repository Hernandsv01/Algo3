package org.fiuba.algotres.model.clima;

import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.habilidad.Ataque;
import org.fiuba.algotres.model.habilidad.Habilidad;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class SinClimaTest {

    @Test
    void TestTurnoValido(){
        //Arrange
        CampoDeBatalla cdb = mock(CampoDeBatalla.class);
        SinClima sinClima = new SinClima("Sin clima", cdb);
        when(cdb.getClima()).thenReturn(sinClima);


        //Act
        int turnosValidos = 50; //Cualquier turno es valido, le asignamos aleatoriamente
        boolean esValido = true;

        //Assert
        for(int i = 0; i < turnosValidos; i++) {
            assertEquals(i, sinClima.turnosAplicados);
            assertEquals(esValido, sinClima.turnoValido());
        }

    };

    @Test
    void TestPotenciarPokemon(){
        //Arrange
        CampoDeBatalla cdb = mock(CampoDeBatalla.class);
        SinClima sinClima = new SinClima("Sin clima", cdb);
        when(cdb.getClima()).thenReturn(sinClima);

        Pokemon pokemon = mock(Pokemon.class);
        Ataque habilidadAtaque = mock(Ataque.class);
        when(habilidadAtaque.getPoder()).thenReturn(50);
        ArrayList<Habilidad> habilidades = new ArrayList<Habilidad>(Arrays.asList(
                habilidadAtaque
        ));
        when(pokemon.getHabilidades()).thenReturn(habilidades);

        //Act
        int poderEsperado = 50;

        //Assert
        sinClima.potenciarPokemon(pokemon);
        verify(habilidadAtaque, times(0)).setPoder(anyInt());
        verify(pokemon, times(0)).danarPorPorcentaje(anyInt());
    };

    @Test
    void TestAplicarEfectos(){
        //Arrange
        CampoDeBatalla cdb = mock(CampoDeBatalla.class);
        SinClima sinClima = new SinClima("Sin clima", cdb);
        when(cdb.getClima()).thenReturn(sinClima);

        Pokemon pokemon = mock(Pokemon.class);
        Ataque habilidadAtaque = mock(Ataque.class);
        when(habilidadAtaque.getPoder()).thenReturn(50);
        ArrayList<Habilidad> habilidades = new ArrayList<Habilidad>(Arrays.asList(
                habilidadAtaque
        ));
        when(pokemon.getHabilidades()).thenReturn(habilidades);

        //Act
        int turnosValidos = 50; //Cualquier turno es valido, le asignamos aleatoriamente
        boolean esValido = true;
        int poderEsperado = 50;

        //Assert
        for(int i = 1; i < turnosValidos; i++) {
            sinClima.aplicarEfectos(pokemon);
            assertEquals(i, sinClima.turnosAplicados);;
            verify(habilidadAtaque, times(0)).setPoder(anyInt());
        }
    };

}
