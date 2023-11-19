package is.tp3;

import is.tp3.domain.Articulo;
import is.tp3.domain.Venta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VentaTest {

    @Test
    public void laVentaDebePoderEliminarUnArticulo(){

        Articulo articulo = new Articulo(123, "Lacoste", "Camisa", 1200.0, "Azul", "xl", 3, "sucursal");

        Venta venta = new Venta();

        venta.agregarArticulo(articulo,1);



        boolean resultado = venta.quitarArticulo(123);



        assertTrue(resultado);
        assertNull(venta.obtenerArticulo(123));

    }
}
