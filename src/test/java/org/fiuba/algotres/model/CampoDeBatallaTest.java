package org.fiuba.algotres.model;

import org.junit.jupiter.api.*;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CampoDeBatallaTest {
    
    private static CampoDeBatalla cdb;
    private static Jugador jugadorCero;
    private static Jugador jugadorUno;

    @BeforeAll
    public static void setup(){
        jugadorCero = mock(Jugador.class);
        jugadorUno = mock(Jugador.class);
        cdb = new CampoDeBatalla();
        cdb.setJugadores(
                new Jugador[]{
                        jugadorCero,
                        jugadorUno
                }
        );
    }
    
    @Test
    @Order(1)
    public void testGanaElJugadorUno() {
        // Setup
        when(jugadorCero.getPokemonsVivos()).thenReturn(List.of());
        when(jugadorUno.getPokemonsVivos()).thenReturn(List.of(mock(Pokemon.class)));
        
        // Get result
        int expectedResult = 1;
        int result = cdb.getGanador();
        
        // Assert
        assertEquals(expectedResult, result);
    }
    @Test
    @Order(2)
    public void testGanaElJugadorCero() {
        // Setup
        when(jugadorCero.getPokemonsVivos()).thenReturn(List.of(mock(Pokemon.class)));
        when(jugadorUno.getPokemonsVivos()).thenReturn(List.of());
        
        // Get result
        int expectedResult = 0;
        int result = cdb.getGanador();
        
        // Assert
        assertEquals(expectedResult, result);
    }
    @Test
    @Order(3)
    public void testNoHayGanador() {
        // Setup
        when(jugadorCero.getPokemonsVivos()).thenReturn(List.of(mock(Pokemon.class)));
        when(jugadorUno.getPokemonsVivos()).thenReturn(List.of(mock(Pokemon.class)));
        
        // Get result
        int expectedResult = -1;
        int result = cdb.getGanador();
        
        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    @Order(4)
    public void testIniciaJugadorCeroPorVelocidad() {
        // Setup
        Pokemon pokemonCero = mock(Pokemon.class);
        Pokemon pokemonUno = mock(Pokemon.class);
        
        when(jugadorCero.getPokemonActual()).thenReturn(pokemonCero);
        when(pokemonCero.getVelocidad()).thenReturn(10);
        
        when(jugadorUno.getPokemonActual()).thenReturn(pokemonCero);
        when(pokemonUno.getVelocidad()).thenReturn(0);
        
        cdb.setJugadorInicialPorAtributo(Comparator.comparingInt(jugador -> jugador.getPokemonActual().getVelocidad()));
        
        // Get result
        int expectedResult = 1;
        int result = cdb.getTurnoActual();
        
        // Assert
        assertEquals(expectedResult, result);
    }
    @Test
    @Order(5)
    public void testIniciaJugadorUnoPorVelocidad() {
        // Setup
        Pokemon pokemonCero = mock(Pokemon.class);
        Pokemon pokemonUno = mock(Pokemon.class);
        
        when(jugadorCero.getPokemonActual()).thenReturn(pokemonCero);
        when(pokemonCero.getVelocidad()).thenReturn(0);
        
        when(jugadorUno.getPokemonActual()).thenReturn(pokemonCero);
        when(pokemonUno.getVelocidad()).thenReturn(10);
        
        cdb.setJugadorInicialPorAtributo(Comparator.comparingInt(jugador -> jugador.getPokemonActual().getVelocidad()));
        
        // Get result
        int expectedResult = 1;
        int result = cdb.getTurnoActual();
        
        // Assert
        assertEquals(expectedResult, result);
    }
    @Test
    @Order(6)
    public void testIniciaJugadorCeroPorNivel() {
        // Setup
        Pokemon pokemonCero = mock(Pokemon.class);
        Pokemon pokemonUno = mock(Pokemon.class);
        
        when(jugadorCero.getPokemonActual()).thenReturn(pokemonCero);
        when(pokemonCero.getNivel()).thenReturn(0);
        
        when(jugadorUno.getPokemonActual()).thenReturn(pokemonCero);
        when(pokemonUno.getNivel()).thenReturn(10);
        
        cdb.setJugadorInicialPorAtributo(Comparator.comparingInt(jugador -> jugador.getPokemonActual().getNivel()));
        
        // Get result
        int expectedResult = 1;
        int result = cdb.getTurnoActual();
        
        // Assert
        assertEquals(expectedResult, result);
    }
    @Test
    @Order(7)
    public void testIniciaJugadorUnoPorNivel() {
        // Setup
        Pokemon pokemonCero = mock(Pokemon.class);
        Pokemon pokemonUno = mock(Pokemon.class);
        
        when(jugadorCero.getPokemonActual()).thenReturn(pokemonCero);
        when(pokemonCero.getNivel()).thenReturn(10);
        
        when(jugadorUno.getPokemonActual()).thenReturn(pokemonCero);
        when(pokemonUno.getNivel()).thenReturn(0);
        
        cdb.setJugadorInicialPorAtributo(Comparator.comparingInt(jugador -> jugador.getPokemonActual().getNivel()));
        
        // Get result
        int expectedResult = 1;
        int result = cdb.getTurnoActual();
        
        // Assert
        assertEquals(expectedResult, result);
    }
    
    @Test
    @Order(8)
    public void testSiguienteTurnoEsCero() {
        // Setup
        cdb.setTurnoActual(1);
        
        // Get result
        int expectedResult = 0;
        int result = cdb.getSiguienteTurno();
        
        // Assert
        assertEquals(expectedResult, result);
    }    
    @Test
    @Order(9)
    public void testSiguienteTurnoEsUno() {
        // Setup
        cdb.setTurnoActual(0);
        
        // Get result
        int expectedResult = 1;
        int result = cdb.getSiguienteTurno();
        
        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    @Order(10)
    public void testTurnoActualEsUno() {
        // Setup
        cdb.setTurnoActual(0);
    
        // Get result
        int expectedResult = 1;
        cdb.setSiguienteTurno();
        
        // Assert
        assertEquals(expectedResult, cdb.getTurnoActual());
    }
    @Test
    @Order(11)
    public void testTurnoActualEsCero() {
        // Setup
        cdb.setTurnoActual(1);
    
        // Get result
        int expectedResult = 0;
        cdb.setSiguienteTurno();
        
        // Assert
        assertEquals(expectedResult, cdb.getTurnoActual());
    }

    @Test
    @Order(12)
    public void testJugadorActualEsJugadorCero() {
        // Setup
        cdb.setTurnoActual(0);
    
        // Get result
        Jugador jugadorRes = cdb.getJugadorActual();
        
        // Assert
        assertEquals(jugadorRes, jugadorCero);
    }
    @Test
    @Order(13)
    public void testJugadorActualEsJugadorUno() {
        // Setup
        cdb.setTurnoActual(1);
    
        // Get result
        Jugador jugadorRes = cdb.getJugadorActual();
        
        // Assert
        assertEquals(jugadorRes, jugadorUno);
    }
}