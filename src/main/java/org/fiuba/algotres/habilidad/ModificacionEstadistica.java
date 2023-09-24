package org.fiuba.algotres.habilidad;

import org.fiuba.algotres.Pokemon;

public class ModificacionEstadistica extends Habilidad{
    public static final String ATAQUE = "ataque";
    public static final String DEFENSA = "defensa";
    public static final String VIDA = "vida";
    private final boolean propio;
    private final String tipo;
    public ModificacionEstadistica(String nombre, int usos, String tipo, boolean propio) {
        super(nombre, usos);
        this.propio = propio;
        this.tipo = tipo;
    }

    @Override
    public void accionarHabilidad(Pokemon atacante, Pokemon victima) {
        if (propio) {
            switch (tipo) {
                case ATAQUE:
                    int atqAntPropio = atacante.getAtaque();
                    atacante.setAtaque(Math.round((float) 0.15 * atqAntPropio + atqAntPropio));
                case DEFENSA:
                    int defAntPropio = atacante.getDefensa();
                    atacante.setDefensa(Math.round((float) 0.1 * defAntPropio + defAntPropio));
                case VIDA:
                    int vidaActual = atacante.getVidaActual();
                    if (vidaActual + 20 > atacante.getVidaMaxima()) {
                        atacante.setVidaActual(vidaActual + 20);
                    } else {
                        atacante.setVidaActual(atacante.getVidaMaxima());
                    }
            }
        } else {
            switch (tipo) {
                case ATAQUE:
                    int atqAntOponente = victima.getAtaque();
                    victima.setAtaque(Math.round((float) 0.1 * atqAntOponente + atqAntOponente));
                case DEFENSA:
                    int defAntOponente = victima.getDefensa();
                    victima.setDefensa(Math.round((float) 0.15 * defAntOponente + defAntOponente));
            }
        }
        usos--;
    }
}
