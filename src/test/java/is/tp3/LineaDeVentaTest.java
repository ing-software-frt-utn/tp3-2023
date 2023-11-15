package is.tp3;

import io.cucumber.java.tr.Ve;
import is.tp3.domain.Articulo;
import is.tp3.domain.LineaDeVenta;
import is.tp3.domain.Venta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LineaDeVentaTest {

    @Test
    public void debeCalcularElSubtotalEnFuncionDeLaCantidadYPrecio(){

        Articulo articulo = new Articulo(123, "Lacoste", "Camisa", 1200.0, "Azul", "xl", 3, "sucursal");

        LineaDeVenta lineaDeVenta = new LineaDeVenta();

        double esperado = 2400.0;

        lineaDeVenta.agregarArticuloALineaDeVenta(2, articulo);

       double resultado =  lineaDeVenta.getSubTotal();

       assertNotNull(resultado);
        assertEquals(esperado, resultado);

    }




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
