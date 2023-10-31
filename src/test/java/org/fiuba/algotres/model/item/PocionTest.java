package org.fiuba.algotres.model.item;

import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.strategies.Strategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PocionTest {

    Pokemon pokemon;
    int cantidadDeVidaPocion;

    @BeforeEach
    public void initEach() {
        pokemon = mock(Pokemon.class);
        cantidadDeVidaPocion = 25;
    }

    @Test
    public void testSinCantidad() {
        //Arrange
        Pocion item = new Pocion(0, "Pocion", cantidadDeVidaPocion);

        //Act
        Boolean resultado = item.usar(pokemon);

        //Assert
        assertEquals(false, resultado);
        assertNotEquals(true, resultado);
    }

    @Test
    public void testReduceCantidad() {
        //Arrange
        Pocion item = new Pocion(2, "Pocion", cantidadDeVidaPocion);

        //Act
        Boolean res1 = item.usar(pokemon);

        //Assert
        assertNotEquals(2, item.getCantidad());
        assertEquals(1, item.getCantidad());
        assertNotEquals(0, item.getCantidad());
        assertEquals(true, res1);

        //Act
        Boolean res2 = item.usar(pokemon);

        //Assert
        assertNotEquals(1, item.getCantidad());
        assertEquals(0, item.getCantidad());
        assertNotEquals(-1, item.getCantidad());
        assertEquals(true, res2);

        //Act
        Boolean res3 = item.usar(pokemon);

        //Assert
        assertEquals(0, item.getCantidad());
        assertNotEquals(-1, item.getCantidad());
        assertEquals(false, res3);
    }

    @Test
    public void testCheckeaCurarPuntosPokemon() {
        //Arrange
        Pocion item = new Pocion(2, "Pocion", cantidadDeVidaPocion);

        //Act & Assert
        item.usar(pokemon);
        verify(pokemon, times(1)).curarPorPuntos(cantidadDeVidaPocion);

        //Act & Assert
        item.usar(pokemon);
        verify(pokemon, times(2)).curarPorPuntos(cantidadDeVidaPocion);
    }
}