package is.tp3;

import is.tp3.domain.ReglaDeDescuento;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReglaDeDescuentoTest {
    @ParameterizedTest
    @ValueSource(doubles = {4999,5000})
    public void CalcularDescuentoConValoresMenoresOIgualesA5000NoAplicaDescuento(double total){
        double esperado = 0;
        ReglaDeDescuento reglaDeDescuento = new ReglaDeDescuento();
        double resultado = reglaDeDescuento.Calcular(total);
        assertEquals(esperado,resultado);
    }
    @Test
    public void CalcularDescuentoConValoresMenoresOIgualesQueCeroArrojaExcepcion(){
        String excepcionEsperada = "El total debe ser mayor a 0";
        ReglaDeDescuento reglaDeDescuento = new ReglaDeDescuento();
        try{
            reglaDeDescuento.Calcular(-5);
        } catch(Exception e){
            assertEquals(excepcionEsperada,e.getMessage());
        }
    }
    @ParameterizedTest
    @ValueSource(doubles = {5500,8000,5000,4999,10001,10000})
    public void CalcularDescuentoConValoresMayoresA5000YMenoresOIgualesA10000AplicaPorcentajeMenor(double total){
        double porcentajeMenor = 0.03d;
        double esperado = total * porcentajeMenor;
        ReglaDeDescuento reglaDeDescuento = new ReglaDeDescuento();
        double resultado = reglaDeDescuento.Calcular(total);
        assertEquals(esperado,resultado);
    }

    @ParameterizedTest
    @ValueSource(doubles = {9999,10000,25000,25001})
    public void CalcularDescuentoConValoresMayoresA10000YMenoresOIgualesA25000AplicaPorcentajeMedio(double total){
        double porcentajeIntermedio = 0.05d;
        double esperado = total * porcentajeIntermedio;
        ReglaDeDescuento reglaDeDescuento = new ReglaDeDescuento();
        double resultado = reglaDeDescuento.Calcular(total);
        assertEquals(esperado,resultado);
    }

    @ParameterizedTest
    @ValueSource(doubles = {24999,25000,25500,28000})
    public void CalcularDescuentoConValoresMayoresA25000AplicaPorcentajeMayor(double total){
        double porcentajeMayor = 0.1d;
        double esperado = total * porcentajeMayor;
        ReglaDeDescuento reglaDeDescuento = new ReglaDeDescuento();
        double resultado = reglaDeDescuento.Calcular(total);
        assertEquals(esperado,resultado);
    }
}
