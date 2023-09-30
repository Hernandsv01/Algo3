package org.fiuba.algotres.comandos;

import org.fiuba.algotres.Jugador;
import org.fiuba.algotres.Pokemon;
import org.fiuba.algotres.item.Item;

import java.util.Map;

public class ComandoRendirse implements Comando {
    @Override
    public boolean ejecutar(Map<String, Object> parametros) {
        if(!parametrosValidos(parametros)){
            return false;
        }

        try{
            Jugador jugador = (Jugador) parametros.get("jugador");
            jugador.rendirse();
            return true;
        }catch(ClassCastException e){
            System.out.println("Error en la ejecución de rendirse por parametros erroneos: " + e.getMessage());
            return false;
        }catch(Exception e){
            System.out.println("Los parametros eran del tipo correcto pero algo salió mal rindiendose: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean parametrosValidos(Map<String, Object> parametros) {
        return parametros.containsKey("jugador");
    }
}
