package org.fiuba.algotres.views.terminal;

import org.fiuba.algotres.model.Pokemon;
import org.fiuba.algotres.model.habilidad.*;
import org.fiuba.algotres.model.strategies.AtaqueStrategy;
import org.fiuba.algotres.model.strategies.DefensaStrategy;
import org.fiuba.algotres.model.strategies.VidaStrategy;
import org.fiuba.algotres.utils.GeneradorDeMensajes;
import org.fiuba.algotres.views.OutputUsuario;

public class HabilidadView {

    private static OutputUsuario output = new OutputUsuarioTerminal();

    public static void mostrarEfectoHabilidad(Habilidad habilidad, Pokemon atacante, Pokemon victima){
        output.mostrarLinea(GeneradorDeMensajes.generarMensajeEfectoHabilidad(habilidad, atacante, victima));
    }
}
