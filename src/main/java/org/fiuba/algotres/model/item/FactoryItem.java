package org.fiuba.algotres.model.item;

import lombok.Getter;
import org.fiuba.algotres.model.strategies.AtaqueStrategy;
import org.fiuba.algotres.model.strategies.DefensaStrategy;

public class FactoryItem {
    private static final int PORCENTAJE_ESTADISTICA = 10;
    private static final int CANTIDAD_VIDA_POCION = 20;
    private static final int CANTIDAD_VIDA_MEGA_POCION = 50;
    private static final int CANTIDAD_VIDA_HIPER_POCION = 100;
    private static final int PORCENTAJE_DE_VIDA = 33;

    public static int getEfectividadPocion() {
        return CANTIDAD_VIDA_POCION;
    }

    public static int getEfectividadMegaPocion() {
        return CANTIDAD_VIDA_MEGA_POCION;
    }

    public static int getEfectividadHiperPocion() {
        return CANTIDAD_VIDA_HIPER_POCION;
    }

    public static int getEfectividadPocionMolestaAlumnos() {
        return PORCENTAJE_DE_VIDA;
    }

    public static Item CrearPocion(int cantidad) {
        return new Pocion(cantidad, "Pocion", CANTIDAD_VIDA_POCION);
    }

    public static Item CrearMegaPocion(int cantidad) {
        return new Pocion(cantidad, "Mega Pocion", CANTIDAD_VIDA_MEGA_POCION);
    }

    public static Item CrearHiperPocion(int cantidad) {
        if (cantidad > 1) {
            cantidad = 1;
        }
        return new Pocion(cantidad, "Hiper Pocion", CANTIDAD_VIDA_HIPER_POCION);
    }

    public static Item CrearPocionMolestaAlumnos(int cantidad) {
        return new PocionMolestaAlumnos(cantidad, "Pocion Molesta Alumnos", PORCENTAJE_DE_VIDA);
    }

    public static Item CrearCuraTodo(int cantidad) {
        return new CuraTodo(cantidad, "Cura Todo");
    }

    public static Item CrearRevivir(int cantidad) {
        return new Revivir(cantidad, "Revivir");
    }

    public static Item CrearAtaqueX(int cantidad) {
        return new Estadistica(cantidad, "Ataque X", PORCENTAJE_ESTADISTICA, new AtaqueStrategy(true));
    }

    public static Item CrearDefensaX(int cantidad) {
        return new Estadistica(cantidad, "Defensa X", PORCENTAJE_ESTADISTICA, new DefensaStrategy(true));
    }


}
