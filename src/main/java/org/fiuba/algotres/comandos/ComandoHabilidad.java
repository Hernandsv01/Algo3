package org.fiuba.algotres.comandos;

import org.fiuba.algotres.Pokemon;
import org.fiuba.algotres.habilidad.Habilidad;

import java.util.Map;

public class ComandoHabilidad implements Comando {
    /**
     * @param parametros Especificar los parametros que deben estar adentro del map
     */
    @Override
    public boolean ejecutar(Map<String, Object> parametros) {
        if(!parametrosValidos(parametros)){
            return false;
        }


        try{
            Pokemon atacante = (Pokemon) parametros.get("atacante");
            Habilidad habilidad = (Habilidad) parametros.get("habilidad");
            Pokemon victima = (Pokemon) parametros.get("victima");

            habilidad.accionarHabilidad(atacante, victima);
        }catch(ClassCastException e){
            System.out.println("Error en la ejecución de habilidad por parametros erroneos: " + e.getMessage());
            return false;
        }catch(Exception e){
            System.out.println("Los parametros eran del tipo correcto pero algo salió mal ejecutando la habilidad: " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean parametrosValidos(Map<String, Object> parametros) {
        return parametros.containsKey("atacante") &&
                parametros.containsKey("habilidad") &&
                parametros.containsKey("victima");
    }
}
