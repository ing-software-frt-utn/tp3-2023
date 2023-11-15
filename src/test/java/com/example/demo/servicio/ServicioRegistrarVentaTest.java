package com.example.demo.servicio;

import com.example.demo.dominio.Venta;
import com.example.demo.dominio.Producto;
import com.example.demo.repositorio.RepositorioVenta;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class ServicioRegistrarVentaTest {
    private ServicioRegistrarVenta servicio;
    private RepositorioVenta repositorio;

    @Before
    public void setUp(){
        repositorio = mock(RepositorioVenta.class);
        servicio = new ServicioRegistrarVenta(repositorio);
    }
    @Test
    public void crearVenta(){
        Producto producto = new Producto("remera", 1000, 10, "M", "Azul");
        Venta venta = servicio.ingresarVenta("255", producto.precioVenta(), producto);
        assertEquals(venta.getMonto(), 1331.0);
        assertEquals(venta.getProducto(), producto);

        verify(repositorio,times(1)).ingresarVenta(any(Venta.class));

    }
}
