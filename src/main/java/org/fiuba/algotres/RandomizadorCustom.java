package org.fiuba.algotres.utils;

import org.fiuba.algotres.model.Randomizador;

public class RandomizadorCustom extends Randomizador {
    @Override
    public double getRandomValue(double lowerLimit, double upperLimit){
        double result = ((Math.random()*(upperLimit-lowerLimit)) + lowerLimit);
        return result;
    }
}
