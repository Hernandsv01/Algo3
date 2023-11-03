package org.fiuba.algotres;

import org.fiuba.algotres.comandos.*;
import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.Jugador;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.clima.Clima;
import org.fiuba.algotres.views.InputUsuario;
import org.fiuba.algotres.views.terminal.InputUsuarioTerminal;
import org.junit.jupiter.api.*;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JuegoControllerTest {
    private static InputUsuario input;

    @BeforeAll
    public static void setup(){
        input = mock(InputUsuarioTerminal.class);
    }

    @Test
    @Order(1)
    void testInicializarConfiguracion() {
        JuegoController.inicializarConfiguracion(input);

        assertEquals(input, JuegoController.getInput());
        assertNotNull(JuegoController.getComandos());
    }

    @Test
    @Order(2)
    void testSetupInicial() {
        CampoDeBatalla cdb = mock(CampoDeBatalla.class);

        when(cdb.getJugadores()).thenReturn(new Jugador[]{mock(Jugador.class), mock(Jugador.class)});
        when(cdb.getClima()).thenReturn(mock(Clima.class));
        when(cdb.getClima().getNombre()).thenReturn("Clima de prueba");
        when(cdb.getJugadores()[0].getPokemonActual()).thenReturn(mock(Pokemon.class));
        when(cdb.getJugadores()[1].getPokemonActual()).thenReturn(mock(Pokemon.class));
        when(cdb.getJugadores()[0].getPokemonActual().getNombre()).thenReturn("Pokemon de prueba");
        when(cdb.getJugadores()[1].getPokemonActual().getNombre()).thenReturn("Pokemon de prueba");

        when(input.obtenerCualquierDato(false))
                .thenReturn("Sujeto de prueba")
                .thenReturn("Sujeto de prueba");
        when(input.obtenerOpcionUsuario(anyInt()))
                .thenReturn(1)
                .thenReturn(1);
        when(input.obtenerCualquierDato(true))
                .thenReturn("")
                .thenReturn("");

        JuegoController.setupInicial(cdb);

        verify(cdb.getJugadores()[0], times(1)).setNombre(any());
        verify(cdb.getJugadores()[0], times(1)).setNombre(any());
        verify(cdb.getJugadores()[1], times(1)).cambiarPokemonActual(0);
        verify(cdb.getJugadores()[1], times(1)).cambiarPokemonActual(0);
    }


    @Test
    @Order(3)
    void testTurno() {
        CampoDeBatalla cdb = mock(CampoDeBatalla.class);
        JuegoController.setComandos(new HashMap<>(){{
            put(1, mock(Comando.class));
        }});

        when(JuegoController.getComandos().get(1).ejecutar(cdb)).thenReturn(true);
        when(cdb.getJugadores()).thenReturn(new Jugador[]{});
        when(cdb.getClima()).thenReturn(mock(Clima.class));
        when(cdb.getClima().getNombre()).thenReturn("Clima de prueba");
        when(cdb.getJugadorActual()).thenReturn(mock(Jugador.class));
        when(cdb.getJugadorActual().getNombre()).thenReturn("Jugador de prueba");

        JuegoController.turno(cdb);

        verify(JuegoController.getComandos().get(1), times(1)).ejecutar(cdb);
    }
}