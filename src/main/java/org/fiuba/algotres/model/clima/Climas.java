package org.fiuba.algotres.model.clima;

import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.tipos.Tipos;

import java.util.List;

public abstract class Climas implements Clima{

    public int turnosAplicados;
    public final String nombre;
    public final int PORCENTAJEPOTENCIAR = 10;
    public final CampoDeBatalla cdb;
    public List<Tipos> tiposFavorecidos;

    public Climas(String nombre, CampoDeBatalla cdb) {
        this.nombre = nombre;
        this.turnosAplicados = 0;
        this.cdb = cdb;
    }

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

    public void potenciarPokemon(Pokemon pokemon) {
        if(this.tiposFavorecidos.contains(pokemon.getTipos())) {
            pokemon.modificarAtaque(this.PORCENTAJEPOTENCIAR);
        }
    }

    @Override
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
