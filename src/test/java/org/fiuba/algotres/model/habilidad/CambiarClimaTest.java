package org.fiuba.algotres.model.habilidad;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.clima.Soleado;
import org.junit.jupiter.api.Test;

public class CambiarClimaTest {

    @Test
    public void TestAccionarHabilidad(){
        CampoDeBatalla cdb = mock(CampoDeBatalla.class);
        Soleado soleado = mock(Soleado.class);
        when(soleado.getCdb()).thenReturn(cdb);
        when(cdb.getClima()).thenReturn(soleado);
        CambiarClima cambiarClima = new CambiarClima(
                "Cambiar Clima",
                5,
                    soleado
                );

        int usosActuales = 5;

        verify(soleado, times(0)).getCdb();
        verify(cdb, times(0)).setClima(soleado);
        assertEquals(usosActuales, cambiarClima.getUsos());

        cambiarClima.accionarHabilidad(null, null);
        usosActuales--;

        verify(soleado, times(1)).getCdb();
        verify(cdb, times(1)).setClima(soleado);
        assertEquals(usosActuales, cambiarClima.getUsos());
    }
}
