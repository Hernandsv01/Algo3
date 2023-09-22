package org.fiuba.algotres.estado;

import org.fiuba.algotres.Pokemon;

public class Estado {
    public static final String DORMIDO = "dormido";
    public static final String PARALIZADO = "paralizado";
    public static final String ENVENENADO = "envenenado";
    private int turnosAplicados;
    private final String tipo;

    public Estado(String tipo) {
        this.turnosAplicados = 0;
        this.tipo = tipo;
    }

    public boolean aplicar(Pokemon pokemon) {
        // true es que se le fue el estado, false es que sigue con el estado
        // Asumimos que cada pokemon puede tener un solo estado.
        switch(tipo) {
            case DORMIDO:
                double proba = 0.25 + turnosAplicados * 0.25;
                if (Math.random() <= proba) {
                    return true;
                }
                turnosAplicados++;
                return false;
            case PARALIZADO:
                return Math.random() >= 0.5;
            case ENVENENADO:
                pokemon.setVidaActual((int) (pokemon.getVidaActual() - pokemon.getVidaMaxima() * 0.05));
                return false;
        }
        return true; // No deberia llegar nunca.
    }
}
