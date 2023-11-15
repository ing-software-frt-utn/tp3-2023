package io.cucumber.tienda;
import io.cucumber.tienda.domain.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import io.cucumber.tienda.repositories.RepositorioArticulo;
import io.cucumber.tienda.services.ServicioArticulos;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

class PruebasUnitariasTest {

    @Test
    public void testClienteConsumidorFinalPorDefecto() {
        Cliente cliente = new Cliente();

        CondicionTributaria condicionTributariaEsperada = new CondicionTributaria("Consumidor Final");

        assertEquals(cliente.getCondicionTributaria().getTipo(), condicionTributariaEsperada.getTipo());
    }

    @Test
    public void testDeterminarTipoComprobanteDadaCondicionTributariaExento() {
        CondicionTributaria condicionTributaria = new CondicionTributaria("Exento");
        Cliente cliente = new Cliente(condicionTributaria);
        Comprobante comprobante = new Comprobante(cliente);

        Comprobante comprobanteEsperado = new Comprobante("Factura B");

        assertEquals(comprobante.getTipo(), comprobanteEsperado.getTipo());
    }

    @Test
    public void testBuscarArticuloPorCodigo() {

        int codigoPrueba = 123;
        Articulo articuloSimulado = new Articulo(codigoPrueba, "DescripcionPrueba", "MarcaPrueba", "CategoriaPrueba", 150.0);

        RepositorioArticulo repositorioArticuloMock = Mockito.mock(RepositorioArticulo.class);

        Mockito.when(repositorioArticuloMock.buscarArticuloPorCodigo(codigoPrueba))
                .thenReturn(articuloSimulado);

        ServicioArticulos servicioArticulos = new ServicioArticulos(repositorioArticuloMock);
        Articulo articuloObtenido = servicioArticulos.buscarArticulos(codigoPrueba);

        assertEquals(articuloSimulado, articuloObtenido);
    }
}
