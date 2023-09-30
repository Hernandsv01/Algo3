package org.fiuba.algotres.comandos;

import org.fiuba.algotres.Jugador;
import org.fiuba.algotres.Pokemon;
import org.fiuba.algotres.habilidad.Habilidad;
import org.fiuba.algotres.item.Item;

import java.util.Map;

public class ComandoItem implements Comando {
    @Override
    public boolean ejecutar(Map<String, Object> parametros) {
        if(!parametrosValidos(parametros)){
            return false;
        }

        try{
            Item item = (Item) parametros.get("item");
            Pokemon pokemon = (Pokemon) parametros.get("pokemon");
            return item.usar(pokemon);
        }catch(ClassCastException e){
            System.out.println("Error en la ejecución de item por parametros erroneos: " + e.getMessage());
            return false;
        }catch(Exception e){
            System.out.println("Los parametros eran del tipo correcto pero algo salió mal usando el item: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean parametrosValidos(Map<String, Object> parametros) {
        return parametros.containsKey("item") &&
                parametros.containsKey("pokemon");
    }
}
