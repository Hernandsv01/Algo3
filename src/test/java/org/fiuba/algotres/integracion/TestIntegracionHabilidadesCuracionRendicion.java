package org.fiuba.algotres.integracion;

import org.fiuba.algotres.controllers.terminal.TerminalController;
import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.Jugador;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.clima.SinClima;
import org.fiuba.algotres.model.clima.TormentaArena;
import org.fiuba.algotres.model.estado.Confuso;
import org.fiuba.algotres.model.estado.Dormido;
import org.fiuba.algotres.model.estado.Envenenado;
import org.fiuba.algotres.model.estado.Paralizado;
import org.fiuba.algotres.model.habilidad.*;
import org.fiuba.algotres.model.item.*;
import org.fiuba.algotres.model.strategies.AtaqueStrategy;
import org.fiuba.algotres.model.strategies.DefensaStrategy;
import org.fiuba.algotres.model.strategies.VidaStrategy;
import org.fiuba.algotres.model.tipos.Tipos;
import org.fiuba.algotres.views.InputUsuario;
import org.fiuba.algotres.views.terminal.InputUsuarioTerminal;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.fiuba.algotres.controllers.terminal.TerminalController.inicializarConfiguracion;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestIntegracionHabilidadesCuracionRendicion {
    private static CampoDeBatalla cdb;
    private static InputUsuario input;

    @BeforeAll
    public static void setup(){
        input = mock(InputUsuarioTerminal.class);
        when(input.obtenerCualquierDato(true)).thenReturn("");
        inicializarConfiguracion(input);

        cdb = new CampoDeBatalla();
        cdb.setJugadores(new Jugador[]{
                        new Jugador(
                                List.of(
                                        new Pokemon(
                                                "PokemonUno",
                                                100,
                                                Tipos.NORMAL,
                                                "Pokemon creado como rata de laboratorio",
                                                1000,
                                                100,
                                                100,
                                                100,
                                                generarHabilidades()
                                        )
                                ),
                                generarItems(),
                                "JugadorUno"
                        ),
                        new Jugador(
                                List.of(
                                        new Pokemon(
                                                "PokemonDos",
                                                100,
                                                Tipos.TIERRA,
                                                "Pokemon creado como rata de laboratorio (definitivamente va a sufrir más que el otro)",
                                                1000,
                                                100,
                                                100,
                                                100,
                                                generarHabilidades()
                                        )
                                ),
                                generarItems(),
                                "JugadorDos"
                        )
                }
        );
        cdb.setTurnoActual(0);
        cdb.setClima(new SinClima("Sin clima", cdb));
    }

    public static List<Habilidad> generarHabilidades(){
        return List.of(
                // Ataques contra Tierra
                new Ataque("Ataque DRAGON", 10, 100, Tipos.DRAGON),       // efectividad normal contra tierra
                new Ataque("Ataque ELECTRICO", 10, 100, Tipos.FANTASMA),  // efectividad nula contra normal

                new CambiarClima("Cambiador de clima a SinClima", 10, new SinClima("SinClima", cdb)),
                new CambiarClima("Cambiador de clima a TormentaArena", 10, new TormentaArena("TormentaArena", cdb)),

                new ModificacionEstadistica("50% menos ataque", 10, 50, new AtaqueStrategy(false)),
                new ModificacionEstadistica("50% menos Defensa", 10, 50, new DefensaStrategy(false)),
                new ModificacionEstadistica("50% menos Vida", 10, 50, new VidaStrategy()),

                new ModificacionEstado("Aplicar Envenenado", 10, new Envenenado("Envenenado")),
                new ModificacionEstado("Aplicar Paralizado", 10, new Paralizado("Paralizado")),
                new ModificacionEstado("Aplicar Dormido", 10, new Dormido("Dormido")),
                new ModificacionEstado("Aplicar Confuso", 10, new Confuso("Confuso"))
        );
    }

    public static List<Item> generarItems(){
        return List.of(
                new CuraTodo(10, "Cura todo"),

                new Estadistica(10, "50% mas ataque", 50, new AtaqueStrategy(true)),
                new Estadistica(10, "50% mas defensa", 50, new DefensaStrategy(true)),
                new Estadistica(10, "50% mas vida", 50, new VidaStrategy()),

                new Pocion(10, "Pocion 10", 10),
                new Pocion(10, "Pocion 50", 50),
                new Pocion(10, "Pocion 100", 100),

                new Revivir(10, "Revivir")
        );
    }

    @Test
    public void testIntegrador(){
        /* Primer turno: Jugador 0 ataca a jugador 1 con ataque de efectividad normal */
        when(input.obtenerOpcionUsuario(anyInt()))
                .thenReturn(1)
                .thenReturn(1);

        boolean turnoCompletado = TerminalController.turno(cdb);

        assertTrue(turnoCompletado);
        assertTrue(cdb.getJugadores()[cdb.getSiguienteTurno()].getPokemonActual().getVidaActual() < 1000);
        assertEquals(9, cdb.getJugadorActual().getPokemonActual().getHabilidades().get(0).getUsos());

        cdb.setSiguienteTurno();
        assertEquals(cdb.getJugadorActual(), cdb.getJugadores()[1]);

        //-----------------------------------------------------------------------------------------------
        /* Segundo turno: Jugador 1 ataca a jugador 0 con ataque de efectividad nula */

        when(input.obtenerOpcionUsuario(anyInt()))
                .thenReturn(1)
                .thenReturn(2);

        turnoCompletado = TerminalController.turno(cdb);

        assertTrue(turnoCompletado);
        assertEquals(1000, cdb.getJugadores()[cdb.getSiguienteTurno()].getPokemonActual().getVidaActual());
        assertEquals(9, cdb.getJugadorActual().getPokemonActual().getHabilidades().get(1).getUsos());

        cdb.setSiguienteTurno();
        assertEquals(cdb.getJugadorActual(), cdb.getJugadores()[0]);

        //-----------------------------------------------------------------------------------------------
        /* Tercer turno: Jugador 0 usa habilidad de cambio de clima a TormentaArena (hace daño a pokemon por 3% en cada turno por 5 turno */

        when(input.obtenerOpcionUsuario(anyInt()))
                .thenReturn(1)
                .thenReturn(4);

        turnoCompletado = TerminalController.turno(cdb);

        assertTrue(turnoCompletado);
        assertTrue(cdb.getClima() instanceof TormentaArena);
        assertEquals(9, cdb.getJugadorActual().getPokemonActual().getHabilidades().get(3).getUsos());

        cdb.setSiguienteTurno();

        //-----------------------------------------------------------------------------------------------
        /* Cuarto turno: Jugador 1 usa habilidad de modificación de estadística (50% menos ataque)
                Side effect: No hay daño por clima, tipo favorecido
        */

        when(input.obtenerOpcionUsuario(anyInt()))
                .thenReturn(1)
                .thenReturn(5);
        int vidaPokemonPreEfectoClima = cdb.getJugadorActual().getPokemonActual().getVidaActual();

        turnoCompletado = TerminalController.turno(cdb);

        assertTrue(turnoCompletado);
        assertEquals(50, cdb.getJugadores()[cdb.getSiguienteTurno()].getPokemonActual().getAtaque());
        assertEquals(9, cdb.getJugadorActual().getPokemonActual().getHabilidades().get(4).getUsos());
        assertEquals(vidaPokemonPreEfectoClima, cdb.getJugadorActual().getPokemonActual().getVidaActual());

        cdb.setSiguienteTurno();

        //-----------------------------------------------------------------------------------------------
        /* Quinto turno: Jugador 0 usa habilidad de modificación de estado (envenenado)
                Side effect: 30 de daño por clima
        */

        when(input.obtenerOpcionUsuario(anyInt()))
                .thenReturn(1)
                .thenReturn(8);
        vidaPokemonPreEfectoClima = cdb.getJugadorActual().getPokemonActual().getVidaActual();

        turnoCompletado = TerminalController.turno(cdb);

        assertTrue(turnoCompletado);
        assertEquals(vidaPokemonPreEfectoClima-30, cdb.getJugadorActual().getPokemonActual().getVidaActual());
        assertFalse(cdb.getJugadores()[cdb.getSiguienteTurno()].getPokemonActual().getEstados().isEmpty());
        assertEquals(cdb.getJugadores()[cdb.getSiguienteTurno()].getPokemonActual().getEstados().get(0).getNombre(), "Envenenado");

        cdb.setSiguienteTurno();

        //-----------------------------------------------------------------------------------------------
        /* Sexto turno: Jugador 1 usa item de modificacion defensa (50% más)
                Side effect: 50 de daño por envenenado
        */

        when(input.obtenerOpcionUsuario(anyInt()))
                .thenReturn(2)
                .thenReturn(3)
                .thenReturn(1);
        int vidaPokemonPreEfectoEnvenenado = cdb.getJugadorActual().getPokemonActual().getVidaActual();

        turnoCompletado = TerminalController.turno(cdb);

        assertTrue(turnoCompletado);
        assertEquals(vidaPokemonPreEfectoEnvenenado-50, cdb.getJugadorActual().getPokemonActual().getVidaActual());
        assertEquals(150, cdb.getJugadorActual().getPokemonActual().getDefensa());

        cdb.setSiguienteTurno();

        //-----------------------------------------------------------------------------------------------
        /* Septimo turno: Jugador 0 usa habilidad de cambio de clima (Sin clima)
                Side effect: 30 de daño por tormenta antes del cambio de clima
        */

        when(input.obtenerOpcionUsuario(anyInt()))
                .thenReturn(1)
                .thenReturn(3);
        vidaPokemonPreEfectoClima = cdb.getJugadorActual().getPokemonActual().getVidaActual();

        turnoCompletado = TerminalController.turno(cdb);

        assertTrue(turnoCompletado);
        assertTrue(cdb.getClima() instanceof SinClima);
        assertEquals(vidaPokemonPreEfectoClima-30, cdb.getJugadorActual().getPokemonActual().getVidaActual());

        cdb.setSiguienteTurno();

        //-----------------------------------------------------------------------------------------------
        /* Octavo turno: Jugador 1 usa item cura efectos
                Side effect: 50 de daño por envenenado aplicado antes del item
        */

        when(input.obtenerOpcionUsuario(anyInt()))
                .thenReturn(2)
                .thenReturn(1)
                .thenReturn(1);
        vidaPokemonPreEfectoEnvenenado = cdb.getJugadorActual().getPokemonActual().getVidaActual();

        turnoCompletado = TerminalController.turno(cdb);

        assertTrue(turnoCompletado);
        assertTrue(cdb.getJugadorActual().getPokemonActual().getEstados().isEmpty());
        assertEquals(vidaPokemonPreEfectoEnvenenado-50, cdb.getJugadorActual().getPokemonActual().getVidaActual());

        cdb.setSiguienteTurno();

        //-----------------------------------------------------------------------------------------------
        /* Noveno turno: Jugador 0 se rinde
                Side effect: pokemons muertos y juego termina
        */

        when(input.obtenerOpcionUsuario(anyInt()))
                .thenReturn(4);

        turnoCompletado = TerminalController.turno(cdb);

        assertTrue(turnoCompletado);
        assertFalse(cdb.getJugadorActual().getPokemonActual().estaVivo());
        assertEquals(1, cdb.getGanador());
    }
}
