package io.cucumber.tienda;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.tienda.domain.*;
import io.cucumber.tienda.repositories.RepositorioCliente;
import io.cucumber.tienda.services.ServicioClientes;
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
    private RepositorioCliente repositorioCliente;
    @InjectMocks
    private ServicioClientes servicioClientes;
    Venta ventaIniciada;
    Cliente clienteDefecto;
    Cliente clienteNuevo;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    // Steps Definitions de AsociarCliente

    @Given("una venta en proceso con el cliente por defecto:")
    public void unaVentaEnProcesoConElClientePorDefecto(List<Map<String,String>> tabla) {
        ventaIniciada = new Venta((ArrayList<LineaDeVenta>) null);

        Map<String, String> item = tabla.get(0);
        String dni = item.get("DNI");
        String nombre = item.get("NOMBRE");
        CondicionTributaria condicionTributaria = new CondicionTributaria(item.get("CONDICION_TRIBUTARIA"));

        clienteDefecto = new Cliente(dni, nombre, condicionTributaria);
        Venta ventaSimulada = new Venta(clienteDefecto);

        Mockito.when(repositorioCliente.agregarAVenta(ventaIniciada, clienteDefecto))
                .thenReturn(ventaSimulada);

        ventaIniciada = servicioClientes.agregarClienteAVenta(ventaIniciada, clienteDefecto);
    }

    @And("un cliente registrado con los datos:")
    public void unClienteRegistradoConLosDatos(List<Map<String,String>> tabla) {
        Map<String, String> item = tabla.get(0);
        String dni = item.get("DNI");
        String nombre = item.get("NOMBRE");
        CondicionTributaria condicionTributaria = new CondicionTributaria(item.get("CONDICION_TRIBUTARIA"));

        clienteNuevo = new Cliente(dni, nombre, condicionTributaria);
    }

    @When("asocio al cliente con DNI {string} a la venta")
    public void asocioAlClienteConDNIALaVenta(String dni) {
        CondicionTributaria condicionTributariaSimulada = new CondicionTributaria("Responsable Inscripto");
        Cliente clienteSimulado = new Cliente(dni,"Juan Perez", condicionTributariaSimulada);
        Mockito.when(repositorioCliente.buscarClientePorDNI(dni))
                .thenReturn(clienteSimulado);
        Cliente nuevoCliente = servicioClientes.buscarClientePorDNI(dni);

        ventaIniciada.modificarCliente(nuevoCliente);
    }

    @Then("me queda la venta asociada al cliente {string} y el tipo de comprobante es {string}")
    public void meQuedaLaVentaAsociadaAlClienteYElTipoDeComprobanteEs(String nombre, String tipoComprobante) {
        Comprobante comprobanteResultante = new Comprobante(tipoComprobante);

        CondicionTributaria condicionTributariaSimulada = new CondicionTributaria("Responsable Inscripto");
        Cliente clienteSimulado = new Cliente("43654213", nombre, condicionTributariaSimulada);
        Mockito.when(repositorioCliente.buscarClientePorNombre(nombre))
                .thenReturn(clienteSimulado);
        Cliente clienteResultante = servicioClientes.buscarClientePorNombre(nombre);

        assertEquals(clienteResultante.getDni(), ventaIniciada.getCliente().getDni());
        assertEquals(clienteResultante.getNombre(), ventaIniciada.getCliente().getNombre());
        assertEquals(clienteResultante.getCondicionTributaria().getTipo(), ventaIniciada.getCliente().getCondicionTributaria().getTipo());

        assertEquals(comprobanteResultante.getTipo(), ventaIniciada.getComprobante().getTipo());
    }

    /*
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
    */
}