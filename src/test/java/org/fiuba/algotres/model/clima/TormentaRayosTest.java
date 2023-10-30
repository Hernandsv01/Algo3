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

public class TormentaRayosTest {

    @Test
    void TestTurnoValido(){
        //Arrange
        CampoDeBatalla cdb = mock(CampoDeBatalla.class);
        TormentaRayos tormentaRayos = new TormentaRayos("Tormenta de rayos", cdb);
        when(cdb.getClima()).thenReturn(tormentaRayos);


        //Act
        int turnosValidos = 5; //Los turnos que se aplica el clima son 5, luego pasa a ser otro.
        boolean esValido = true;
        int turnoFinal = 0; //Los turnos del clima que se cambia tienen que empezar en cero

        //Assert
        for(int i = 0; i < turnosValidos; i++) {
            assertEquals(i, tormentaRayos.turnosAplicados);
            assertEquals(esValido, tormentaRayos.turnoValido());
        }
        verify(tormentaRayos.cdb, times(0)).setClima(new SinClima("Sin clima", cdb));
        assertEquals(!esValido, tormentaRayos.turnoValido());
        assertEquals(turnoFinal, tormentaRayos.turnosAplicados);
    }

    @Test
    void TestPotenciarPokemon(){
        //Arrange
        CampoDeBatalla cdb = mock(CampoDeBatalla.class);

        TormentaRayos tormentaRayos = new TormentaRayos("Tormenta de rayos", cdb);
        when(cdb.getClima()).thenReturn(tormentaRayos);

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


        //Assert
        tormentaRayos.potenciarPokemon(pokemon);
        verify(habilidadFuego, times(0)).setPoder(anyInt());
        verify(habilidadVolador, times(0)).setPoder(anyInt());

        when(pokemon.getTipos()).thenReturn(Tipos.ELECTRICO);

        tormentaRayos.potenciarPokemon(pokemon);
        verify(habilidadFuego, times(1)).setPoder(anyInt());
        verify(habilidadVolador, times(1)).setPoder(anyInt());

    }

    @Test
    void TestAplicarEfectos(){
        //Arrange
        CampoDeBatalla cdb = mock(CampoDeBatalla.class);

        TormentaRayos tormentaRayos = new TormentaRayos("Tormenta de rayos", cdb);
        when(cdb.getClima()).thenReturn(tormentaRayos);

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
        boolean esValido = true;
        int turnoFinal = 0; //Los turnos del clima que se cambia tienen que empezar en cero
        int turnosAplicados = 1;

        //Assert
        tormentaRayos.aplicarEfectos(pokemon);
        verify(pokemon, times(1)).danarPorPorcentaje(anyInt());
        assertEquals(turnosAplicados, tormentaRayos.turnosAplicados);
        verify(habilidadFuego, times(0)).setPoder(anyInt());
        verify(habilidadVolador, times(0)).setPoder(anyInt());

        turnosAplicados++;
        when(pokemon.getTipos()).thenReturn(Tipos.ELECTRICO);

        tormentaRayos.aplicarEfectos(pokemon);
        verify(pokemon, times(1)).danarPorPorcentaje(anyInt());
        assertEquals(turnosAplicados, tormentaRayos.turnosAplicados);
        verify(habilidadFuego, times(1)).setPoder(anyInt());
        verify(habilidadVolador, times(1)).setPoder(anyInt());
    }

}
