package org.fiuba.algotres.model;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestMethodOrder(OrderAnnotation.class)
public class JugadorTest {
    
    private static Jugador jugador;
    
    @BeforeAll
    public static void setup(){
        jugador = new Jugador(Arrays.asList(
                mock(Pokemon.class), mock(Pokemon.class), mock(Pokemon.class), mock(Pokemon.class)
        ), null);
        when(jugador.getPokemons().get(0).estaVivo()).thenReturn(true);
        when(jugador.getPokemons().get(1).estaVivo()).thenReturn(true);
        when(jugador.getPokemons().get(2).estaVivo()).thenReturn(false);
        when(jugador.getPokemons().get(3).estaVivo()).thenReturn(true);
    }

    
    @Test
    @Order(1)
    public void getPokemonActual() {
        // Get result
        Pokemon expectedResult = jugador.getPokemons().get(0);
        Pokemon result = jugador.getPokemonActual();
        
        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    @Order(2)
    public void testCambioAlSegundoPokemon() {
        // Setup
        boolean expectedBoolResult = true;
        Pokemon expectedPokeResult = jugador.getPokemons().get(1);
        
        // Get result
        boolean boolResult = jugador.cambiarPokemonActual(1);
        Pokemon pokeResult = jugador.getPokemonActual();
        
        // Assert
        assertEquals(expectedBoolResult, boolResult);
        assertEquals(expectedPokeResult, pokeResult);
    }
    @Test
    @Order(3)
    public void testCambioAlTercerPokemon() {
        // Setup
        boolean expectedBoolResult = true;
        Pokemon expectedPokeResult = jugador.getPokemons().get(3);
        
        // Get result
        boolean boolResult = jugador.cambiarPokemonActual(2);
        Pokemon pokeResult = jugador.getPokemons().get(0);
        
        // Assert
        assertEquals(expectedBoolResult, boolResult);
        assertEquals(expectedPokeResult, pokeResult);
    }
    @Test
    @Order(4)
    public void testCambioAPokemonInexistente() {
        // Setup
        boolean expectedBoolResult = false;
        Pokemon expectedPokeResult = jugador.getPokemons().get(0);
        
        // Get result
        boolean boolResult = jugador.cambiarPokemonActual(10);
        Pokemon pokeResult = jugador.getPokemons().get(0);
        
        // Assert
        assertEquals(expectedBoolResult, boolResult);
        assertEquals(expectedPokeResult, pokeResult);
    }

    @Test
    @Order(5)
    public void testObtenerPokemonsVivos() {
        // Setup
        List<Pokemon> expectedResult = List.of(
                jugador.getPokemons().get(0),
                jugador.getPokemons().get(1),
                jugador.getPokemons().get(3)
        );
        
        // Get result
        List<Pokemon> result = jugador.getPokemonsVivos();
        
        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    @Order(6)
    public void testObtenerPokemonsMuertos() {
        // Setup
        List<Pokemon> expectedResult = List.of(
                jugador.getPokemons().get(2)
        );
        
        // Get result
        List<Pokemon> result = jugador.getPokemonsMuertos();
        
        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    @Order(7)
    public void testPokemosMuertosAlRendirse() {
        // Setup
        Integer expectedVida = 0;
        boolean expectedEstaVivo = false;
        
        // Get result
        jugador.rendirse();
        
        // Assert
        for(int i = 0; i < jugador.getPokemons().size(); i++){
            assertEquals(expectedVida, jugador.getPokemons().get(i).getVidaActual());
            assertEquals(expectedEstaVivo, jugador.getPokemons().get(i).isEstaVivo());
        }
    }
}