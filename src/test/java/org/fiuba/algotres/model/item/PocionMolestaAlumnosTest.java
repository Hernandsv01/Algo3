package org.fiuba.algotres.model.item;

import org.fiuba.algotres.model.Pokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

public class PocionMolestaAlumnosTest {
    Pokemon pokemon;

    @BeforeEach
    public void initEach() {
        pokemon = mock(Pokemon.class);
    }

    @Test
    public void testSinCantidad() {
        //Arrange
        Item item = FactoryItem.crearPocionMolestaAlumnos(0);

        //Act
        Boolean resultado = item.usar(pokemon);

        //Assert
        assertEquals(false, resultado);
        assertNotEquals(true, resultado);
    }

    @Test
    public void testReduceCantidad() {
        //Arrange
        Item item = FactoryItem.crearPocionMolestaAlumnos(2);

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
    public void testCheckeaCurarPorcentajePokemon() {
        //Arrange
        Item item = FactoryItem.crearPocionMolestaAlumnos(2);

        //Act & Assert
        item.usar(pokemon);
        verify(pokemon, times(1)).curarPorPorcentaje(FactoryItem.getEfectividadPocionMolestaAlumnos());

        //Act & Assert
        item.usar(pokemon);
        verify(pokemon, times(2)).curarPorPorcentaje(FactoryItem.getEfectividadPocionMolestaAlumnos());
    }
}
