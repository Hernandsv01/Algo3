package org.fiuba.algotres.comandos;

import java.util.Map;

public class ComandoCambiarPokemon implements Comando {
    @Override
    public boolean ejecutar(Map<String, Object> parametros) {
        return false;
    }

    @Override
    public boolean verificarParametros(Map<String, Object> parametros) {
        return false;
    }
}
