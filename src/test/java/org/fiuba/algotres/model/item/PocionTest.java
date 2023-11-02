package org.fiuba.algotres.model.item;

import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.strategies.Strategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PocionTest {

    Pokemon pokemon;

    @BeforeEach
    public void initEach() {
        pokemon = mock(Pokemon.class);
    }

    @Test
    public void testCreacionCorrectaDeVariantesCantidadCero() {
        //Arrange
        Item itemPocionCero = FactoryItem.CrearPocion(0);
        Item itemMegaPocionCero = FactoryItem.CrearMegaPocion(0);
        Item itemHiperPocionCero = FactoryItem.CrearHiperPocion(0);

        //Assert
        assertEquals("Pocion", itemPocionCero.getNombre());
        assertEquals(0, itemPocionCero.getCantidad());

        assertEquals("Mega Pocion", itemMegaPocionCero.getNombre());
        assertEquals(0, itemMegaPocionCero.getCantidad());

        assertEquals("Hiper Pocion", itemHiperPocionCero.getNombre());
        assertEquals(0, itemHiperPocionCero.getCantidad());
    }

    @Test
    public void testCreacionCorrectaDeVariantesCantidadDistintaDeCero() {
        //Arrange
        Item itemPocionCero = FactoryItem.CrearPocion(10);
        Item itemMegaPocionCero = FactoryItem.CrearMegaPocion(10);
        Item itemHiperPocionCero = FactoryItem.CrearHiperPocion(10);

        //Assert
        assertEquals("Pocion", itemPocionCero.getNombre());
        assertEquals(10, itemPocionCero.getCantidad());

        assertEquals("Mega Pocion", itemMegaPocionCero.getNombre());
        assertEquals(10, itemMegaPocionCero.getCantidad());

        assertEquals("Hiper Pocion", itemHiperPocionCero.getNombre());
        assertEquals(1, itemHiperPocionCero.getCantidad());
        //Las Hiper Pociones estan limitadas a 1 unidad
    }

    @Test
    public void testSinCantidad() {
        //Arrange
        Item item = FactoryItem.CrearPocion(0);

        //Act
        Boolean resultado = item.usar(pokemon);

        //Assert
        assertEquals(false, resultado);
        assertNotEquals(true, resultado);
    }

    @Test
    public void testReduceCantidad() {
        //Arrange
        Item item = FactoryItem.CrearPocion(2);

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
    public void testCheckeaCurarPuntosPokemonPocion() {
        //Arrange
        Item item = FactoryItem.CrearPocion(2);

        //Act & Assert
        item.usar(pokemon);
        verify(pokemon, times(1)).curarPorPuntos(FactoryItem.getEfectividadPocion());

        //Act & Assert
        item.usar(pokemon);
        verify(pokemon, times(2)).curarPorPuntos(FactoryItem.getEfectividadPocion());
    }

    @Test
    public void testCheckeaCurarPuntosPokemonMegaPocion() {
        //Arrange
        Item item = FactoryItem.CrearMegaPocion(2);

        //Act & Assert
        item.usar(pokemon);
        verify(pokemon, times(1)).curarPorPuntos(FactoryItem.getEfectividadMegaPocion());

        //Act & Assert
        item.usar(pokemon);
        verify(pokemon, times(2)).curarPorPuntos(FactoryItem.getEfectividadMegaPocion());
    }

    @Test
    public void testCheckeaCurarPuntosPokemonHiperPocion() {
        //Arrange
        Item item = FactoryItem.CrearHiperPocion(2);

        //Act & Assert
        item.usar(pokemon);
        verify(pokemon, times(1)).curarPorPuntos(FactoryItem.getEfectividadHiperPocion());

        //Act & Assert
        item.usar(pokemon);
        verify(pokemon, times(1)).curarPorPuntos(FactoryItem.getEfectividadHiperPocion());
        //No se modifico porque las Hiper Pociones estan limitadas a 1 unidad
    }
}