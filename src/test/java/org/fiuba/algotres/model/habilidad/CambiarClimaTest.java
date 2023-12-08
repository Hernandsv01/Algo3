package org.fiuba.algotres.model.habilidad;

import org.fiuba.algotres.model.CampoDeBatalla;
import org.fiuba.algotres.model.clima.Niebla;
import org.fiuba.algotres.model.clima.Soleado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CambiarClimaTest {

    @Test
    public void TestAccionarHabilidad(){
        CampoDeBatalla cdb = mock(CampoDeBatalla.class);
        Soleado soleado = mock(Soleado.class);
        when(soleado.getCdb()).thenReturn(cdb);
        when(cdb.getClima()).thenReturn(soleado);
        CambiarClima cambiarClimaSoleado = new CambiarClima(
                "Cambiar a soleado",
                5,
                soleado
                );

        Niebla niebla = mock(Niebla.class);
        when(niebla.getCdb()).thenReturn(cdb);
        CambiarClima cambiarClimaNeblina = new CambiarClima(
                "Cambiar a neblina",
                5,
                niebla
        );

        int usosActualesSoleado = 5;
        int usosActualesNiebla = 5;
        int usosMaximo = 5;

        verify(soleado, times(0)).getCdb();
        verify(cdb, times(0)).setClima(soleado);
        verify(soleado, times(0)).setTurnosAplicados(0);
        assertEquals(usosActualesSoleado, cambiarClimaSoleado.getUsos());

        cambiarClimaSoleado.accionarHabilidad(null, null);
        usosActualesSoleado--;

        verify(soleado, times(1)).getCdb();
        verify(cdb, times(1)).setClima(soleado);
        verify(soleado, times(1)).setTurnosAplicados(0);
        assertEquals(usosActualesSoleado, cambiarClimaSoleado.getUsos());

        for (int i = 1; i < usosMaximo; i++) {
            verify(niebla, times(i-1)).setTurnosAplicados(0);
            cambiarClimaNeblina.accionarHabilidad(null, null);
            usosActualesNiebla--;
            verify(niebla, times(i)).getCdb();
            verify(cdb, times(i)).setClima(niebla);
            assertEquals(usosActualesNiebla, cambiarClimaNeblina.getUsos());
        }
        verify(niebla, times(usosMaximo-1)).setTurnosAplicados(0);


        cambiarClimaSoleado.accionarHabilidad(null, null);
        usosActualesSoleado--;

        verify(soleado, times(2)).setTurnosAplicados(0);
        verify(soleado, times(2)).getCdb();
        verify(cdb, times(2)).setClima(soleado);
        assertEquals(usosActualesSoleado, cambiarClimaSoleado.getUsos());

    }
}
