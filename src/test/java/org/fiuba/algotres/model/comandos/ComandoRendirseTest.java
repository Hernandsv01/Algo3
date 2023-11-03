package org.fiuba.algotres.model.comandos;

import org.fiuba.algotres.comandos.ComandoRendirse;
import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.Jugador;
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
        ComandoRendirse comandoRendirse = new ComandoRendirse("comandoRendirse");

        //Act
        boolean resultado = comandoRendirse.ejecutar(cdb);

        //Assert
        assertTrue(resultado);
    }
}
