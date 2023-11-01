package org.fiuba.algotres.model.item;

import org.fiuba.algotres.model.Pokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

public class HiperPocionTest {
    Pokemon pokemon;

    @BeforeEach
    public void initEach() {
        pokemon = mock(Pokemon.class);
    }

    @Test
    public void testSinCantidad() {
        //Arrange
        Item item = FactoryItem.Crear(0, "Hiper Poción");

        //Act
        Boolean resultado = item.usar(pokemon);

        //Assert
        assertEquals(false, resultado);
        assertNotEquals(true, resultado);
    }

    @Test
    public void testReduceCantidad() {
        //Arrange
        Item item = FactoryItem.Crear(2, "Hiper Poción");

        //Act
        Boolean res1 = item.usar(pokemon);

        //Assert
        assertNotEquals(2, item.getCantidad());
        assertEquals(0, item.getCantidad());
        assertNotEquals(1, item.getCantidad());
        assertEquals(true, res1);

        //Act
        Boolean res2 = item.usar(pokemon);

        //Assert
        assertNotEquals(1, item.getCantidad());
        assertEquals(0, item.getCantidad());
        assertNotEquals(-1, item.getCantidad());
        assertEquals(false, res2);
        //La utiliza una vez, ya que el limite de items "Hiper Poción" está limitado a 1.
    }

    @Test
    public void testCheckeaCurarPuntosPokemon() {
        //Arrange
        Item item = FactoryItem.Crear(2, "Hiper Poción");

        //Act & Assert
        item.usar(pokemon);
        verify(pokemon, times(1)).curarPorPuntos(item.getEficiencia());

        //Act & Assert
        item.usar(pokemon);
        verify(pokemon, times(1)).curarPorPuntos(item.getEficiencia());
        //La utiliza una vez, ya que el limite de items "Hiper Poción" está limitado a 1.
    }
}
