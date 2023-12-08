package org.fiuba.algotres.model;

import org.fiuba.algotres.model.tipos.Tipos;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PokemonTest {
    
    private static Pokemon pokemon;
    
    @BeforeEach
    public void setup(){
        pokemon = new Pokemon(
                "Poketest", // Nombre
                100, // Nivel
                Tipos.BICHO, // Tipo
                "El único proposito de este pokemon es ser usado como rata de laboratorio", // Historia
                100, // Vida máxima
                100, // Velocidad
                100, // Defensa
                100, // Ataque
                new ArrayList<>() // Habilidades
        );
    }

    @Test
    @Order(1)
    void testDanarPorPuntosConResultadoMayorAMinimo() {
        // Setup
        int expectedVida = 90;
        int puntosDano = 10;

        // Get result
        pokemon.danarPorPuntos(puntosDano);

        // Assert
        assertEquals(expectedVida, pokemon.getVidaActual());
    }
    @Test
    @Order(2)
    void testDanarPorPorcentajeConResultadoMayorAMinimo() {
        // Setup
        int expectedVida = 80;
        int porcentajeDano = 20;

        // Get result
        pokemon.danarPorPorcentaje(porcentajeDano);

        // Assert
        assertEquals(expectedVida, pokemon.getVidaActual());
    }

    @Test
    @Order(3)
    void testDanarPorPuntosConResultadoMenorAMinimo() {
        // Setup
        int expectedVida = 0;
        int puntosDano = 110;

        // Get result
        pokemon.danarPorPuntos(puntosDano);

        // Assert
        assertEquals(expectedVida, pokemon.getVidaActual());
    }


    @Test
    @Order(4)
    void testDanarPorPorcentajeConResultadoMenorAMinimo() {
        // Setup
        int expectedVida = 0;
        int porcentajeDano = 150;

        // Get result
        pokemon.danarPorPorcentaje(porcentajeDano);

        // Assert
        assertEquals(expectedVida, pokemon.getVidaActual());
    }


    @Test
    @Order(5)
    void testCurarPorPuntosConResultadoMenorAMaximo() {
        // Setup
        pokemon.setVidaActual(50);
        int expectedVida = 60;
        int puntosCuracion = 10;

        // Get result
        pokemon.curarPorPuntos(puntosCuracion);

        // Assert
        assertEquals(expectedVida, pokemon.getVidaActual());
    }

    @Test
    @Order(6)
    void testCurarPorPorcentajeConResultadoMenorAMaximo() {
        // Setup
        pokemon.setVidaActual(50);
        int expectedVida = 70;
        int porcentajeCuracion = 20;

        // Get result
        pokemon.curarPorPorcentaje(porcentajeCuracion);

        // Assert
        assertEquals(expectedVida, pokemon.getVidaActual());
    }

    @Test
    @Order(7)
    void testCurarPorPuntosConResultadoMayorAMaximo() {
        // Setup
        pokemon.setVidaActual(50);
        int expectedVida = 100;
        int puntosCuracion = 130;

        // Get result
        pokemon.curarPorPuntos(puntosCuracion);

        // Assert
        assertEquals(expectedVida, pokemon.getVidaActual());
    }

    @Test
    @Order(8)
    void testCurarPorPorcentajeConResultadoMayorAMaximo() {
        // Setup
        pokemon.setVidaActual(50);
        int expectedVida = 100;
        int porcentajeCuracion = 200;

        // Get result
        pokemon.curarPorPorcentaje(porcentajeCuracion);

        // Assert
        assertEquals(expectedVida, pokemon.getVidaActual());
    }

    @Test
    @Order(9)
    void testMatar() {
        // Setup
        boolean expectedEstaVivo = false;

        // Get result
        pokemon.matar();

        // Assert
        assertEquals(expectedEstaVivo, pokemon.estaVivo());
    }

    @Test
    @Order(10)
    void testModificarAtaque() {
        // Setup
        int expectedAtaque = 110;
        int porcentajeModificacion = 10;

        // Get result
        pokemon.modificarAtaque(porcentajeModificacion);

        // Assert
        assertEquals(expectedAtaque, pokemon.getAtaque());
    }

    @Test
    @Order(11)
    void testModificarDefensa() {
        // Setup
        int expectedDefensa = 110;
        int porcentajeModificacion = 10;

        // Get result
        pokemon.modificarDefensa(porcentajeModificacion);

        // Assert
        assertEquals(expectedDefensa, pokemon.getDefensa());
    }

    @Test
    @Order(12)
    void testEstaVivoConPokemonVivo() {
        // Setup
        boolean expectedEstaVivo = true;

        // Get result
        boolean estaVivo = pokemon.estaVivo();

        // Assert
        assertEquals(expectedEstaVivo, estaVivo);
    }

    @Test
    @Order(13)
    void testEstaVivoConPokemonMuerto() {
        // Setup
        boolean expectedEstaVivo = false;
        pokemon.matar();

        // Get result
        boolean estaVivo = pokemon.estaVivo();

        // Assert
        assertEquals(expectedEstaVivo, estaVivo);
    }

    @Test
    @Order(14)
    void testRevivirConPokemonMuerto() {
        // Setup
        boolean expectedEstaVivo = true;
        pokemon.matar();

        // Get result
        pokemon.revivir();

        // Assert
        assertEquals(expectedEstaVivo, pokemon.estaVivo());
    }

    @Test
    @Order(15)
    void testRevivirConPokemonVivo() {
        // Setup
        boolean expectedEstaVivo = true;

        // Get result
        pokemon.revivir();

        // Assert
        assertEquals(expectedEstaVivo, pokemon.estaVivo());
    }
}