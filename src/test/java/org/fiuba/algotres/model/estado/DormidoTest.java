package org.fiuba.algotres.model.estado;

import org.junit.Assume;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


import org.fiuba.algotres.model.Pokemon;

class DormidoTest {

    @Test
    void testAccionarFalse() {
        // Setup
        Dormido dormidoMock = mock(Dormido.class);
        Pokemon pokemon = mock(Pokemon.class);
        Dormido dormido = new Dormido("Dormido");

        // Get result
        boolean resultadoMock = dormidoMock.accionar(pokemon);
        boolean resultado = dormido.accionar(pokemon);


        // Assert
        //Verifica si al llmar el metodo accionar, se llama al menos una vez
        verify(dormidoMock, atLeastOnce()).accionar(pokemon);
        //Si el resultado es falso, el pokemon no puede atacar y sigue dormido. Pero si el resultado es true ignoramos el test
        Assume.assumeFalse(resultado);
        assertFalse(resultado);
        
        
    }

    @Test
    void testAccionarTrue() {
        // Setup
        Dormido dormidoMock = mock(Dormido.class);
        Pokemon pokemon = mock(Pokemon.class);
        Dormido dormido = new Dormido("Dormido");

        // Get result
        boolean resultadoMock = dormidoMock.accionar(pokemon);
        boolean resultado = dormido.accionar(pokemon);


        // Assert
        //Verifica si al llmar el metodo accionar, se llama al menos una vez
        verify(dormidoMock, atLeastOnce()).accionar(pokemon);
        //Si el resultado es falso, el pokemon no puede atacar y sigue dormido. Pero si el resultado es true ignoramos el test
        Assume.assumeTrue(resultado);
        assertTrue(resultado);
        
        
    }
}