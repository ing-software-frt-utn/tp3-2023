package com.example.demo.servicio;

import com.example.demo.dominio.Producto;
import com.example.demo.repositorio.RepositorioProducto;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class ServicioRegistrarProductoTest {
    private ServicioRegistraProducto servicio;
    private RepositorioProducto repositorio;

    @Before
    public void setUp(){
        repositorio = mock(RepositorioProducto.class);
        servicio = new ServicioRegistraProducto(repositorio);
    }
    @Test
    public void crearProducto(){
        Producto producto = servicio.ingresarProductoCompleto("remera", 1000.0, 10.0, "M", "Azul");
        assertEquals(producto.getNombre(), "remera");
        assertEquals(producto.getCosto(), 1000.0);
        assertEquals(producto.getMargenGanancia(), 10.0);
        assertEquals(producto.getTalle(), "M");
        assertEquals(producto.getColor(), "Azul");

        verify(repositorio,times(1)).ingresarProducto(any(Producto.class));

    }
}
