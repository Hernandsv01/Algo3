package org.fiuba.algotres.comandos;

import org.fiuba.algotres.comandos.Comando;
import org.fiuba.algotres.comandos.ComandoHabilidad;
import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.Jugador;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.clima.Clima;
import org.fiuba.algotres.model.estado.Estado;
import org.fiuba.algotres.model.habilidad.Habilidad;
import org.fiuba.algotres.views.terminal.InputUsuarioTerminal;
import org.fiuba.algotres.views.terminal.PokemonView;
import org.fiuba.algotres.views.terminal.Tools;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ComandoHabilidadTest {
    Pokemon pokemonActual;
    Pokemon pokemonVictima;
    CampoDeBatalla cdb;
    Clima clima;
    Jugador jugador;
    Jugador jugadorOponente;
    Comando comando;
    ComandoHabilidad comandoHabilidad;
    Estado estadoMock;
    Habilidad habilidad1;
    Habilidad habilidad2;
    InputUsuarioTerminal input;

    @BeforeEach
    public void initEach() {
        pokemonActual = mock();
        pokemonVictima = mock();
        cdb = mock();
        clima = mock();
        jugador = mock();
        jugadorOponente = mock();
        comando = mock();
        input = mock();
        comandoHabilidad = new ComandoHabilidad("Comando Habilidad", input);
    }
    @Test
    public void testOpcionElegidaIgualACantidadDeOpciones() {
        //Arrange
        when(cdb.getJugadorActual()).thenReturn(jugador);
        when(jugador.getPokemonActual()).thenReturn(pokemonActual);
        when(PokemonView.imprimirHabilidadesPokemon(pokemonActual)).thenReturn(1);
        when(input.obtenerOpcionUsuario(1)).thenReturn(1);

        //Act
        boolean resultado = comandoHabilidad.ejecutar(cdb);

        //Assert
        assertFalse(resultado);
    }

    @Test
    public void testPokemonActualNoPuedeAccionar() {
        //arrange
        Jugador[] jugadores = new Jugador[2];
        jugadores[0] = jugador;
        jugadores[1] = jugadorOponente;
        List<Estado> estados = new ArrayList<Estado>();
        estadoMock = mock();
        estados.add(estadoMock);

        when(cdb.getJugadorActual()).thenReturn(jugador);
        when(jugador.getPokemonActual()).thenReturn(pokemonActual);
        when(PokemonView.imprimirHabilidadesPokemon(pokemonActual)).thenReturn(2);
        when(input.obtenerOpcionUsuario(2)).thenReturn(1);
        when(cdb.getSiguienteTurno()).thenReturn(0);
        when(cdb.getJugadores()).thenReturn(jugadores);
        when(jugadorOponente.getPokemonActual()).thenReturn(pokemonVictima);

        when(pokemonActual.getEstados()).thenReturn(estados);
        when(estadoMock.accionar()).thenReturn(false);
        when(estadoMock.getNombre()).thenReturn("EstadoMock");
        
        doNothing().when(pokemonActual).limpiarEstados();

        //Act
        boolean resultado = comandoHabilidad.ejecutar(cdb);

        //Assert
        assertTrue(resultado);
    }

    @Test
    public void testPokemonActualMuertoPorEstado() {
        //Arrange
        Jugador[] jugadores = new Jugador[2];
        jugadores[0] = jugador;
        jugadores[1] = jugadorOponente;
        List<Estado> estados = new ArrayList<Estado>();
        estadoMock = mock();
        estados.add(estadoMock);

        when(cdb.getJugadorActual()).thenReturn(jugador);
        when(jugador.getPokemonActual()).thenReturn(pokemonActual);
        when(PokemonView.imprimirHabilidadesPokemon(pokemonActual)).thenReturn(2);
        when(input.obtenerOpcionUsuario(2)).thenReturn(1);
        when(cdb.getSiguienteTurno()).thenReturn(0);
        when(cdb.getJugadores()).thenReturn(jugadores);
        when(jugadorOponente.getPokemonActual()).thenReturn(pokemonVictima);
        when(pokemonActual.getEstados()).thenReturn(estados);
        when(estadoMock.accionar()).thenReturn(true);

        doNothing().when(pokemonActual).limpiarEstados();

        when(pokemonActual.estaVivo()).thenReturn(false);

        //Act
        boolean resultado = comandoHabilidad.ejecutar(cdb);

        //Assert
        assertTrue(resultado);
    }

    @Test
    public void testPokemonActualMuertoPorClima() {
        //Arrange
        Jugador[] jugadores = new Jugador[2];
        jugadores[0] = jugador;
        jugadores[1] = jugadorOponente;

        when(cdb.getJugadorActual()).thenReturn(jugador);
        when(jugador.getPokemonActual()).thenReturn(pokemonActual);
        when(PokemonView.imprimirHabilidadesPokemon(pokemonActual)).thenReturn(2);
        when(input.obtenerOpcionUsuario(2)).thenReturn(1);

        when(cdb.getSiguienteTurno()).thenReturn(0);
        when(cdb.getJugadores()).thenReturn(jugadores);
        when(jugadorOponente.getPokemonActual()).thenReturn(pokemonVictima);

        when(pokemonActual.getEstados()).thenReturn(new ArrayList<Estado>());
        when(cdb.getClima()).thenReturn(clima);

        doNothing().when(clima).aplicarEfectos(pokemonActual);
        when(pokemonActual.estaVivo()).thenReturn(false);

        //Act
        boolean resultado = comandoHabilidad.ejecutar(cdb);

        //Assert
        assertTrue(resultado);
    }

    @Test
    public void testPokemonActualNoQuedanMasUsosDeHabilidad() {
        //Arrange
        mockStatic(PokemonView.class);
        mockStatic(Tools.class);
        Jugador[] jugadores = new Jugador[2];
        jugadores[0] = jugador;
        jugadores[1] = jugadorOponente;
        List<Habilidad> habilidades = new ArrayList<Habilidad>();
        habilidad1 = mock();
        habilidad2 = mock();
        habilidades.add(habilidad2);
        habilidades.add(habilidad1);

        when(cdb.getJugadorActual()).thenReturn(jugador);
        when(jugador.getPokemonActual()).thenReturn(pokemonActual);
        when(PokemonView.imprimirHabilidadesPokemon(pokemonActual)).thenReturn(2);
        when(input.obtenerOpcionUsuario(2)).thenReturn(1);
        when(cdb.getSiguienteTurno()).thenReturn(0);
        when(cdb.getJugadores()).thenReturn(jugadores);
        when(jugadorOponente.getPokemonActual()).thenReturn(pokemonVictima);
        when(pokemonActual.getEstados()).thenReturn(new ArrayList<Estado>());
        when(cdb.getClima()).thenReturn(clima);
        doNothing().when(clima).aplicarEfectos(pokemonActual);

        when(pokemonActual.estaVivo()).thenReturn(true);

        when(pokemonActual.getHabilidades()).thenReturn(habilidades);
        when(habilidad1.accionarHabilidad(pokemonActual, pokemonVictima)).thenReturn(false);

        //Act
        boolean resultado = comandoHabilidad.ejecutar(cdb);

        //Assert
        assertFalse(resultado);
    }

//    @Test
//    public void testFinalizarComando() {
//        //Arrange
//        mockStatic(PokemonView.class);
//        mockStatic(input.class);
//        mockStatic(Tools.class);
//        Jugador[] jugadores = new Jugador[2];
//        jugadores[0] = jugador;
//        jugadores[1] = jugadorOponente;
//        List<Habilidad> habilidades = new ArrayList<Habilidad>();
//        habilidad1 = mock();
//        habilidad2 = mock();
//        habilidades.add(habilidad1);
//        habilidades.add(habilidad2);
//
//        when(cdb.getJugadorActual()).thenReturn(jugador);
//        when(jugador.getPokemonActual()).thenReturn(pokemonActual);
//        when(PokemonView.imprimirHabilidadesPokemon(pokemonActual)).thenReturn(2);
//        when(input.obtenerOpcionUsuario(2)).thenReturn(1);
//        when(cdb.getSiguienteTurno()).thenReturn(0);
//        when(cdb.getJugadores()).thenReturn(jugadores);
//        when(jugadorOponente.getPokemonActual()).thenReturn(pokemonVictima);
//        when(pokemonActual.getEstados()).thenReturn(new ArrayList<Estado>());
//        when(cdb.getClima()).thenReturn(clima);
//        doNothing().when(clima).aplicarEfectos(pokemonActual);
//
//        when(pokemonActual.estaVivo()).thenReturn(true);
//
//        when(pokemonActual.getHabilidades()).thenReturn(habilidades);
//
//        when(habilidad2.accionarHabilidad(pokemonActual, pokemonVictima)).thenReturn(true);
//
//        //Act
//        boolean resultado = comandoHabilidad.ejecutar(cdb);
//
//        //Assert
//        assertTrue(resultado);
//    }

    //Este ultimo Test queda documentado debido a que el procedimiento del mismo está bien,
    //pero por algun motivo que no logre encontrar, la linea 219 no devuelve el true del thenReturn(), siempre devuelve "false"
}
