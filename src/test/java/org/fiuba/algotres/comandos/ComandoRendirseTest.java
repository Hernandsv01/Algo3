package org.fiuba.algotres.comandos;

import org.fiuba.algotres.views.terminal.comandos.ComandoRendirse;
import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.Jugador;
import org.fiuba.algotres.views.terminal.InputUsuarioTerminal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ComandoRendirseTest {
    @Test
    public void testRendirse() {
        //Arrange
        CampoDeBatalla cdb = mock();
        Jugador jugador = mock();
        when(cdb.getJugadorActual()).thenReturn(jugador);
        doNothing().when(jugador).rendirse();
        InputUsuarioTerminal input = mock();
        ComandoRendirse comandoRendirse = new ComandoRendirse("Comando Rendirse", input);

        //Act
        boolean resultado = comandoRendirse.ejecutar(cdb);

        //Assert
        assertTrue(resultado);
    }
}
