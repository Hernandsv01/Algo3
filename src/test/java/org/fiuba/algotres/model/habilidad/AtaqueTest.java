package org.fiuba.algotres.model.habilidad;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;

import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.tipos.Tipos;
import org.fiuba.algotres.model.tipos.TiposPrimitivos;
import org.fiuba.algotres.model.habilidad.Ataque;
import org.fiuba.algotres.model.tipos.Efectividad;

class AtaqueTest {

    @Test
    void accionarHabilidad() {
        //Setup
        Pokemon atacante = mock(Pokemon.class);
        Pokemon victima = mock(Pokemon.class);
        Tipos   tipoAtacante = mock(Tipos.class);
        Tipos tipoVictima = mock(Tipos.class);
        Efectividad efectividad = mock(Efectividad.class);

        //Tipos tipoVictima = mock(Tipos.class);
        //Efectividad efectividad = mock(Efectividad.class);
//
        Ataque habilidadAtaque = new Ataque("Asa",2,55,tipoAtacante);
        

        when(victima.getTipos()).thenReturn(Tipos.BICHO);
        //when(Tipos.BICHO.toBasico()).thenReturn(TiposPrimitivos.BICHO);
        when(efectividad.getMultiplicador()).thenReturn(1.0f);
        when(habilidadAtaque.getMultiplicadorEfectividad(victima)).thenReturn(1.0);

        
        // Get result
        boolean resultado = habilidadAtaque.accionarHabilidad(atacante, victima);

        // Assert
       assertTrue(resultado);
       
    }
}