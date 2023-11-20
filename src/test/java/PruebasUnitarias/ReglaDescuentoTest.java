package PruebasUnitarias;
import domain.ReglaDeDescuento;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReglaDescuentoTest {

    @Test
    public void totalMenorA0(){
        double total = -2;
        ReglaDeDescuento r = new ReglaDeDescuento();
        assertThrows(IllegalArgumentException.class, ()->{r.Calcular(total);} );
    }

    @Test
    public void totalMayorA5000YMenorA10000(){
        double total = 8000;
        ReglaDeDescuento r = new ReglaDeDescuento();
        double resultado = r.Calcular(total);
        assertEquals(240,resultado);
    }

    @Test
    public void totalMayorA10000YMenorA25000(){
        double total = 15000;
        ReglaDeDescuento r = new ReglaDeDescuento();
        double resultado = r.Calcular(total);
        assertEquals(750,resultado);
    }

    @Test
    public void totalMayorA25000(){
        double total = 50000;
        ReglaDeDescuento r = new ReglaDeDescuento();
        double resultado = r.Calcular(total);
        assertEquals(5000,resultado);
    }

}
