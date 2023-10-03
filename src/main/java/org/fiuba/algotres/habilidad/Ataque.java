package org.fiuba.algotres.habilidad;
package org.fiuba.algotres.Tipos;

import org.fiuba.algotres.Pokemon;
import org.fiuba.algotres.Tipos;
import java.lang.Math;
import java.util.HashMap;
import java.util.Random;

import lombok.Getter;
import lombot.Setter;

@Getter @Setter
public class Ataque extends Habilidad{
    private String nombre;
    private int usos;
    private int poder;
    private Tipos tipo;

    public Ataque() {}

    public Ataque(String nombre, int usos, int poder, Tipos tipo) {
    this.nombre = nombre;
    this.usos = usos;
    this.poder = poder;
    this.tipo = tipo;

    }



    @Override
    public boolean accionarHabilidad(Pokemon atacante, Pokemon victima) {
        int daño = ((2 + ( 2 *  atacante.getNivel() *  establecerCritico() * this.poder * (atacante.getAtaque()/victima.getDefensa()) ) /50) * establecerMismoTipo() * establecerEfectividad(victima) * establecerRandom();
        if((victima.getVidaActual() - daño) <= 0){
            this.usos--;
            return true;
        }
        else {
            victima.setVidaActual(victima.getVidaActual - daño);
            this.usos--;
            return false;
        }


    }

    public int establecerCritico(){
        float probabilidad = 0.9F;
        double chance = Math.random();
        return chance<= probabilidad ? 2:1;
    }

    public float establecerMismoTipo(Pokemon atacante){

        return atacante.getTipo().equalsIgnoreCase(this.tipo.name()) ? 1.5F : 1.0F;
    }

    public float establecerEfectividad(Pokemon victima){
        HashMap<TiposBasicos, Efectividad> efectividadHashMap = this.tipo.getEfectividadMap();
        if(efectividadHashMap.get(TiposBasicos.victima.getTipo().name()) == "INUTIL"){
            return 0.0F;
        }
        else if(efectividadHashMap.get(TiposBasicos.victima.getTipo().name()) == "DEBIL"){
            return 0.5F;
        }
        else if(efectividadHashMap.get(TiposBasicos.victima.getTipo().name()) == "NORMAL"){
            return 1.0F;
        }
        else if (efectividadHashMap.get(TiposBasicos.victima.getTipo().name()) == "FUERTE"){
            return 2.0F;
        }
    }
    public float establecerRandom(){
        Random util = new Random();
        int numeroAleatorio = util.nextInt(38) + 217;
        return (float) numeroAleatorio / 255.0F;

    }

}
