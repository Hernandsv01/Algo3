package org.fiuba.algotres.model.estado;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.fiuba.algotres.model.Pokemon;

class EnvenenadoTest {

    @Test
    void accionar() {
        // Setup
        Envenenado envenenado = new Envenenado("Envenenado");
        Pokemon pokemon = mock(Pokemon.class);


        // Get result
        boolean fueEnvenenado = envenenado.accionar(pokemon);

        // Assert
        assertTrue(fueEnvenenado); 
    }
}