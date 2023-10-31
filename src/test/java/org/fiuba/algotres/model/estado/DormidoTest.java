package org.fiuba.algotres.model.estado;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.fiuba.algotres.model.Pokemon;

class DormidoTest {

    @Test
    void accionar() {
        // Setup
        Pokemon pokemon = mock(Pokemon.class);
        Dormido dormido = new Dormido("Dormido");
        Math matematicas = mock(Math.class);
        Random util = new Random();
        Random aaa = mock(Random.class);
        //dormido.accionar(pokemon);

        // Get result
        when(aaa.nextDouble()).thenReturn(0.1);

        // Llamamos al método accionar
        boolean resultado = dormido.accionar(pokemon);

        // Assert
        assertFalse(resultado);
    }


    @Test
    void accionarTest() {
        // Setup
        Pokemon pokemon = mock(Pokemon.class);
        Dormido dormido = new Dormido("Dormido");
        Math matematicas = mock(Math.class);
        Random util = new Random();
        Random aaa = mock(Random.class);
        int aleatorio = util.nextInt(100);
        //dormido.accionar(pokemon);

        // Get result
        when(aaa.nextDouble()).thenReturn(0.9);

        // Llamamos al método accionar
        boolean resultado = dormido.accionar(pokemon);

        // Assert
        assertFalse(resultado);
    }
}