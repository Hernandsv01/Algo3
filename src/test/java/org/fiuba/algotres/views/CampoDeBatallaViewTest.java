package org.fiuba.algotres.views;

import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.Jugador;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.clima.Clima;
import org.fiuba.algotres.views.terminal.CampoDeBatallaView;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
public class CampoDeBatallaViewTest {
    CampoDeBatalla cdb;
    Jugador j1;
    Jugador j2;
    Pokemon pokemon1;
    Pokemon pokemon2;
    Clima clima1;

    @Test
    public void testRecorreMetodo() {
        //Arrange
        cdb = mock();
        j1 = mock();
        j2 = mock();
        pokemon1 = mock();
        pokemon2 = mock();
        clima1 = mock();
        Jugador[] jugadores = new Jugador[2];
        jugadores[0] = j1;
        jugadores[1] = j2;

        when(cdb.getJugadores()).thenReturn(jugadores);

        when(jugadores[0].getNombre()).thenReturn("Jugador1");
        when(jugadores[1].getNombre()).thenReturn("Jugador2");

        when(jugadores[0].getPokemonActual()).thenReturn(pokemon1);
        when(jugadores[1].getPokemonActual()).thenReturn(pokemon2);

        when(pokemon1.getNombre()).thenReturn("Pokemon1");
        when(pokemon2.getNombre()).thenReturn("Pokemon2");

        when(cdb.getClima()).thenReturn(clima1);
        when(clima1.getNombre()).thenReturn("Clima1");

        when(cdb.getJugadorActual()).thenReturn(j1);
        when(j1.getNombre()).thenReturn("JugadorActual");

        //Act
        CampoDeBatallaView.imprimirCampo(cdb);

        //Assert 1
        verify(cdb, times(13)).getJugadores();
        //Recorre toda la funcion (considerando que los pokemon no tienen estados, por lo tanto no ingresa a ese for)
        // y tambien hace un ultimo checkeo si existe o no un tercer jugador

        //assert 2
        verify(jugadores[0], times(4)).getPokemonActual();
        verify(jugadores[1], times(4)).getPokemonActual();
        //Realiza la misma cantidad de llamados por cada jugador existente

        //Assert 3
        verify(clima1, times(1)).getNombre();
        //Solo se obtiene el nombre del clima para mostrarlo por pantalla
    }
}
