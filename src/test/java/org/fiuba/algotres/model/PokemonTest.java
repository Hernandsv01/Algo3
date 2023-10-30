package org.fiuba.algotres.model;

import java.util.ArrayList;
import java.util.Arrays;
import org.fiuba.algotres.model.tipos.Tipos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PokemonTest {
    
    private static Pokemon pokemon;
    
    @BeforeAll
    public static void setup(){
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
    }
    @Test
    @Order(2)
    void testDanarPorPorcentajeConResultadoMayorAMinimo() {
    }
    @Test
    @Order(3)
    void testDanarPorPuntosConResultadoMenorAMinimo() {
    }
    @Test
    @Order(4)
    void testDanarPorPorcentajeConResultadoMenorAMinimo() {
    }


    @Test
    @Order(5)
    void testCurarPorPuntosConResultadoMenorAMaximo() {
    }
    @Test
    @Order(6)
    void testCurarPorPorcentajeConResultadoMenorAMaximo() {
    }
    @Test
    @Order(7)
    void testCurarPorPuntosConResultadoMayorAMaximo() {
    }
    @Test
    @Order(8)
    void testCurarPorPorcentajeConResultadoMayorAMaximo() {
    }

    @Test
    @Order(5)
    void matar() {
    }

    @Test
    @Order(6)
    void modificarAtaque() {
    }

    @Test
    @Order(7)
    void modificarDefensa() {
    }

    @Test
    @Order(8)
    void estaVivo() {
    }

    @Test
    @Order(9)
    void revivir() {
    }
}