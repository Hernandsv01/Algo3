package org.fiuba.algotres.model.clima;

import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.habilidad.Ataque;
import org.fiuba.algotres.model.habilidad.Habilidad;
import org.fiuba.algotres.model.tipos.Tipos;

import java.util.List;

public abstract class Clima {

    public int turnosAplicados;
    public final String nombre;
    public final int PORCENTAJEPOTENCIAR = 10;
    public final CampoDeBatalla cdb;
    public List<Tipos> tiposFavorecidos;

    public Clima(String nombre, CampoDeBatalla cdb) {
        this.nombre = nombre;
        this.turnosAplicados = 0;
        this.cdb = cdb;
    }

    /**
     * Verifica si el turno es valido para aplicar los efectos del clima
     * @return true en caso de que se pueda aplicar. Caso contrario, false
     */
    public boolean turnoValido(){
        if(this.turnosAplicados == 5) {
            this.turnosAplicados = 0;
            this.cdb.setClima(new SinClima("Sin clima", cdb));
            return false;

        }else{
            this.turnosAplicados++;
            return true;
        }
    };

    /**
     * Aumenta el daño de las habilidades del pokemon dependiendo de su tipo
     * @param pokemon al cual se potenciara
     */
    public void potenciarPokemon(Pokemon pokemon) {
        if(this.tiposFavorecidos.contains(pokemon.getTipos())) {
            for(Habilidad habilidad: pokemon.getHabilidades()) {
                if(habilidad.getClass() == Ataque.class) {
                    int poderActual = ((Ataque) habilidad).getPoder();
                    ((Ataque) habilidad).setPoder(poderActual + Math.round(poderActual * (float)this.PORCENTAJEPOTENCIAR/100));
                }
            }
        }
    }

    /**
     * Aplica los efectos del clima al pokemon
     * @param pokemon al cual aplicara
     */
    public void aplicarEfectos(Pokemon pokemon) {
        if(this.turnoValido()) {
            potenciarPokemon(pokemon);
        }
    };

    public CampoDeBatalla getCdb() {
        return cdb;
    }

    public String getNombre() {
        return nombre;
    }
}
