package is.tp3;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import is.tp3.domain.Cliente;
import is.tp3.domain.Venta;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SuppressWarnings("SpellCheckingInspection")
public class StepDefinitionsPagoEfectivo {

    private Venta ventaEnCurso;
    private String mensajeVenta;

    @Given("la venta con la siguiente informacion:")
    public void la_venta_con_la_siguiente_informacion(List<Map<String, String>> tabla) {
        double total = 0;
        int clienteAsociadoDNI = 0;

        for (Map<String, String> fila : tabla) {
            total = Double.parseDouble(fila.get("Total"));
            clienteAsociadoDNI = Integer.parseInt(fila.get("Cliente Asociado"));
        }

        Cliente clienteAsociado = new Cliente (clienteAsociadoDNI, null, null, null, null, null);
        ventaEnCurso = new Venta(clienteAsociado, total);
    }

    @When("selecciono el metodo de pago en efectivo")
    public void selecciono_el_metodo_de_pago_en_efectivo() {
        ventaEnCurso.establecerMetodoPago("Efectivo");
    }

    @When("quiero finalizar la venta")
    public void quiero_finalizar_la_venta() {
        try {
            ventaEnCurso.verificarFinalizacionVenta();
        } catch (RuntimeException e) {
            mensajeVenta = e.getMessage();
        }
    }

    @Then("se muestra el mensaje {string}")
    public void se_muestra_el_mensaje(String mensajeEsperado) {
        assertEquals(mensajeEsperado, mensajeVenta);
    }

    @Then("la venta contiene la siguiente informacion:")
    public void la_venta_contiene_la_siguiente_informacion(List<Map<String, String>> tabla) {
        double totalEsperado = 0;
        int clienteAsociadoEsperadoDNI = 0;
        String metodoPagoEsperado = "";

        for (Map<String, String> fila : tabla) {
            totalEsperado = Double.parseDouble(fila.get("Total"));
            clienteAsociadoEsperadoDNI = Integer.parseInt(fila.get("Cliente Asociado"));
            metodoPagoEsperado = fila.get("Metodo de Pago");
        }

        assertNotEquals(mensajeVenta, "ERROR. Debido a que el monto total es mayor a $92.700, debe asociar un cliente a la venta.");

        assertEquals(totalEsperado, ventaEnCurso.getTotalVenta());
        assertEquals(clienteAsociadoEsperadoDNI, ventaEnCurso.getClienteAsociado().getDni());
        assertEquals(metodoPagoEsperado, ventaEnCurso.getMetodoPago());
    }
}
