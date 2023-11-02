package org.fiuba.algotres.model.habilidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;


import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.tipos.Tipos;


class AtaqueTest {
    private List<Habilidad> habilidades = List.of(
            new Ataque("Ataque DRAGON", 10, 10, Tipos.DRAGON),       
            new Ataque("Ataque NORMAL", 10, 100, Tipos.NORMAL),       
            new Ataque("Ataque AGUA", 10, 100, Tipos.AGUA),           
            new Ataque("Ataque FUEGO", 10, 100, Tipos.FUEGO),         
            new Ataque("Ataque ELECTRICO", 10, 100, Tipos.ELECTRICO) 
            
        );

        private List<Habilidad> habilidadesPokemon2 = List.of(
            new Ataque("Ataque VENENO", 10, 100, Tipos.VENENO),       
            new Ataque("Ataque TIERRA", 10, 100, Tipos.TIERRA),       
            new Ataque("Ataque HIELO", 10, 100, Tipos.HIELO),           
            new Ataque("Ataque FANTASMA", 10, 100, Tipos.FANTASMA),         
            new Ataque("Ataque BICHO", 10, 100, Tipos.BICHO) 
            
        );

    @Test
    void testAccionarHabilidad() {
        //Setup
        Pokemon atacante = new Pokemon("Pikachu", 7, Tipos.ELECTRICO,"k", 100, 100, 100, 100, habilidades);
        Pokemon victima = new Pokemon("Charmander", 7, Tipos.FUEGO,"k", 100, 100, 100, 100, habilidadesPokemon2);
        
        // Get result
        boolean resultado = habilidades.get(0).accionarHabilidad(atacante, victima);


        // Assert

        assertTrue(resultado);
       
    }
}