package org.fiuba.algotres.model.item;

import org.fiuba.algotres.model.Pokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CuraTodoTest {

    Pokemon pokemon;

    @BeforeEach
    public void initEach() {
        pokemon = mock(Pokemon.class);
    }

    @Test
    public void testSinCantidad() {
        //Arrange
        CuraTodo item = new CuraTodo(0, "CuraTodo");

        //Act
        Boolean resultado = item.usar(pokemon);

        //Assert
        assertEquals(false, resultado);
        assertNotEquals(true, resultado);
    }

    @Test
    public void testReduceCantidad() {
        //Arrange
        CuraTodo item = new CuraTodo(2, "CuraTodo");

        //Act
        item.usar(pokemon);

        //Assert
        assertNotEquals(2, item.getCantidad());
        assertEquals(1, item.getCantidad());
        assertNotEquals(0, item.getCantidad());

        //Act
        item.usar(pokemon);

        //Assert
        assertNotEquals(1, item.getCantidad());
        assertEquals(0, item.getCantidad());
        assertNotEquals(-1, item.getCantidad());

        //Act
        item.usar(pokemon);

        //Assert
        assertEquals(0, item.getCantidad());
        assertNotEquals(-1, item.getCantidad());
    }

    @Test
    public void testCheckeaEstadoPokemon() {
        //Arrange
        CuraTodo item = new CuraTodo(2, "CuraTodo");
        pokemon.setVidaActual(0);

        //Act
        item.usar(pokemon);

        //Assert
        verify(pokemon, times(1)).getEstados();

        //Act
        item.usar(pokemon);

        //Assert
        verify(pokemon, times(2)).getEstados();
    }
}