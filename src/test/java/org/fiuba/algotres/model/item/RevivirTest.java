package org.fiuba.algotres.model.item;

import org.fiuba.algotres.model.Pokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RevivirTest {
    Pokemon pokemon;

    @BeforeEach
    public void initEach() {
        pokemon = mock(Pokemon.class);
    }

    @Test
    public void testSinCantidad() {
        //Arrange
        Item item = FactoryItem.crearRevivir(0);

        //Act
        Boolean resultado = item.usar(pokemon);

        //Assert
        assertEquals(false, resultado);
        assertNotEquals(true, resultado);
    }

    @Test
    public void testReduceCantidad() {
        //Arrange
        Item item = FactoryItem.crearRevivir(2);
        when(pokemon.estaVivo()).thenReturn(false);

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
    public void testCheckeaVidaPokemon() {
        //Arrange
        Item item = FactoryItem.crearRevivir(2);

        //Act
        item.usar(pokemon);

        //Assert
        verify(pokemon, times(1)).estaVivo();

        //Act
        item.usar(pokemon);

        //Assert
        verify(pokemon, times(2)).estaVivo();
    }
}