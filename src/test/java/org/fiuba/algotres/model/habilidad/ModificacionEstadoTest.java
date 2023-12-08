package org.fiuba.algotres.model.habilidad;

import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.estado.Estado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

public class ModificacionEstadoTest {
    Pokemon pokemonIgnorado;
    Pokemon pokemonEnemy;
    Estado estado;

    @BeforeEach
    public void initEach() {
        pokemonIgnorado = mock(Pokemon.class);
        pokemonEnemy = mock(Pokemon.class);
        estado = mock(Estado.class);
    }

    @Test
    public void testAccionarHabilidadSinUso() {
        //Arrange
        ModificacionEstado modif = new ModificacionEstado("modif", 0, estado);

        //Act
        boolean resultado = modif.accionarHabilidad(pokemonIgnorado, pokemonEnemy);

        //Assert
        assertEquals(false, resultado);
        assertNotEquals(true, resultado);
    }

    @Test
    public void testReduceCantidad() {
        //Arrange
        ModificacionEstado modif = new ModificacionEstado("modif", 2, estado);

        //Act
        boolean res1 = modif.accionarHabilidad(pokemonIgnorado, pokemonEnemy);

        //Assert
        assertNotEquals(2, modif.getUsos());
        assertEquals(1, modif.getUsos());
        assertNotEquals(0, modif.getUsos());
        assertEquals(true, res1);

        //Act
        boolean res2 = modif.accionarHabilidad(pokemonIgnorado, pokemonEnemy);

        //Assert
        assertNotEquals(1, modif.getUsos());
        assertEquals(0, modif.getUsos());
        assertNotEquals(-1, modif.getUsos());
        assertEquals(true, res2);

        //Act
        boolean res3 = modif.accionarHabilidad(pokemonIgnorado, pokemonEnemy);

        //Assert
        assertEquals(0, modif.getUsos());
        assertNotEquals(-1, modif.getUsos());
        assertEquals(false, res3);
    }

    @Test
    public void testAccionaSobreEnemigo() {
        //Arrange
        ModificacionEstado modif = new ModificacionEstado("modif", 2, estado);

        //Act & Assert
        boolean res1 = modif.accionarHabilidad(pokemonIgnorado, pokemonEnemy);
        verify(pokemonEnemy, times(1)).agregarEstado(estado);
        assertEquals(true, res1);

        //Act & Assert
        boolean res2 = modif.accionarHabilidad(pokemonIgnorado, pokemonEnemy);
        verify(pokemonEnemy, times(2)).agregarEstado(estado);
        assertEquals(true, res2);
    }

    @Test
    public void testNoAccionaSobreIgnorado() {
        //Arrange
        ModificacionEstado modif = new ModificacionEstado("modif", 2, estado);

        //Act & Assert
        boolean res1 = modif.accionarHabilidad(pokemonIgnorado, pokemonEnemy);
        verify(pokemonIgnorado, times(0)).agregarEstado(estado);
        assertEquals(true, res1);

        //Act & Assert
        boolean res2 = modif.accionarHabilidad(pokemonIgnorado, pokemonEnemy);
        verify(pokemonIgnorado, times(0)).agregarEstado(estado);
        assertEquals(true, res2);
    }
}
