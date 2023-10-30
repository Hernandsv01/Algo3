package org.fiuba.algotres.model.clima;

import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.habilidad.Ataque;
import org.fiuba.algotres.model.habilidad.Habilidad;
import org.fiuba.algotres.model.tipos.Tipos;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class LluviaTest {

    @Test
    void TestTurnoValido(){
        //Arrange
        CampoDeBatalla cdb = mock(CampoDeBatalla.class);
        Lluvia lluvia = new Lluvia("Lluvia", cdb);
        when(cdb.getClima()).thenReturn(lluvia);


        //Act
        int turnosValidos = 5; //Los turnos que se aplica el clima son 5, luego pasa a ser otro.
        boolean esValido = true;
        int turnoFinal = 0; //Los turnos del clima que se cambia tienen que empezar en cero

        //Assert
        for(int i = 0; i < turnosValidos; i++) {
            assertEquals(i, lluvia.turnosAplicados);
            assertEquals(esValido, lluvia.turnoValido());
        }
        verify(lluvia.cdb, times(0)).setClima(new SinClima("Sin clima", cdb));
        assertEquals(!esValido, lluvia.turnoValido());
        assertEquals(turnoFinal, lluvia.turnosAplicados);

    }

    @Test
    void TestPotenciarPokemon(){
        //Arrange
        CampoDeBatalla cdb = mock(CampoDeBatalla.class);

        Lluvia lluvia = new Lluvia("Lluvia", cdb);
        when(cdb.getClima()).thenReturn(lluvia);

        Pokemon pokemon = mock(Pokemon.class);
        when(pokemon.getTipos()).thenReturn(Tipos.VOLADOR);

        Ataque habilidadAgua = mock(Ataque.class);
        when(habilidadAgua.getTipo()).thenReturn(Tipos.AGUA);

        Ataque habilidadVolador = mock(Ataque.class);
        when(habilidadVolador.getTipo()).thenReturn(Tipos.VOLADOR);

        when(pokemon.getHabilidades()).thenReturn(new ArrayList<Habilidad>(Arrays.asList(
                habilidadAgua,
                habilidadVolador
        )));

        //Act


        //Assert
        lluvia.potenciarPokemon(pokemon);
        verify(habilidadAgua, times(0)).setPoder(anyInt());
        verify(habilidadVolador, times(0)).setPoder(anyInt());

        when(pokemon.getTipos()).thenReturn(Tipos.AGUA);

        lluvia.potenciarPokemon(pokemon);
        verify(habilidadAgua, times(1)).setPoder(anyInt());
        verify(habilidadVolador, times(1)).setPoder(anyInt());

        when(pokemon.getTipos()).thenReturn(Tipos.PLANTA);

        lluvia.potenciarPokemon(pokemon);
        verify(habilidadAgua, times(2)).setPoder(anyInt());
        verify(habilidadVolador, times(2)).setPoder(anyInt());
    }

    @Test
    void TestAplicarEfectos(){
        //Arrange
        CampoDeBatalla cdb = mock(CampoDeBatalla.class);

        Lluvia lluvia = new Lluvia("Lluvia", cdb);
        when(cdb.getClima()).thenReturn(lluvia);

        Pokemon pokemon = mock(Pokemon.class);
        when(pokemon.getTipos()).thenReturn(Tipos.VOLADOR);

        Ataque habilidadFuego = mock(Ataque.class);
        when(habilidadFuego.getTipo()).thenReturn(Tipos.FUEGO);

        Ataque habilidadVolador = mock(Ataque.class);
        when(habilidadVolador.getTipo()).thenReturn(Tipos.VOLADOR);

        when(pokemon.getHabilidades()).thenReturn(new ArrayList<Habilidad>(Arrays.asList(
                habilidadFuego,
                habilidadVolador
        )));

        //Act
        int turnoFinal = 0; //Los turnos del clima que se cambia tienen que empezar en cero
        int turnosAplicados = 1;

        //Assert
        lluvia.aplicarEfectos(pokemon);
        assertEquals(turnosAplicados, lluvia.turnosAplicados);
        verify(habilidadFuego, times(0)).setPoder(anyInt());
        verify(habilidadVolador, times(0)).setPoder(anyInt());

        turnosAplicados++;
        when(pokemon.getTipos()).thenReturn(Tipos.AGUA);

        lluvia.aplicarEfectos(pokemon);
        assertEquals(turnosAplicados, lluvia.turnosAplicados);
        verify(habilidadFuego, times(1)).setPoder(anyInt());
        verify(habilidadVolador, times(1)).setPoder(anyInt());

        turnosAplicados++;
        when(pokemon.getTipos()).thenReturn(Tipos.PLANTA);

        lluvia.aplicarEfectos(pokemon);
        assertEquals(turnosAplicados, lluvia.turnosAplicados);
        verify(habilidadFuego, times(2)).setPoder(anyInt());
        verify(habilidadVolador, times(2)).setPoder(anyInt());
    }

}
