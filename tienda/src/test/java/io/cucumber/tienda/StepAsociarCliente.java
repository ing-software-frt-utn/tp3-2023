package io.cucumber.tienda;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.tienda.domain.*;
import io.cucumber.tienda.repositories.RepositorioArticulo;
import io.cucumber.tienda.services.ServicioArticulos;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class StepAsociarCliente {

    @Mock
    private RepositorioArticulo repositorioArticulo;
    @InjectMocks
    private ServicioArticulos servicioArticulos;

    Articulo art;
    Articulo articuloVenta;
    Venta ventaIniciada;
    List<Inventario> inventarioEsperado;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    // Steps Definitions de AsociarCliente

    Cliente cliente;
    Venta ventaAsociada;

    @Given("un cliente con condicion tributaria {string}")
    public void unClienteConCondicionTributaria(String condTributaria) {
        CondicionTributaria condicion = new CondicionTributaria(condTributaria);
        cliente = new Cliente(condicion);
    }
    @And("una venta con el cliente asociado")
    public void unaVentaConElClienteAsociadoYTipoDeComprobante() {
        ventaAsociada = new Venta(cliente);
    }
    @When("modifico la condicion tributaria del cliente asociado a la venta a {string}")
    public void modificoLaCondicionTributariaDelClienteAsociadoA(String condTribNueva) {
        CondicionTributaria condicionTributaria = new CondicionTributaria(condTribNueva);
        ventaAsociada.modificarCondTribCliente(condicionTributaria);
    }
    @Then("se modifica en la venta el tipo de comprobante a {string}")
    public void seModificaEnLaVentaElTipoDeComprobante(String tipoCompEsperado) {
        Comprobante comprobanteEsperado = new Comprobante(tipoCompEsperado);
        assertEquals(ventaAsociada.getComprobante().getTipo(), comprobanteEsperado.getTipo());
    }
}