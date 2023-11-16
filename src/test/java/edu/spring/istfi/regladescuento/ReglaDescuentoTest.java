package edu.spring.istfi.regladescuento;

import edu.spring.istfi.model.ReglaDescuento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReglaDescuentoTest {

    @Test
    public void testCalcularTotalMenorOIgualA0() {
        ReglaDescuento reglaDescuento = new ReglaDescuento();

        assertThrows(IllegalArgumentException.class, () -> {
            reglaDescuento.Calcular(0);
        });
    }

    @Test
    public void testCalcularTotalEntre0Y5000() {
        ReglaDescuento reglaDescuento = new ReglaDescuento();

        double resultado = reglaDescuento.Calcular(4000);

        assertEquals(0, resultado, 0.001);
    }

    @Test
    public void testCalcularTotalEntre5000Y10000() {
        ReglaDescuento reglaDescuento = new ReglaDescuento();

        double resultado = reglaDescuento.Calcular(7500);

        assertEquals(7500 * 0.03, resultado, 0.001);
    }

    @Test
    public void testCalcularTotalEntre10000Y25000() {
        ReglaDescuento reglaDescuento = new ReglaDescuento();

        double resultado = reglaDescuento.Calcular(15000);

        assertEquals(15000 * 0.05, resultado, 0.001);
    }

    @Test
    public void testCalcularTotalMayorA25000() {
        ReglaDescuento reglaDescuento = new ReglaDescuento();

        double resultado = reglaDescuento.Calcular(30000);

        assertEquals(30000 * 0.10, resultado, 0.001);
    }
}
