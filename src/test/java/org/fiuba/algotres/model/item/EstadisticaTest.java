package org.fiuba.algotres.model.item;

import org.fiuba.algotres.model.Pokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

class EstadisticaTest {
    Pokemon pokemon;

    @BeforeEach
    public void initEach() {
        pokemon = mock(Pokemon.class);
    }

    @Test
    public void testSinCantidad() {
        //Arrange
        Item item1 = FactoryItem.crearAtaqueX(0);
        Item item2 = FactoryItem.crearDefensaX(0);

        //Act
        Boolean resultado1 = item1.usar(pokemon);
        Boolean resultado2 = item2.usar(pokemon);

        //Assert
        assertEquals(false, resultado1);
        assertNotEquals(true, resultado1);
        assertEquals(false, resultado2);
        assertNotEquals(true, resultado2);
    }

    @Test
    public void testReduceCantidad() {
        //Arrange
        Item item1 = FactoryItem.crearAtaqueX(2);
        Item item2 = FactoryItem.crearDefensaX(2);

        //Act
        Boolean res1item1 = item1.usar(pokemon);
        Boolean res1item2 = item2.usar(pokemon);

        //Assert
        assertNotEquals(2, item1.getCantidad());
        assertEquals(1, item1.getCantidad());
        assertNotEquals(0, item1.getCantidad());
        assertEquals(true, res1item1);

        assertNotEquals(2, item2.getCantidad());
        assertEquals(1, item2.getCantidad());
        assertNotEquals(0, item2.getCantidad());
        assertEquals(true, res1item2);

        //Act
        Boolean res2item1 = item1.usar(pokemon);
        Boolean res2item2 = item2.usar(pokemon);

        //Assert
        assertNotEquals(1, item1.getCantidad());
        assertEquals(0, item1.getCantidad());
        assertNotEquals(-1, item1.getCantidad());
        assertEquals(true, res2item1);

        assertNotEquals(1, item2.getCantidad());
        assertEquals(0, item2.getCantidad());
        assertNotEquals(-1, item2.getCantidad());
        assertEquals(true, res2item2);

        //Act
        Boolean res3item1 = item1.usar(pokemon);
        Boolean res3item2 = item2.usar(pokemon);

        //Assert
        assertEquals(0, item1.getCantidad());
        assertNotEquals(-1, item1.getCantidad());
        assertEquals(false, res3item1);

        assertEquals(0, item2.getCantidad());
        assertNotEquals(-1, item2.getCantidad());
        assertEquals(false, res3item2);
    }
}
