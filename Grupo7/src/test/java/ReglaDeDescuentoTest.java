import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReglaDeDescuentoTest {

    @Test
    void calcularTotalNegativo() {
        // Given
        ReglaDeDescuento reglaDescuento = new ReglaDeDescuento();

        // When
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            reglaDescuento.Calcular(0);
        });

        // Then
        Assertions.assertEquals("El total debe ser mayor a 0", thrown.getMessage());
    }

    @Test
    void calcularEntre5000y10000() {
        // Given
        ReglaDeDescuento reglaDescuento = new ReglaDeDescuento();

        // When
        double resultadoEsperado = 6000 * 0.03d;
        double resultadoObtenido = reglaDescuento.Calcular(6000);

        // Then
        Assertions.assertEquals(resultadoEsperado, resultadoObtenido);
    }

    @Test
    void calcular5000() {
        // Given
        ReglaDeDescuento reglaDescuento = new ReglaDeDescuento();

        // When
        double resultadoObtenido = reglaDescuento.Calcular(5000);

        // Then
        Assertions.assertEquals(0, resultadoObtenido);
    }

    @Test
    void calcular10000() {
        // Given
        ReglaDeDescuento reglaDescuento = new ReglaDeDescuento();

        // When
        double resultadoEsperado = 10000 * 0.03d;
        double resultadoObtenido = reglaDescuento.Calcular(10000);

        // Then
        Assertions.assertEquals(resultadoEsperado, resultadoObtenido);
    }

    @Test
    void calcularMayor10000() {
        // Given
        ReglaDeDescuento reglaDescuento = new ReglaDeDescuento();

        // When
        double resultadoEsperado = 10001 * 0.05d;
        double resultadoObtenido = reglaDescuento.Calcular(10001);

        // Then
        Assertions.assertEquals(resultadoEsperado, resultadoObtenido);
    }

    @Test
    void calcular25000() {
        // Given
        ReglaDeDescuento reglaDescuento = new ReglaDeDescuento();

        // When
        double resultadoEsperado = 25000 * 0.05d;
        double resultadoObtenido = reglaDescuento.Calcular(25000);

        // Then
        Assertions.assertEquals(resultadoEsperado, resultadoObtenido);
    }

    @Test
    void calcularMayor25000() {
        // Given
        ReglaDeDescuento reglaDescuento = new ReglaDeDescuento();

        // When
        double resultadoEsperado = 26000 * 0.10d;
        double resultadoObtenido = reglaDescuento.Calcular(26000);

        // Then
        Assertions.assertEquals(resultadoEsperado, resultadoObtenido);
    }
}