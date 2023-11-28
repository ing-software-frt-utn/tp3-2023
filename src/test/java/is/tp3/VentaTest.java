package is.tp3;

import is.tp3.domain.Articulo;
import is.tp3.domain.Venta;
import is.tp3.repositories.RepositorioArticulo;
import is.tp3.repositories.RepositorioCliente;
import is.tp3.services.ServicioArticulo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

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



    @Test
    public void laCantidadDebeSerIgualOMenorQueElStockTest(){

        Articulo articulo = new Articulo(123, "Lacoste", "Camisa", 1200.0, "Azul", "xl", 3, "sucursal");

        Venta venta = new Venta();



          String resultado =  venta.agregarArticulo(articulo,3);






            assertEquals("Se agrego el articulo con exito",resultado);




    }



    }

