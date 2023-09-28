package org.fiuba.algotres.habilidad;

import org.fiuba.algotres.Pokemon;
import java.lang.Math;

import lombok.Getter;
import lombot.Setter;

@Getter @Setter
public class Ataque extends Habilidad{
    private String nombre;
    private int usos;
    private int nivelPokemon;
    private int critico;
    private int poder;
    private int A;
    private int D;
    private boolean mismoTipo;
    private Tipo tipo;

    public Ataque() {
    }

    public Ataque(String nombre, int usos) {
        super(nombre, usos);
    }



    @Override
    public void accionarHabilidad(Pokemon atacante, Pokemon victima) {
        if(usos== 0){
            return false;
        }
        //int nivelPokemonAtacante = atacante.getNivel();
        int critico = establecerCritico(); //numero random entre  2 y 1. Siendo 2 que se aplique critico y 1 que no
        //int poder = this.poder;
        //int poderAtaquePokemon = atacante.getAtaque();
        //int poderDefensaPokemon = victima.getDefensa();
        int mismoTipo = establecerMismoTipo(atacante));
        int ramdom =  0; // aleatorio uniformemente distribuido entre 217 y 255 (inclusive), seguido de una divisi´on entera por 255.


        int daño = ((2 + ( 2 *  atacante.getNivel() *  critico * this.poder * (atacante.getAtaque()/victima.getDefensa()) ) /50)

        usos--;
    }

    public int establecerCritico(){
        float probabilidad = 0.9;
        double chance = Math.random();
        if(chance<= probabilidad){
            return 1;
        }
        else return 2;
    }

    public int establecerMismoTipo(Pokemon atacante){
        double chance = Math.random();
        if(this.tipo == atacante.getTipo()){
            return 1.5;
        }
        else return 1;
    }


}
