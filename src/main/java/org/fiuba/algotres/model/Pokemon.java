package org.fiuba.algotres.model;

import lombok.Getter;
import lombok.Setter;
import org.fiuba.algotres.model.estado.Estado;
import org.fiuba.algotres.model.habilidad.Habilidad;
import org.fiuba.algotres.model.tipos.Tipos;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Pokemon {
    private final String nombre;
    private int id;
    private final Integer nivel;
    private final Tipos tipos;
    private final String historia;
    private Integer vidaActual;
    private final Integer vidaMaxima;
    private final Integer velocidad;
    private Integer defensa;
    private Integer ataque;
    private List<Estado> estados;
    private boolean estaVivo;
    private List<Habilidad> habilidades;
    private List<Estado> estadosQuitados;

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
        this.estados = new ArrayList<Estado>();
        this.estaVivo = true;
        this.habilidades = habilidades;
        this.estadosQuitados = new ArrayList<Estado>();
    }
    public Pokemon(
            String nombre,
            int id,
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
        this.id = id;
        this.nivel = nivel;
        this.tipos = tipos;
        this.historia = historia;
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaMaxima;
        this.velocidad = velocidad;
        this.defensa = defensa;
        this.ataque = ataque;
        this.estados = new ArrayList<Estado>();
        this.estaVivo = true;
        this.habilidades = habilidades;
        this.estadosQuitados = new ArrayList<Estado>();
    }

    /**
     * Cura al pokemon por la cantidad de puntos del parámetro
     * @param puntos puntos de vida que agregarle al pokemon
     */
    public void curarPorPuntos(int puntos){
        vidaActual += puntos;
        if (vidaActual > vidaMaxima) {
            revivir();
        }
    }

    /**
     * Cura al pokemon por un valor porcentual de la vida actual.
     * @param porcentaje porcentaje de la vida máxima que se quiere recuperar en el pokemon.
     */
    public void curarPorPorcentaje(int porcentaje) {
        vidaActual += Math.round(((float)porcentaje / 100) * vidaMaxima);
        if (vidaActual > vidaMaxima) {
            revivir();
        }
    }

    /**
     * Le quita vida al pokemon por la cantidad de puntos del parametro.
     * @param puntos puntos de vida que quitarle al pokemon
     */
    public void danarPorPuntos(int puntos){
        vidaActual -= puntos;
        if (vidaActual <= 0) {
            matar();
        }
    }

    /**
     * La quita vida al pokemon por un valor porcentual de la vida actual.
     * @param porcentaje porcentaje de la vida máxima que se quiere reducir en el pokemon.
     */
    public void danarPorPorcentaje(int porcentaje) {
        vidaActual -= Math.round(((float)porcentaje / 100) * vidaMaxima);
        if (vidaActual <= 0) {
            matar();
        }
    }

    /**
     * Mata al pokemon
     */
    public void matar(){
        vidaActual = 0;
        estaVivo = false;
    }

    /**
     * Suma (valor positivo) o resta (valor negativo) el porcentaje pasado por parametro
     * que cambiara el ataque en el pokemon actual.
     * @param porcentaje porcentaje del valor actual de ataque que se quiere modificar.
     */
    public void modificarAtaque(int porcentaje) {
        ataque += Math.round(((float) porcentaje / 100) * ataque);
        if (ataque <= 0) {
            ataque = 1;
        }
    }

    /**
     * Suma (valor positivo) o resta (valor negativo) el porcentaje pasado por parametro
     * que cambiara la defensa en el pokemon actual.
     * @param porcentaje porcentaje del valor actual de defensa que se quiere modificar.
     */
    public void modificarDefensa(int porcentaje) {
        defensa += Math.round(((float) porcentaje / 100) * defensa);
        if (defensa <= 0) {
            defensa = 1;
        }
    }

    /**
     * Verifica si el pokemon se encuentra con vida.
     * @return True si el pokemon se encuentra disponible para la batalla.
     * False si el pokemon se encuentra debilitado.
     */
    public boolean estaVivo(){
        return estaVivo && vidaActual > 0;
    }

    /**
     * Revive al pokemon
     */
    public void revivir(){
        estaVivo = true;
        vidaActual = vidaMaxima;
    }

    /**
     * Incorpora un nuevo estado, pasado por parametro, al pokemon.
     * En caso de que el pokemon ya posea el estado, no se le incorporara.
     * @param estado estado que se le quiere agregar al pokemon.
     */
    public void agregarEstado(Estado estado) {
        if (!this.estados.contains(estado)) {
            this.estados.add(estado);
            estado.setPokemon(this);
        }
    }

    /**
     * Elimina el estado, pasado por parametro, del pokemon.
     * En caso de que el pokemon no posea el estado, no se efectuaran cambios.
     * @param estado estado que se le quitar agregar al pokemon.
     */
    public void quitarEstado(Estado estado) {
        this.estadosQuitados.add(estado);
    }
    public void limpiarEstados() {
        for (Estado estadoquitado : this.estadosQuitados) {
            this.estados.remove(estadoquitado);
        }
    }
}
