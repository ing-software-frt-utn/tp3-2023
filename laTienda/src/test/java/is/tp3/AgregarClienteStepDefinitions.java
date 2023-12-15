package is.tp3;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import is.tp3.domain.Articulo;
import is.tp3.domain.Cliente;
import is.tp3.domain.LineaVenta;
import is.tp3.domain.Venta;
import repository.ClienteRepository;
import service.ClienteService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AgregarClienteStepDefinitions {
    ClienteRepository clienteRepository;
    ClienteService clienteService = new ClienteService(clienteRepository);
    private Venta v;
    private Cliente c;

    @Given("una venta:")
    public void una_venta(List<Map<String, String>> tabla) {
        v = new Venta();
        Articulo articulo = new Articulo();
        articulo.setCodigo(1);
        articulo.setNombre("Calza");
        articulo.setCosto(10000.0);
        articulo.setMargenGanancia(0.5);
        List<LineaVenta> lineasVenta = new ArrayList<>();
        lineasVenta.add(v.crearLineaVenta(articulo, 1));
        v.setLineasVenta(lineasVenta);
        double total = 0.0;
        for (Map<String, String> fila : tabla) {
            int numero = Integer.parseInt(fila.get("numero"));
            String fecha = fila.get("fecha");
            total = Double.parseDouble(fila.get("total"));
            v.setNumero(numero);
            v.setFecha(fecha);
        }
        assertEquals(v.getTotal(),total);
    }

    @When("ingreso el dni del cliente {int} inexistente")
    public void ingreso_el_dni_del_cliente_inexistente(Integer int1) {
        boolean respuesta = clienteService.buscarClientePorDNI(int1.toString());
        assertFalse(respuesta);
    }

    @Then("completo los siguientes datos del formulario:")
    public void completo_los_siguientes_datos_del_formulario(List<Map<String, String>> tabla) {
        for (Map<String, String> fila : tabla) {
            String nomYAp = fila.get("Nombre y Apellido");
            String condicionTributaria = fila.get("Condicion Tributaria");
            String razonSocial = fila.get("Razon Social");
            String CUIT = fila.get("CUIT");
            String DNI = fila.get("DNI");
            String domicilio = fila.get("Domicilio");
            String localidad = fila.get("Localidad");
            c = new Cliente(nomYAp,condicionTributaria,razonSocial,CUIT,DNI,domicilio,localidad);
        }
    }

    @Then("se asocia el cliente a la venta")
    public void se_asocia_el_cliente_a_la_venta() {
        Cliente clienteEsperado = new Cliente("Fernando Alonso","RI","FA group","301234568912","123456891","Santiago 1600","Capital");
        assertEquals(clienteEsperado.getNomYAp(),c.getNomYAp());
        assertEquals(clienteEsperado.getCondicionTributaria(),c.getCondicionTributaria());
        assertEquals(clienteEsperado.getRazonSocial(),c.getRazonSocial());
        assertEquals(clienteEsperado.getCUIT(),c.getCUIT());
        assertEquals(clienteEsperado.getDNI(),c.getDNI());
        assertEquals(clienteEsperado.getDomicilio(),c.getDomicilio());
        assertEquals(clienteEsperado.getLocalidad(),c.getLocalidad());
        v.setCliente(c);
    }
}
