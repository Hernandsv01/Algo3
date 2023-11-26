package org.fiuba.algotres.model.item;

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

    public static Item crearPocion(int cantidad) {
        return new Pocion(cantidad, "Pocion", CANTIDAD_VIDA_POCION);
    }
    public static Item crearPocion() {
        return new Pocion("Pocion", CANTIDAD_VIDA_POCION);
    }

    public static Item crearMegaPocion(int cantidad) {
        return new Pocion(cantidad, "Mega Pocion", CANTIDAD_VIDA_MEGA_POCION);
    }
    public static Item crearMegaPocion() {
        return new Pocion("Mega Pocion", CANTIDAD_VIDA_MEGA_POCION);
    }

    public static Item crearHiperPocion(int cantidad) {
        if (cantidad > 1) {
            cantidad = 1;
        }
        return new Pocion(cantidad, "Hiper Pocion", CANTIDAD_VIDA_HIPER_POCION);
    }
    public static Item crearHiperPocion() {
        return new Pocion("Hiper Pocion", CANTIDAD_VIDA_HIPER_POCION);
    }

    public static Item crearPocionMolestaAlumnos(int cantidad) {
        return new PocionMolestaAlumnos(cantidad, "Pocion Molesta Alumnos", PORCENTAJE_DE_VIDA);
    }
    public static Item crearPocionMolestaAlumnos() {
        return new PocionMolestaAlumnos("Pocion Molesta Alumnos", PORCENTAJE_DE_VIDA);
    }

    public static Item crearCuraTodo(int cantidad) {
        return new CuraTodo(cantidad, "Cura Todo");
    }
    public static Item crearCuraTodo() {
        return new CuraTodo("Cura Todo");
    }

    public static Item crearRevivir(int cantidad) {
        return new Revivir(cantidad, "Revivir");
    }
    public static Item crearRevivir() {
        return new Revivir("Revivir");
    }

    public static Item crearAtaqueX(int cantidad) {
        return new Estadistica(cantidad, "Ataque X", PORCENTAJE_ESTADISTICA, new AtaqueStrategy(true));
    }
    public static Item crearAtaqueX() {
        return new Estadistica("Ataque X", PORCENTAJE_ESTADISTICA, new AtaqueStrategy(true));
    }

    public static Item crearDefensaX(int cantidad) {
        return new Estadistica(cantidad, "Defensa X", PORCENTAJE_ESTADISTICA, new DefensaStrategy(true));
    }
    public static Item crearDefensaX() {
        return new Estadistica("Defensa X", PORCENTAJE_ESTADISTICA, new DefensaStrategy(true));
    }
}
