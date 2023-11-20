package StepDefinitions;

import domain.EstadoVenta;
import domain.Venta;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.Mockito;
import service.ServicioVenta;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class AutorizarVentaPorAfipSteps {

    Venta venta;

    @Given("una venta en curso en estado pendiente")
    public void una_venta_en_curso_en_estado_pendiente() {
        Venta ventaEnCurso = new Venta(EstadoVenta.PENDIENTE);
        venta = ventaEnCurso;
    }
    @When("solicito autorizacion a la AFIP")
    public void solicito_autorizacion_a_la_afip() {
        ServicioVenta servicioV = Mockito.mock(ServicioVenta.class);
        Mockito.when(servicioV.SolicitarAutorizacionVentaAFIP(venta)).thenReturn(true);
    }
    @When("recibo {string}")
    public void recibo(String respuesta) {
        ServicioVenta servicioV = Mockito.mock(ServicioVenta.class);
        Mockito.when(servicioV.RecibirResultadoAFIP(respuesta)).thenReturn(venta);
        if (Objects.equals(respuesta, "Aprueba")) venta.setEstadoVenta(EstadoVenta.APROBADA);
        if (Objects.equals(respuesta, "Rechaza")) venta.setEstadoVenta(EstadoVenta.RECHAZADA);
        if (Objects.equals(respuesta, "ApruebaConObservaciones")) venta.setEstadoVenta(EstadoVenta.APROBADACONOBSERVACIONES);
    }

    @Then("La venta pasa a {string}")
    public void la_venta_pasa_a(String estado) {
        assertEquals(estado.toUpperCase(), venta.getEstadoVenta().toString());
    }
}
