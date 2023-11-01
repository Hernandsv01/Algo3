package org.fiuba.algotres.model.item;

import org.fiuba.algotres.model.strategies.AtaqueStrategy;
import org.fiuba.algotres.model.strategies.DefensaStrategy;
import org.jetbrains.annotations.NotNull;

public class FactoryItem {
    private static final int PORCENTAJEESTADISTICA = 10;
    public static Item Crear(int cantidad, @NotNull String nombre) {
        return switch (nombre) {
            case "Cura Todo" -> new CuraTodo(cantidad, nombre);
            case "Ataque X" -> new Estadistica(cantidad, nombre, PORCENTAJEESTADISTICA, new AtaqueStrategy());
            case "Defensa X" -> new Estadistica(cantidad, nombre, PORCENTAJEESTADISTICA, new DefensaStrategy());
            case "Poción" -> new Pocion(cantidad, nombre);
            case "Mega Poción" -> new MegaPocion(cantidad, nombre);
            case "Hiper Poción" -> new HiperPocion(cantidad, nombre);
            case "Revivir" -> new Revivir(cantidad, nombre);
            case "Poción Molesta Alumnos" -> new PocionMolestaAlumnos(cantidad, nombre);
            default -> null;
        };
    }
}
