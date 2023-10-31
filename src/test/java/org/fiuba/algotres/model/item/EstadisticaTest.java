package org.fiuba.algotres.model.item;

import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.strategies.Strategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

class EstadisticaTest {
    Pokemon pokemon;
    Strategy strategy;
    int porcentaje;

    @BeforeEach
    public void initEach() {
        pokemon = mock(Pokemon.class);
        strategy = mock(Strategy.class);
        porcentaje = 10;
    }

    @Test
    public void testSinCantidad() {
        //Arrange
        Estadistica item = new Estadistica(0, "Estadistica", porcentaje, strategy);

        //Act
        Boolean resultado = item.usar(pokemon);

        //Assert
        assertEquals(false, resultado);
        assertNotEquals(true, resultado);
    }

    @Test
    public void testReduceCantidad() {
        //Arrange
        Estadistica item = new Estadistica(2, "Estadistica", porcentaje, strategy);

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
    public void testCheckeaModificarStrategy() {
        //Arrange
        Estadistica item = new Estadistica(2, "Estadistica",porcentaje, strategy);

        //Act
        item.usar(pokemon);

        //Assert
        verify(strategy, times(1)).modificar(pokemon, porcentaje);

        //Act
        item.usar(pokemon);

        //Assert
        verify(strategy, times(2)).modificar(pokemon, porcentaje);
    }
}
