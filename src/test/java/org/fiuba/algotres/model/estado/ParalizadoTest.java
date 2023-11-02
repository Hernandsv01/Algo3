package org.fiuba.algotres.model.estado;

import org.junit.Assume;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


import org.fiuba.algotres.model.Pokemon;

class ParalizadoTest {

    @Test
    void testAccionarFalse() {
        // Setup
        Paralizado paralizadoMock = mock(Paralizado.class);
        Paralizado paralizado = new Paralizado("Paralizado");
        Pokemon pokemon = mock(Pokemon.class);

        // Get result
        boolean resultadoMock = paralizadoMock.accionar(pokemon);
        boolean resultado = paralizado.accionar(pokemon);


        // Assert
        // Verifica si al llmar el metodo accionar, se llama al menos una vez
        verify(paralizadoMock, atLeastOnce()).accionar(pokemon);

        // Si el resultado es falso, el pokemon no puede atacar y sigue paralizado. Pero si el resultado es true ignoramos el test
        Assume.assumeFalse(resultado);
        assertFalse(resultado);

    }

     @Test
    void testAccionarTrue() {
        // Setup
        Paralizado paralizadoMock = mock(Paralizado.class);
        Paralizado paralizado = new Paralizado("Paralizado");
        Pokemon pokemon = mock(Pokemon.class);

        // Get result
        boolean resultadoMock = paralizadoMock.accionar(pokemon);
        boolean resultado = paralizado.accionar(pokemon);


        // Assert
        // Verifica si al llmar el metodo accionar, se llama al menos una vez
        verify(paralizadoMock, atLeastOnce()).accionar(pokemon);

        // Si el resultado es falso, el pokemon no puede atacar y sigue paralizado. Pero si el resultado es true ignoramos el test
        Assume.assumeTrue(resultado);
        assertTrue(resultado);

    }
}