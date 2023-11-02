package org.fiuba.algotres.model.habilidad;

import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.strategies.Strategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ModificacionEstadisticaTest {
    Pokemon pokemonUser;
    Pokemon pokemonEnemy;
    Strategy strategy;
    int porcentaje;

    @BeforeEach
    public void initEach() {
        pokemonUser = mock(Pokemon.class);
        pokemonEnemy = mock(Pokemon.class);
        strategy = mock(Strategy.class);
        porcentaje = 10;
    }

    @Test
    public void testAccionarHabilidadSinUso() {
        //Arrange
        ModificacionEstadistica modif = new ModificacionEstadistica("modif", 0, porcentaje, strategy);

        //Act
        boolean resultado = modif.accionarHabilidad(pokemonUser, pokemonEnemy);

        //Assert
        assertEquals(false, resultado);
        assertNotEquals(true, resultado);
    }

    @Test
    public void testReduceCantidad() {
        //Arrange
        ModificacionEstadistica modif = new ModificacionEstadistica("modif", 2, porcentaje, strategy);

        //Act
        boolean res1 = modif.accionarHabilidad(pokemonUser, pokemonEnemy);

        //Assert
        assertNotEquals(2, modif.getUsos());
        assertEquals(1, modif.getUsos());
        assertNotEquals(0, modif.getUsos());
        assertEquals(true, res1);

        //Act
        boolean res2 = modif.accionarHabilidad(pokemonUser, pokemonEnemy);

        //Assert
        assertNotEquals(1, modif.getUsos());
        assertEquals(0, modif.getUsos());
        assertNotEquals(-1, modif.getUsos());
        assertEquals(true, res2);

        //Act
        boolean res3 = modif.accionarHabilidad(pokemonUser, pokemonEnemy);

        //Assert
        assertEquals(0, modif.getUsos());
        assertNotEquals(-1, modif.getUsos());
        assertEquals(false, res3);
    }

    @Test
    public void testAccionaSobreEnemigo() {
        //Arrange
        ModificacionEstadistica modif = new ModificacionEstadistica("modif", 2, porcentaje, strategy);
        when(strategy.esPositivo()).thenReturn(false);

        //Act & Assert
        boolean res1 = modif.accionarHabilidad(pokemonUser, pokemonEnemy);
        verify(strategy, times(1)).esPositivo();
        verify(strategy, times(1)).modificar(pokemonEnemy, -porcentaje);
        assertEquals(true, res1);

        //Act & Assert
        boolean res2 = modif.accionarHabilidad(pokemonUser, pokemonEnemy);
        verify(strategy, times(2)).esPositivo();
        verify(strategy, times(2)).modificar(pokemonEnemy, -porcentaje);
        assertEquals(true, res2);
    }

    @Test
    public void testAccionaSobreSiMismo() {
        //Arrange
        ModificacionEstadistica modif = new ModificacionEstadistica("modif", 2, porcentaje, strategy);
        when(strategy.esPositivo()).thenReturn(true);

        //Act & Assert
        boolean res1 = modif.accionarHabilidad(pokemonUser, pokemonUser);
        verify(strategy, times(1)).esPositivo();
        verify(strategy, times(1)).modificar(pokemonUser, porcentaje);
        assertEquals(true, res1);

        //Act & Assert
        boolean res2 = modif.accionarHabilidad(pokemonUser, pokemonUser);
        verify(strategy, times(2)).esPositivo();
        verify(strategy, times(2)).modificar(pokemonUser, porcentaje);
        assertEquals(true, res2);

    }
}
