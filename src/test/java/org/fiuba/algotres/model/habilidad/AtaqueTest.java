package org.fiuba.algotres.model.habilidad;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.tipos.Tipos;

class AtaqueTest {

    @Test
    void testAtaqueNormal() {
        Ataque habilidadAtaque = new Ataque("Ataque de prueba",10,100, Tipos.NORMAL);
        Pokemon atacante = mock(Pokemon.class);
        Pokemon victima = mock(Pokemon.class);

        when(atacante.getNivel()).thenReturn(100);
        when(atacante.getAtaque()).thenReturn(100);
        when(atacante.getTipos()).thenReturn(Tipos.VOLADOR);
        when(victima.getDefensa()).thenReturn(100);
        when(victima.getTipos()).thenReturn(Tipos.PLANTA);
        
        // Get result
        boolean operacionExitosa = habilidadAtaque.accionarHabilidad(atacante, victima);

        // Assert
       assertTrue(operacionExitosa);
       verify(victima, times(1)).danarPorPuntos(anyInt());
       assertEquals(9, habilidadAtaque.getUsos());
    }
}