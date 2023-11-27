package org.fiuba.algotres.model.clima;

import lombok.Getter;
import lombok.Setter;
import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.habilidad.Ataque;
import org.fiuba.algotres.model.habilidad.Habilidad;
import org.fiuba.algotres.model.tipos.Tipos;

import java.util.List;

@Setter @Getter
public abstract class Clima {

    private int turnosAplicados;
    private final String nombre;
    private CampoDeBatalla cdb;
    private List<Tipos> tiposFavorecidos;

    private final int PORCENTAJE_POTENCIA = 10;
    private final int MAXIMO_TURNOS_APLICADOS = 5;

    public Clima(String nombre, CampoDeBatalla cdb) {
        this.nombre = nombre;
        this.turnosAplicados = 0;
        this.cdb = cdb;
    }
    public Clima(String nombre) {
        this.nombre = nombre;
        this.turnosAplicados = 0;
    }

    /**
     * Verifica si el turno es valido para aplicar los efectos del clima
     * @return true en caso de que se pueda aplicar. Caso contrario, false
     */
    public boolean turnoValido(){
        if(this.turnosAplicados == MAXIMO_TURNOS_APLICADOS) {
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
        if (this.tiposFavorecidos.contains(pokemon.getTipos())) {
            for (Habilidad habilidad : pokemon.getHabilidades()) {
                int poderActual = habilidad.getPoder();
                habilidad.setPoder(poderActual + Math.round(poderActual * (float) this.PORCENTAJE_POTENCIA / 100));
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
}
