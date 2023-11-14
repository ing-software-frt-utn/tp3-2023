package is.tp3;

import is.tp3.domain.Cliente;
import is.tp3.domain.Venta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VentaTest {

    @Test
    public void verificarTotalMenorA92700ConClientePorDefecto() {
        Cliente clientePorDefecto = new Cliente (0, null, null, null, null, null);
        Venta venta = new Venta(clientePorDefecto, 90000.0);
        assertDoesNotThrow(() -> venta.verificarFinalizacionVenta());
    }

    @Test
    public void verificarTotalMayorA92700ConClienteAsociado() {
        Cliente clienteAsociado = new Cliente (123, "CF", null, "John Doe", null, null);
        Venta venta = new Venta(clienteAsociado, 93000.0);
        assertDoesNotThrow(() -> venta.verificarFinalizacionVenta());
    }

    @Test
    public void verificarTotalMayorA92700ConClientePorDefecto() {
        Cliente clientePorDefecto = new Cliente (0, null, null, null, null, null);
        Venta venta = new Venta(clientePorDefecto, 93000.0);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> venta.verificarFinalizacionVenta());
        assertEquals("ERROR. Debido a que el monto total es mayor a $92.700, debe asociar un cliente a la venta.", exception.getMessage());
    }
}
