package StepDefinitions;

import domain.EstadoVenta;
import domain.Venta;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.Mockito;
import service.ServicioVenta;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutorizarVentaPorAFIPSteps {
    Venta venta = new Venta();
    ServicioVenta servicioVenta = Mockito.mock(ServicioVenta.class);

    @Given("una venta en curso en estado pendiente")
    public void una_venta_en_curso_en_estado_pendiente() {
        venta.setEstadoVenta(EstadoVenta.PENDIENTE);
    }

    @When("solicito autorizacion a la AFIP")
    public void solicito_autorizacion_a_la_afip() {
        Mockito.when(servicioVenta.SolicitarAutorizacionVentaAFIP(venta)).thenReturn(true);
    }

    @When("recibo {string}")
    public void recibo(String respuesta) {
        Boolean estadoAfip = respuesta.equals("Aprobacion");
        Mockito.when(servicioVenta.RecibirResultadoAFIP(respuesta)).thenReturn(estadoAfip);
        venta.AutorizacionAFIP(estadoAfip);
    }

    @Then("La venta pasa a {string}")
    public void la_venta_pasa_a(String estado) {
        assertEquals(estado, venta.getEstadoVenta().toString());
    }
}