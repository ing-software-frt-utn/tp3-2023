package reglaDescuento;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ReglaDeDescuentoTest {
    ReglaDeDescuento regla = new ReglaDeDescuento();
    @Test
    public void calcularDescuentoConNumeroMenorQueCeroYTireExcepcion(){
        double total = -1d;
        try{
            var resultado_total = regla.Calcular(total);
            fail();
        }catch(Exception e){
            assertEquals("El total debe ser mayor a 0", e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(doubles = {200,500,1000})
    public void calcularDescuentoConNumeroEntre0y5000(double total){
//        double total = 750d;
        var resultado_total =regla.Calcular(total);
        assertEquals(resultado_total, 0d);
    }

    @Test
    public void calcularDescuentoConNumeroEntre5000y10000(){
        double total = 7500d;
        var resultado_total =regla.Calcular(total);
        assertEquals(resultado_total, 225d);
    }
    @Test
    public void calcularDescuentoConNumeroEntre10000y25000(){
        double total = 25000d;
        var resultado_total =regla.Calcular(total);
        assertEquals(resultado_total, 1250d);
    }
    @Test
    public void calcularDescuentoConNumeroMayorDe25000(){
        double total = 30000d;
        var resultado_total =regla.Calcular(total);
        assertEquals(resultado_total, 3000d);
    }
}