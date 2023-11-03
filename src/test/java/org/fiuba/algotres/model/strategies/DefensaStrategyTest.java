package org.fiuba.algotres.model.strategies;

import org.fiuba.algotres.model.Pokemon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DefensaStrategyTest {
    @Test
    public void testLlamaModificarConEfectoPositivo() {
        //Arrange
        Pokemon pokemon = mock(Pokemon.class);
        Strategy strategy = new DefensaStrategy(true);
        int porcentaje = 10;

        //Act
        strategy.modificar(pokemon, porcentaje);

        //Assert
        verify(pokemon, times(1)).modificarDefensa(porcentaje);

        //Act
        strategy.modificar(pokemon, porcentaje);

        //Assert
        verify(pokemon, times(2)).modificarDefensa(porcentaje);

        //Assert
        assertEquals(true, strategy.esPositivo());
    }

    @Test
    public void testLlamaModificarSinEfectoPositivo() {
        //Arrange
        Pokemon pokemon = mock(Pokemon.class);
        Strategy strategy = new DefensaStrategy(false);
        int porcentaje = 10;

        //Act
        strategy.modificar(pokemon, porcentaje);

        //Assert
        verify(pokemon, times(1)).modificarDefensa(-porcentaje);

        //Act
        strategy.modificar(pokemon, porcentaje);

        //Assert
        verify(pokemon, times(2)).modificarDefensa(-porcentaje);

        //Assert
        assertEquals(false, strategy.esPositivo());
    }
}
