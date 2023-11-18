package org.fiuba.algotres.utils;

import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.habilidad.*;
import org.fiuba.algotres.model.strategies.AtaqueStrategy;
import org.fiuba.algotres.model.strategies.DefensaStrategy;
import org.fiuba.algotres.model.strategies.VidaStrategy;

public class GeneradorDeMensajes {
    public static String generarMensajeEfectoHabilidad(Habilidad habilidad, Pokemon atacante, Pokemon victima){
        if(habilidad instanceof Ataque){
            return victima.getNombre() + " recibió " + ((Ataque) habilidad).getUltimoDanoRealizado() + " de daño!";
        }else if(habilidad instanceof CambiarClima){
            return "El clima fue cambiado a " + ((CambiarClima) habilidad).getClima().getNombre();
        }else if(habilidad instanceof ModificacionEstadistica){
            String message = "";
            if(((ModificacionEstadistica) habilidad).getStrategy().esPositivo()){
                message += atacante.getNombre() + " ganó un ";
            }else {
                message += victima.getNombre() + " perdió un ";
            }
            message += ((ModificacionEstadistica) habilidad).getPorcentaje();
            if(((ModificacionEstadistica) habilidad).getStrategy() instanceof AtaqueStrategy){
                message += "% de ataque";
            }else if(((ModificacionEstadistica) habilidad).getStrategy() instanceof DefensaStrategy){
                message += "% de defensa";
            }else if(((ModificacionEstadistica) habilidad).getStrategy() instanceof VidaStrategy){
                message += "% de vida";
            }
            return message;
        }else if(habilidad instanceof ModificacionEstado){
            return victima.getNombre() + " ahora está " + ((ModificacionEstado) habilidad).getEstado().getNombre();
        }else{
            return "Habilidad" + habilidad.getNombre() + " usada!";
        }
    }
}
