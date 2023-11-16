package edu.spring.istfi.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticuloTest {

    @Test
    public void crearArticuloNormal(){
        assertDoesNotThrow(() -> new Articulo("remera",100,10));
    }

    @Test
    public void crearArticuloConCostoNegativo(){
        RuntimeException exception = assertThrows(RuntimeException.class,() -> new Articulo("remera",-100,10));
        assertEquals("No se puede crear articulos con costo negativo",exception.getMessage());
    }

    @Test
    public void crearArticuloConMargenDeGananciaNegativo(){
        RuntimeException exception = assertThrows(RuntimeException.class,() -> new Articulo("remera",100,-10));
        assertEquals("No se puede crear articulos con margen de ganancia negativo",exception.getMessage());
    }

    @Test
    public void calcularPrecioDeVenta(){
        Articulo articulo = new Articulo("remera",100,10);
        double precioDeVenta = articulo.getPrecioDeVenta();

        assertEquals(133.1,precioDeVenta);
    }

}