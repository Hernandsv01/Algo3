package org.fiuba.algotres.model.habilidad;

import lombok.Getter;
import lombok.Setter;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.Randomizador;
import org.fiuba.algotres.model.tipos.Tipos;
import org.fiuba.algotres.utils.RandomizadorCustom;

@Getter @Setter
public class Ataque extends Habilidad{
    private int poder;
    private Tipos tipo;
    private Randomizador randomizador = new RandomizadorCustom();
    private int ultimoDanoRealizado;

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

    public Ataque(int id, String nombre, int usos, int poder, Tipos tipo) {
        super(id, nombre, usos);
        this.poder = poder;
        this.tipo = tipo;
    }

    @Override
    public boolean accionarHabilidad(Pokemon atacante, Pokemon victima) {
        // cambiar dato guardado en randomizador por dato guardado acá, guardar daño completo.
        if (verificarUsos(usos)) {
            int dano = calcularDano(atacante, victima);
            ultimoDanoRealizado = dano;
            victima.danarPorPuntos(dano);
            usos--;
            return true;
        }
        return false;
    }

    public int calcularDano(Pokemon atacante, Pokemon victima){
        return (int) (calcularDanoSinRandom(atacante, victima) * (randomizador.getRandomValue(MINIMO_RANDOM, MAXIMO_RANDOM)/MAXIMO_RANDOM));
    }

    private int calcularDanoSinRandom(Pokemon atacante, Pokemon victima){
        double numeradorInterno = 2 * atacante.getNivel() * esCritico() * this.poder * ((double) atacante.getAtaque() / (double) victima.getDefensa());
        double fraccionCompleta = (2 + (numeradorInterno / 5)) / 50;
        return (int) (fraccionCompleta * esMismoTipo(atacante) * getMultiplicadorEfectividad(victima));
    }

    private int esCritico(){
        double resultado = randomizador.getRandomValue(0, 1);
        return resultado <= PROBABILIDAD_CRITICO ? MULTIPLICADOR_CRITICO : DEFAULT;
    }

    private double esMismoTipo(Pokemon atacante){
        return (atacante.getTipos() == tipo) ? MULTIPLICADOR_MISMO_TIPO : DEFAULT;
    }

    private double getMultiplicadorEfectividad(Pokemon victima){
        return tipo.getEfectividadMap().get(victima.getTipos().toBasico()).getMultiplicador();
    }

    public void setRandomizador(Randomizador randomizador){
        this.randomizador = randomizador;
    }

    public int getUltimoDanoRealizado(){
        return ultimoDanoRealizado;
    }
}
