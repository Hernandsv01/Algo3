package org.fiuba.algotres;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Pokemon {
    private int vidaActual = (int)(Math.random()*100);
    private final int vidaMaxima = 100;
    private final int velocidad = (int)(Math.random()*100);
    private final String nombre = "nombrePokemon";

    @Override
    public String toString() {
        return nombre + " (" + vidaActual + "❤\uFE0F/" + vidaMaxima + "❤\uFE0F)";
    }
    public String getHealthString() {
        return "(" + vidaActual + "❤\uFE0F/" + vidaMaxima + "❤\uFE0F)";
    }
}
