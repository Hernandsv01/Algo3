package org.fiuba.algotres.habilidad;
package org.fiuba.algotres.Tipos;

import org.fiuba.algotres.Pokemon;
import org.fiuba.algotres.Tipos;
import java.lang.Math;
import java.util.Random;

import lombok.Getter;
import lombot.Setter;

@Getter @Setter
public class Ataque extends Habilidad{
    private String nombre;
    private int usos;
    private int poder;
    private Tipos tipo;

    public Ataque() {
    }

    public Ataque(String nombre, int usos, int poder, Tipos tipo) {
    this.nombre = nombre;
    this.usos = usos;
    this.poder = poder;
    this.tipo = tipo;

    }



    @Override
    public boolean accionarHabilidad(Pokemon atacante, Pokemon victima) {
        int daño = ((2 + ( 2 *  atacante.getNivel() *  critico * this.poder * (atacante.getAtaque()/victima.getDefensa()) ) /50) * establecerMismoTipo() * establecerEfectividad(victima) * establecerRandom();
        if((victima.getVidaActual() - daño) <= 0){
            this.usos--;
            return true
        }
        else {
            victima.setVidaActual() = victima.getVidaActual - daño
            this.usos--;
            return false
        }


    }

    public int establecerCritico(){
        float probabilidad = 0.9;
        double chance = Math.random();
        return chance<= probabilidad ? 2:1;
    }

    public int establecerMismoTipo(Pokemon atacante){

        return atacante.getTipo().equalsIgnoreCase(this.mismoTipo.name()) ? 1.5 : 1;
    }

    public float establecerEfectividad(Pokemon victima){
        HashMap<TiposBasicos, Efectividad> efectividadHashMap = this.tipo.getEfectividadMap();
        if(efectividadHashMap.get(TiposBasicos.victima.getTipo().name()) == "INUTIL"){
            return 0.0
        }
        else if(efectividadHashMap.get(TiposBasicos.victima.getTipo().name()) == "DEBIL"){
            return 0.5
        }
        else if(efectividadHashMap.get(TiposBasicos.victima.getTipo().name()) == "NORMAL"){
            return 1.0
        }
        else (efectividadHashMap.get(TiposBasicos.victima.getTipo().name()) == "FUERTE"){
            return 2.0
        }
    }
    public float establecerRandom(){
        Random util = new Random();
        int numeroAleatorio = a.nextInt(38) + 217;
        return (float) numeroAleatorio / 255;

    }

}
