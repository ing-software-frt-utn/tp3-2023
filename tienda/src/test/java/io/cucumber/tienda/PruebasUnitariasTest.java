package io.cucumber.tienda;

import io.cucumber.tienda.domain.*;
import io.cucumber.tienda.repositories.RepositorioArticulo;
import io.cucumber.tienda.services.ServicioBuscarArticulos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PruebasUnitariasTest {
    @Test
    public void testBuscarArticuloPorCodigo() {

        int codigoPrueba = 123;
        Articulo articuloSimulado = new Articulo(codigoPrueba, "DescripcionPrueba", "MarcaPrueba", "CategoriaPrueba", 150.0);

        RepositorioArticulo repositorioArticuloMock = Mockito.mock(RepositorioArticulo.class);

        Mockito.when(repositorioArticuloMock.buscarArticuloPorCodigo(codigoPrueba))
                .thenReturn(articuloSimulado);

        ServicioBuscarArticulos servicioArticulos = new ServicioBuscarArticulos(repositorioArticuloMock);
        Articulo articuloObtenido = servicioArticulos.buscarArticulos(codigoPrueba);

        Assertions.assertEquals(articuloSimulado, articuloObtenido);
    }
    @Test
    public void testBuscarArticuloPorCodigoMalIngresado() {

        Articulo articuloSimulado = new Articulo(1234, "DescripcionPrueba", "MarcaPrueba", "CategoriaPrueba", 150.0);

        RepositorioArticulo repositorioArticuloMock = Mockito.mock(RepositorioArticulo.class);

        Mockito.when(repositorioArticuloMock.buscarArticuloPorCodigo(1235))
                .thenThrow(new IllegalArgumentException("El id del artículo no es válido"));

        ServicioBuscarArticulos servicioArticulos = new ServicioBuscarArticulos(repositorioArticuloMock);

        Assertions.assertThrows(IllegalArgumentException.class , ()->servicioArticulos.buscarArticulos(1235));
    }
    @Test
    public void obtenerDescripcionArticuloExistente() {
        // Datos del artículo
        String idProducto = "1234";
        String descripcionOriginal = "Descripción original";
        String descripcionObtenida;

        // Creamos el artículo
        Articulo articulo = new Articulo(Integer.parseInt(idProducto), descripcionOriginal, "Marca", "Categoría", 100.0);

        // Solicitamos el cambio de descripción
        descripcionObtenida = articulo.getDescripcion();

        // Verificamos que la descripción se haya cambiado
        Assertions.assertEquals(descripcionOriginal, descripcionObtenida);
    }
}
