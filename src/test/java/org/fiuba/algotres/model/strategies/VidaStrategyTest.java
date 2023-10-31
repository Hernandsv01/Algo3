package org.fiuba.algotres.model.strategies;

import org.fiuba.algotres.model.Pokemon;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class VidaStrategyTest {
    @Test
    public void testLlamaModificar() {
        //Arrange
        Pokemon pokemon = mock(Pokemon.class);
        Strategy strategy = new VidaStrategy();
        int porcentaje = 10;

        //Act
        strategy.modificar(pokemon, porcentaje);

        //Assert
        verify(pokemon, times(1)).curarPorPorcentaje(porcentaje);

        //Act
        strategy.modificar(pokemon, porcentaje);

        //Assert
        verify(pokemon, times(2)).curarPorPorcentaje(porcentaje);
    }
}
