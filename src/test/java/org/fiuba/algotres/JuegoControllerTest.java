package org.fiuba.algotres;

import java.util.List;
import static org.fiuba.algotres.JuegoController.inicializarConfiguracion;

import org.fiuba.algotres.model.*;
import org.fiuba.algotres.model.habilidad.*;
import org.fiuba.algotres.model.item.*;
import org.fiuba.algotres.model.clima.*;
import org.fiuba.algotres.model.estado.*;
import org.fiuba.algotres.model.strategies.*;
import org.fiuba.algotres.model.tipos.*;
import org.fiuba.algotres.comandos.*;
import org.fiuba.algotres.views.InputUsuario;
import org.fiuba.algotres.views.terminal.InputUsuarioTerminal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JuegoControllerTest {
    private static CampoDeBatalla cdb;
    private static InputUsuario input;
    
    @BeforeEach
    public void setup(){
        input = mock(InputUsuarioTerminal.class);
        when(input.obtenerCualquierDato(true)).thenReturn("");
        inicializarConfiguracion(input);
        
        cdb = new CampoDeBatalla(
            new Jugador[]{
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
                                null
                        )
                    ),
                    null,
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
                                null
                        )
                    ),
                    null,
                    "JugadorDos"
                )
            }
        );
        cdb.setTurnoActual(0);
        cdb.getJugadores()[0].setItems(generarItems());
        cdb.getJugadores()[1].setItems(generarItems());
        cdb.getJugadores()[0].getPokemons().get(0).setHabilidades(generarHabilidades());
        cdb.getJugadores()[1].getPokemons().get(0).setHabilidades(generarHabilidades());
    }
    
    public static List generarHabilidades(){
        return List.of(
            // Ataques contra Tierra
            new Ataque("Ataque DRAGON", 10, 100, Tipos.DRAGON),       // efectividad normal contra tierra
            new Ataque("Ataque ELECTRICO", 10, 100, Tipos.FANTASMA),  // efectividad nula contra normal
            
            new CambiarClima("Cambiador de clima a SinClima", 10, new SinClima("SinClima", cdb)),
            new CambiarClima("Cambiador de clima a TormentaArena", 10, new TormentaArena("TormentaArena", cdb)),
            
            new ModificacionEstadistica("50% menos ataque", 10, 50, new AtaqueStrategy()),
            new ModificacionEstadistica("50% menos Defensa", 10, 50, new DefensaStrategy()),
            new ModificacionEstadistica("50% menos Vida", 10, 50, new VidaStrategy()),
            
            new ModificacionEstado("Aplicar Envenenado", 10, new Envenenado("Envenenado")),
            new ModificacionEstado("Aplicar Paralizado", 10, new Paralizado("Paralizado")),
            new ModificacionEstado("Aplicar Dormido", 10, new Dormido("Dormido")),
            new ModificacionEstado("Aplicar Confuso", 10, new Confuso("Confuso"))
        );
    }
    
    public static List generarItems(){
        return List.of(
            new CuraTodo(10, "Cura todo"),
            
            new Estadistica(10, "50% mas ataque", 50, new AtaqueStrategy()),
            new Estadistica(10, "50% mas defensa", 50, new DefensaStrategy()),
            new Estadistica(10, "50% mas vida", 50, new VidaStrategy()),
            
            new Pocion(10, "Pocion 10", 10),
            new Pocion(10, "Pocion 50", 50),
            new Pocion(10, "Pocion 100", 100),
            
            new Revivir(10, "Revivir")
        );
    }
    
    @Test
    @Order(1)
    public void testIntegradorAtaquesCuracionYRendicion(){
        // Primer turno: Jugador 0 ataca a jugador 1 con ataque de efectividad normal
        when(input.obtenerOpcionUsuario(anyInt()))
                .thenReturn(1) // Usar una habilidad
                .thenReturn(1); // Usar habilidad 1 (Ataque tipo dragon, efectividad normal)
        
        boolean turnoCompletado = JuegoController.turno(cdb);
        
        assertTrue(turnoCompletado);
        assertTrue(cdb.getJugadores()[cdb.getSiguienteTurno()].getPokemonActual().getVidaActual() < 1000);
        assertEquals(9, cdb.getJugadorActual().getPokemonActual().getHabilidades().get(0).getUsos());
        
        cdb.setSiguienteTurno();
        assertEquals(cdb.getJugadorActual(), cdb.getJugadores()[1]);
        
        //-----------------------------------------------------------------------------------------------
        // Segundo turno: Jugador 1 ataca a jugador 0 con ataque de efectividad nula
        when(input.obtenerOpcionUsuario(anyInt()))
                .thenReturn(1) // Usar una habilidad
                .thenReturn(2); // Usar habilidad 2 (Ataque tipo fantasma, efectividad nula)
        
        turnoCompletado = JuegoController.turno(cdb);
        
        assertTrue(turnoCompletado);
        assertEquals(1000, cdb.getJugadores()[cdb.getSiguienteTurno()].getPokemonActual().getVidaActual());
        assertEquals(9, cdb.getJugadorActual().getPokemonActual().getHabilidades().get(1).getUsos());
        
        cdb.setSiguienteTurno();
        assertEquals(cdb.getJugadorActual(), cdb.getJugadores()[0]);
        
        //-----------------------------------------------------------------------------------------------
        // Tercer turno: Jugador 0 usa habilidad de cambio de clima a TormentaArena (hace daño a pokemon por 3% en cada turno por 5 turnos)
        
        when(input.obtenerOpcionUsuario(anyInt()))
                .thenReturn(1) // Usar una habilidad
                .thenReturn(4); // Usar habilidad 4 (Cambio a clima TormentaArena)
        
        turnoCompletado = JuegoController.turno(cdb);
        
        assertTrue(turnoCompletado);
        assertTrue(cdb.getClima() instanceof TormentaArena);
        assertEquals(9, cdb.getJugadorActual().getPokemonActual().getHabilidades().get(3).getUsos());
        
        cdb.setSiguienteTurno();
        
        //-----------------------------------------------------------------------------------------------
        // Cuarto turno: Jugador 1 usa habilidad de modificación de estadística (50% menos ataque)
        
//        when(input.obtenerOpcionUsuario(anyInt()))
//                .thenReturn(1) // Usar una habilidad
//                .thenReturn(5); // Usar habilidad 5 (modificación de estadística (ataque))
//        int vidaPokemonUnoPreEfectoClima = cdb.getJugadorActual().getPokemonActual().getVidaActual();
//        int vidaPokemonDosPreEfectoClima = cdb.getJugadores()[cdb.getSiguienteTurno()].getPokemonActual().getVidaActual();
//        
//        turnoCompletado = JuegoController.turno(cdb);
//        
//        assertTrue(turnoCompletado);
//        assertEquals(50, cdb.getJugadores()[cdb.getSiguienteTurno()].getPokemonActual().getAtaque());
//        assertEquals(9, cdb.getJugadorActual().getPokemonActual().getHabilidades().get(4).getUsos());
        
        
        
        
        
        
        
        
        
        
        
    }
}
