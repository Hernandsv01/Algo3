package org.fiuba.algotres.views.terminal;

import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.habilidad.*;
import org.fiuba.algotres.model.strategies.AtaqueStrategy;
import org.fiuba.algotres.model.strategies.DefensaStrategy;
import org.fiuba.algotres.model.strategies.VidaStrategy;
import org.fiuba.algotres.views.OutputUsuario;

public class HabilidadView {

    private static OutputUsuario output = new OutputUsuarioTerminal();

    public static void mostrarEfectoHabilidad(Habilidad habilidad, Pokemon atacante, Pokemon victima){
        if(habilidad instanceof Ataque){
            output.mostrarLinea(victima.getNombre() + " recibió " + ((Ataque) habilidad).getUltimoDanoRealizado() + " de daño!");
        }else if(habilidad instanceof CambiarClima){
            output.mostrarLinea("El clima fue cambiado a " + ((CambiarClima) habilidad).getClima().getNombre());
        }else if(habilidad instanceof ModificacionEstadistica){
            String message = victima.getNombre();
            if(((ModificacionEstadistica) habilidad).getStrategy().esPositivo()){
                message += " ganó un ";
            }else {
                message += " perdió un ";
            }
            message += ((ModificacionEstadistica) habilidad).getPorcentaje();
            if(((ModificacionEstadistica) habilidad).getStrategy() instanceof AtaqueStrategy){
                message += "% de ataque";
            }else if(((ModificacionEstadistica) habilidad).getStrategy() instanceof DefensaStrategy){
                message += "% de defensa";
            }else if(((ModificacionEstadistica) habilidad).getStrategy() instanceof VidaStrategy){
                message += "% de vida";
            }
            output.mostrarLinea(message);
        }else if(habilidad instanceof ModificacionEstado){
            output.mostrarLinea(victima.getNombre() + " ahora está " + ((ModificacionEstado) habilidad).getEstado().getNombre());
        }else{
            output.mostrarLinea("Habilidad" + habilidad.getNombre() + " usada!");
        }
    }
}
