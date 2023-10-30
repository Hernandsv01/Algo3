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
        Revivir item = new Revivir(0, "Revivir");

        //Act
        Boolean resultado = item.usar(pokemon);

        //Assert
        assertEquals(false, resultado);
        assertNotEquals(true, resultado);
    }

    @Test
    public void testReduceCantidad() {
        //Arrange
        Revivir item = new Revivir(2, "Revivir");

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
    public void testCheckeaVidaPokemon() {
        //Arrange
        Revivir item = new Revivir(2, "Revivir");
        pokemon.setVidaActual(0);

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