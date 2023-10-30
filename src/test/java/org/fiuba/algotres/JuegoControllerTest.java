package org.fiuba.algotres;

import java.util.List;

import org.fiuba.algotres.model.*;
import org.fiuba.algotres.model.habilidad.*;
import org.fiuba.algotres.model.item.*;
import org.fiuba.algotres.model.clima.*;
import org.fiuba.algotres.model.estado.*;
import org.fiuba.algotres.model.strategies.*;
import org.fiuba.algotres.model.tipos.*;
import org.fiuba.algotres.comandos.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JuegoControllerTest {
    private static CampoDeBatalla cdb;
    private static List<Habilidad> habilidades;
    private static List<Item> items;
    
    @BeforeEach
    public static void setInitialPokemonValues(){
        cdb = new CampoDeBatalla(
            new Jugador[]{
                new Jugador(
                    List.of(
                        new Pokemon("PokemonUno", 100, Tipos.NORMAL, "Pokemon creado como rata de laboratorio", 100, 100, 100, 100, habilidades)
                    ),
                    items,
                    "JugadorUno"
                ),
                new Jugador(
                    List.of(
                        new Pokemon("PokemonDos", 100, Tipos.TIERRA, "Pokemon creado como rata de laboratorio (definitivamente va a sufrir más que el otro)", 100, 100, 100, 100, null)
                    ),
                    null,
                    "JugadorDos"
                )
            }
        );
    }
    
    @BeforeAll
    public static void setupHabilidades(){
        habilidades = List.of(
            // Ataques contra Tierra
            new Ataque("Ataque NORMAL", 10, 100, Tipos.NORMAL),       // x1 <- mismo tipo atacante
            new Ataque("Ataque DRAGON", 10, 100, Tipos.DRAGON),       // x1 <- diferente tipo atacante
            new Ataque("Ataque AGUA", 10, 100, Tipos.AGUA),           // x2
            new Ataque("Ataque FUEGO", 10, 100, Tipos.FUEGO),         // x1/2
            new Ataque("Ataque ELECTRICO", 10, 100, Tipos.ELECTRICO), // x0
            
            new CambiarClima("Cambiador de clima a SinClima", 10, new SinClima("SinClima", cdb)),
            new CambiarClima("Cambiador de clima a Soleado", 10, new Soleado("Soleado", cdb)),
            new CambiarClima("Cambiador de clima a Huracan", 10, new Huracan("Huracan", cdb)),
            new CambiarClima("Cambiador de clima a Lluvia", 10, new Lluvia("Lluvia", cdb)),
            new CambiarClima("Cambiador de clima a Niebla", 10, new Niebla("Niebla", cdb)),
            new CambiarClima("Cambiador de clima a TormentaArena", 10, new TormentaArena("TormentaArena", cdb)),
            new CambiarClima("Cambiador de clima a TormentaRayos", 10, new TormentaRayos("TormentaRayos", cdb)),
            
            new ModificacionEstadistica("50% menos ataque", 10, 50, new AtaqueStrategy()),
            new ModificacionEstadistica("50% menos Defensa", 10, 50, new DefensaStrategy()),
            new ModificacionEstadistica("50% menos Vida", 10, 50, new VidaStrategy()),
            
            new ModificacionEstado("Aplicar Envenenado", 10, new Envenenado("Envenenado")),
            new ModificacionEstado("Aplicar Paralizado", 10, new Paralizado("Paralizado")),
            new ModificacionEstado("Aplicar Dormido", 10, new Dormido("Dormido")),
            new ModificacionEstado("Aplicar Confuso", 10, new Confuso("Confuso"))
        );
    }
    
    @BeforeAll
    public static void setupItems(){
        items = List.of(
            new CuraTodo(10, "Cura todo"),
            
            new Estadistica(10, "50% mas ataque", 50, new AtaqueStrategy()),
            new Estadistica(10, "50% mas defensa", 50, new DefensaStrategy()),
            new Estadistica(10, "50% mas vida", 50, new VidaStrategy()),
            
            new Pocion(10, "Pocion", 10),
            new Pocion(10, "Pocion", 50),
            new Pocion(10, "Pocion", 100),
            
            new Revivir(10, "Revivir")
        );
    }
    
}
