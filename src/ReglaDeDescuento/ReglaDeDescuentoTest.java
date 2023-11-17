package ReglaDeDescuento;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ReglaDeDescuentoTest {
    @Test
    public void testCalcularDescuentoConTotalValido() {
        ReglaDeDescuento reglaDeDescuento = new ReglaDeDescuento();
        // Entrada: total válido
        double total = 10000;

        // Especifación: el descuento debe ser el especificado
        double descuentoEsperado = 300;

        // Resultado esperado: el descuento calculado debe ser igual al descuento esperado
        double descuentoCalculado = reglaDeDescuento.CalcularDescuento(total);

        Assertions.assertEquals(descuentoEsperado, descuentoCalculado);
    }

    @Test
    public void testCalcularDescuentoConTotalMayorQueElLimite() {
        ReglaDeDescuento reglaDeDescuento = new ReglaDeDescuento();
        // Entrada: total mayor que el límite
        double total = 25000;

        // Especifación: el descuento debe ser el máximo
        double descuentoEsperado = 1250;

        // Resultado esperado: el descuento calculado debe ser igual al descuento esperado
        double descuentoCalculado = reglaDeDescuento.CalcularDescuento(total);

        Assertions.assertEquals(descuentoEsperado, descuentoCalculado);
    }

    @Test
    public void testCalcularDescuentoConTotalMenorQueElLimite() {
        ReglaDeDescuento reglaDeDescuento = new ReglaDeDescuento();
        // Entrada: total menor que el límite
        double total = 15000;

        // Especifación: el descuento debe ser el inferior
        double descuentoEsperado = 750;

        // Resultado esperado: el descuento calculado debe ser igual al descuento esperado
        double descuentoCalculado = reglaDeDescuento.CalcularDescuento(total);

        Assertions.assertEquals(descuentoEsperado, descuentoCalculado);
    }

    @Test
    public void testCalcularDescuentoConTotalNegativo() {
        ReglaDeDescuento reglaDeDescuento = new ReglaDeDescuento();
        // Entrada: total negativo
        double total = -10000;

        // Especifación: el método debe lanzar una excepción

        // Resultado esperado: el método debe lanzar una excepción
        try {
            reglaDeDescuento.CalcularDescuento(total);
            Assertions.fail("El método no debe lanzar una excepción");
        } catch (IllegalArgumentException e) {
            // Se esperaba una excepción
        }
    }

}
