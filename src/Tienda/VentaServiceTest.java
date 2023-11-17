package Tienda;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class VentaServiceTest {

    private VentaService ventaService;
    private ProductoService productoService;

    @Before
    public void setUp() {
        // Inicializar instancias necesarias antes de cada prueba
        productoService = new ProductoService();
        ventaService = new VentaService(productoService);
    }

    @Test
    public void testVentaExitosa() {
        // Prueba 1: Realizar una venta correctamente
        assertTrue(ventaService.realizarVenta(123456, "Rojo", "M"));
    }

    @Test
    public void testVentaConCodigoNoValido() {
        // Prueba 2: Realizar una venta con un código de producto no válido
        assertFalse(ventaService.realizarVenta(123457, "Rojo", "M"));
    }

    @Test
    public void testVentaConStockInsuficiente() {
        // Prueba 5: Realizar una venta con un producto con stock insuficiente
        productoService.actualizarStock(123456, "Rojo", "M", -10); // Simular stock insuficiente
        assertFalse(ventaService.realizarVenta(123456, "Rojo", "M"));
    }
}

