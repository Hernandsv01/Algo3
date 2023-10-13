package org.fiuba.algotres;

import lombok.Getter;
import lombok.Setter;
import org.fiuba.algotres.estado.Estado;
import org.fiuba.algotres.habilidad.Habilidad;

import java.util.List;

@Getter @Setter
public class Pokemon {
    private final String nombre;
    private final Integer nivel;
    private final Tipos tipos;
    private final String historia;
    private Integer vidaActual;
    private final Integer vidaMaxima;
    private final Integer velocidad;
    private Integer defensa;
    private Integer ataque;
    private Estado estado;
    private final List<Habilidad> habilidades;

    public Pokemon(
            String nombre,
            Integer nivel,
            Tipos tipos,
            String historia,
            Integer vidaMaxima,
            Integer velocidad,
            Integer defensa,
            Integer ataque,
            List<Habilidad> habilidades
    ) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.tipos = tipos;
        this.historia = historia;
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaMaxima;
        this.velocidad = velocidad;
        this.defensa = defensa;
        this.ataque = ataque;
        this.estado = null;
        this.habilidades = habilidades;
    }

    /**
     * Cura al máximo al pokemon
     */
    public void curar(){
        vidaActual = vidaMaxima;
    }

    /**
     * Cura al pokemon por la cantidad de puntos del parámetro
     * @param puntos puntos de vida que agregarle al pokemon
     */
    public void curarPorPuntos(int puntos){
        vidaActual += puntos;
        if (vidaActual + puntos > vidaMaxima) {
            curar();
        }
    }

    /**
     * Cura al pokemon por un valor porcentual de la vida actual.
     * @param porcentaje porcentaje de la vida máxima que se quiere recuperar en el pokemon.
     */
    public void curarPorPorcentaje(int porcentaje) {
        vidaActual += Math.round(((float)porcentaje / 100) * vidaMaxima);
        if (vidaActual > vidaMaxima) {
            curar();
        }
    }

    /**
     * Le quita vida al pokemon por la cantidad de puntos del parametro.
     * @param puntos puntos de vida que quitarle al pokemon
     */
    public void danarPorPuntos(int puntos){
        vidaActual -= puntos;
        if (vidaActual < 0) {
            matar();
        }
    }

    /**
     * La quita vida al pokemon por un valor porcentual de la vida actual.
     * @param porcentaje porcentaje de la vida máxima que se quiere reducir en el pokemon.
     */
    public void danarPorPorcentaje(int porcentaje) {
        vidaActual -= Math.round(((float)porcentaje / 100) * vidaMaxima);
        if (vidaActual < 0) {
            matar();
        }
    }

    /**
     * Pone la vida del pokemon en cero
     */
    public void matar(){
        vidaActual = 0;
    }

    /**
     * Suma (valor positivo) o resta (valor negativo) el porcentaje pasado por parametro
     * que cambiara el ataque en el pokemon actual.
     * @param porcentaje porcentaje del valor actual de ataque que se quiere modificar.
     */
    public void modificarAtaque(int porcentaje) {
        if (porcentaje > 0 && porcentaje < 100) {
            ataque += Math.round(((float) porcentaje / 100) * ataque);
        }
    }

    /**
     * Suma (valor positivo) o resta (valor negativo) el porcentaje pasado por parametro
     * que cambiara la defensa en el pokemon actual.
     * @param porcentaje porcentaje del valor actual de defensa que se quiere modificar.
     */
    public void modificarDefensa(int porcentaje) {
        if (porcentaje > 0 && porcentaje < 100) {
            defensa += Math.round(((float) porcentaje / 100) * defensa);
        }
    }
}
