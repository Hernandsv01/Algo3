package org.fiuba.algotres.model.habilidad;

import lombok.Getter;
import lombok.Setter;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.tipos.Tipos;

import java.util.Random;

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
    public boolean accionarHabilidad(Pokemon atacante, Pokemon victima) {
        if (verificarUsos(usos)) {
            double numeradorInterno = 2 * atacante.getNivel() * esCritico() * this.poder * ((double) atacante.getAtaque() / (double) victima.getDefensa());
            double fraccionCompleta = (2 + (numeradorInterno / 5)) / 50;
            int dano = (int) (fraccionCompleta * esMismoTipo(atacante) * getMultiplicadorEfectividad(victima) * getRandom());

            victima.danarPorPuntos(dano);
            usos--;
            return true;
        }
        return false;
    }

    private int esCritico(){
        double resultado = Math.random()*100;
        return resultado <= PROBABILIDAD_CRITICO ? MULTIPLICADOR_CRITICO : DEFAULT;
    }

    private double esMismoTipo(Pokemon atacante){
        return (atacante.getTipos() == tipo) ? MULTIPLICADOR_MISMO_TIPO : DEFAULT;
    }
    private double getRandom(){
        Random util = new Random();
        int numeroAleatorio = util.nextInt(MAXIMO_RANDOM-MINIMO_RANDOM) + MINIMO_RANDOM;
        return (double) numeroAleatorio / MAXIMO_RANDOM;
    }

    private double getMultiplicadorEfectividad(Pokemon victima){
        return tipo.getEfectividadMap().get(victima.getTipos().toBasico()).getMultiplicador();
    }
}
