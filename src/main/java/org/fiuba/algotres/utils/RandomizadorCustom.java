package org.fiuba.algotres.utils;

import org.fiuba.algotres.model.Randomizador;

public class RandomizadorCustom extends Randomizador {
    @Override
    public double getRandomValue(double limiteInferior, double limiteSuperior){
        double result = ((Math.random()*(limiteSuperior-limiteInferior)) + limiteInferior);
        Randomizador.savedLastGeneratedValue(result);
        return result;
    }
}
