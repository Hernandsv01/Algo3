package org.fiuba.algotres.habilidad;

import org.fiuba.algotres.*;

import java.lang.Math;
import java.util.Random;

import lombok.Getter;
import lombok.Setter;
import org.fiuba.algotres.Tipos;

@Getter @Setter
public class Ataque extends Habilidad{
    private int poder;
    private Tipos tipo;

    private final double PROBABILIDAD_CRITICO = 0.9;
    private final int MULTIPLICADOR_CRITICO = 2;
    private final double MULTIPLICADOR_MISMO_TIPO = 1.5;
    private final int DEFAULT = 1;

    private static final int MINIMO_RANDOM = 217;
    private static final int MAXIMO_RANDOM = 255;

    public Ataque(String nombre, int usos, int poder, Tipos tipo) {
        super(nombre, usos);
        this.poder = poder;
        this.tipo = tipo;
    }

    @Override
    public void accionarHabilidad(Pokemon atacante, Pokemon victima) {
        int numeradorInterno = 2 * atacante.getNivel() *  esCritico() * this.poder * (atacante.getAtaque()/victima.getDefensa());
        int fraccionCompleta = (2 + (numeradorInterno/5) )/50;
        int dano = (int)(fraccionCompleta * esMismoTipo(atacante) * getMultiplicadorEfectividad(atacante, victima) * getRandom());

        victima.setVidaActual(victima.getVidaActual() - dano);
        this.usos--;
    }

    public int esCritico(){
        double resultado = Math.random()*100;
        return resultado <= PROBABILIDAD_CRITICO ? MULTIPLICADOR_CRITICO : DEFAULT;
    }

    public double esMismoTipo(Pokemon atacante){
        return (atacante.getTipos() == tipo) ? MULTIPLICADOR_MISMO_TIPO : DEFAULT;
    }
    public double getRandom(){
        Random util = new Random();
        int numeroAleatorio = util.nextInt(MAXIMO_RANDOM-MINIMO_RANDOM) + MINIMO_RANDOM;
        return (double) numeroAleatorio / MAXIMO_RANDOM;
    }

    public double getMultiplicadorEfectividad(Pokemon atacante, Pokemon victima){
        return atacante.getTipos().getEfectividadMap().get(victima.getTipos().toBasico()).getMultiplicador();
    }
}
