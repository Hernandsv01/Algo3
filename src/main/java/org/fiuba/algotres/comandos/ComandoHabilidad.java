package org.fiuba.algotres.comandos;

public class ComandoHabilidad implements Comando<ParametrosComandoHabilidad> {
    @Override
    public boolean ejecutar(ParametrosComandoHabilidad parametros) {
        parametros.getHabilidad().accionarHabilidad(parametros.getAtacante(), parametros.getVictima());
        return true;
    }
}
