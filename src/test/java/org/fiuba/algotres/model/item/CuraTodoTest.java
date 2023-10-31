package org.fiuba.algotres.model.item;

import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.estado.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CuraTodoTest {

    Pokemon pokemon;

    @BeforeEach
    public void initEach() {
        pokemon = mock(Pokemon.class);
    }

    @Test
    public void testSinCantidad() {
        //Arrange
        CuraTodo item = new CuraTodo(0, "CuraTodo");

        //Act
        Boolean resultado = item.usar(pokemon);

        //Assert
        assertEquals(false, resultado);
        assertNotEquals(true, resultado);
    }

    @Test
    public void testReduceCantidad() {
        //Arrange
        CuraTodo item = new CuraTodo(2, "CuraTodo");
        List<Estado> estados = new ArrayList<>();
        //Podría haber sido cualquier Estado y cualquier cantidad de Estados.
        estados.add(new Dormido("Dormido"));
        estados.add(new Confuso("Confuso"));
        estados.add(new Paralizado("Paralizado"));
        estados.add(new Envenenado("Envenenado"));
        when(pokemon.getEstados()).thenReturn(estados);

        //Act
        Boolean res1 = item.usar(pokemon);

        //Assert
        assertNotEquals(2, item.getCantidad());
        assertEquals(1, item.getCantidad());
        assertNotEquals(0, item.getCantidad());
        assertEquals(true, res1);

        //Act
        Boolean res2 = item.usar(pokemon);

        //Assert
        assertNotEquals(2, item.getCantidad());
        assertEquals(1, item.getCantidad());
        assertNotEquals(0, item.getCantidad());
        assertEquals(false, res2); // removio los estados que existian en el ArrayList "estados".

        //Act
        Boolean res3 = item.usar(pokemon);

        //Assert
        assertEquals(1, item.getCantidad());
        assertNotEquals(-1, item.getCantidad());
        assertEquals(false, res3);
    }

    @Test
    public void testCheckeaEstadoPokemon() {
        //Arrange
        CuraTodo item = new CuraTodo(2, "CuraTodo");

        //Act
        item.usar(pokemon);

        //Assert
        verify(pokemon, times(1)).getEstados();

        //Act
        item.usar(pokemon);

        //Assert
        verify(pokemon, times(2)).getEstados();
    }
}