package is.tp3;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import is.tp3.domain.Cliente;
import is.tp3.domain.Venta;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgregarClienteStepDefinitions {
    private Venta v;
    private Cliente c;

    @Given("una venta:")
    public void una_venta(List<Map<String, String>> tabla) {
        v = new Venta();
        for (Map<String, String> fila : tabla) {
            int numero = Integer.parseInt(fila.get("numero"));
            String fecha = fila.get("fecha");
            String estado = fila.get("estado");
            v.setNumero(numero);
            v.setFecha(fecha);
            v.setEstado(estado);
        }
    }

    @Given("no existe un cliente asociado a la venta")
    public void no_existe_un_cliente_asociado_a_la_venta() {
        assertEquals(null,v.getCliente());
    }
    
    @When("completo los siguientes datos del formulario:")
    public void completo_los_siguientes_datos_del_formulario(List<Map<String, String>> tabla) {
         c = new Cliente();
        for (Map<String, String> fila : tabla) {
            String nomYAp = fila.get("Nombre y Apellido");
            String condicionTributaria = fila.get("Condicion Tributaria");
            String razonSocial = fila.get("Razon Social");
            String CUIT = fila.get("CUIT");
            String DNI = fila.get("DNI");
            String domicilio = fila.get("Domicilio");
            String localidad = fila.get("Localidad");
            c.setNomYAp(nomYAp);
            c.setCondicionTributaria(condicionTributaria);
            c.setCUIT(CUIT);
            c.setDNI(DNI);
            c.setDomicilio(domicilio);
            c.setLocalidad(localidad);
            c.setRazonSocial(razonSocial);
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
