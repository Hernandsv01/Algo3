package org.fiuba.algotres.model;

public abstract class Randomizador {
    private static double lastGeneratedValue;

    public abstract double getRandomValue(double upperLimit, double bottomLimit);

    public static void savedLastGeneratedValue(double value){
        lastGeneratedValue = value;
    }
    public static double getLastGeneratedValue(){
        return lastGeneratedValue;
    }
}
