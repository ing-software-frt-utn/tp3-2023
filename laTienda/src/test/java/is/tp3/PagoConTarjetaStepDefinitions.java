package is.tp3;

import io.cucumber.java.en.*;
import is.tp3.domain.*;
import service.TarjetaCreditoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PagoConTarjetaStepDefinitions {
    Venta v;
    TarjetaCredito tarjeta;
    TarjetaCreditoService service = new TarjetaCreditoService();
    SolicitudAutorizacionPago solicitud;
    String respuesta;

    @Given("una venta en curso con total de {double}")
    public void una_venta_en_curso_con_total_de(Double total) {
        v = new Venta();
        Articulo articulo = new Articulo();
        articulo.setCodigo(1);
        articulo.setNombre("Calza");
        articulo.setCosto(10000.0);
        articulo.setMargenGanancia(0.5);
        List<LineaVenta> lineasVenta = new ArrayList<>();
        lineasVenta.add(v.crearLineaVenta(articulo, 1));
        v.setLineasVenta(lineasVenta);
        assertEquals(total, v.getTotal());
    }

    @Given("tengo los datos de la tarjeta:")
    public void tengo_los_datos_de_la_tarjeta(List<Map<String, String>> tabla) {
         tarjeta = new TarjetaCredito();
        for (Map<String, String> fila : tabla) {
            Long DNI = Long.parseLong(fila.get("DNI"));
            String numeroTarjeta = fila.get("Numero de Tarjeta");
            Long codigoSeguridad = Long.parseLong(fila.get("Codigo de seguridad"));
            String fechaVencimiento = fila.get("Fecha vencimiento");
            String nombreTitular = fila.get("Nombre titular");
            tarjeta.setDniTitular(DNI);
            tarjeta.setNumero(numeroTarjeta);
            tarjeta.setCodigoSeguridad(codigoSeguridad);
            tarjeta.setFechaVencimiento(fechaVencimiento);
            tarjeta.setNombrePropietario(nombreTitular);
            System.out.println(tarjeta);
        }
    }
    @When("solicito autorizacion de pago al sistema externo de pago con tarjeta")
    public void solicito_autorizacion_de_pago_al_sistema_externo_de_pago_con_tarjeta() {
        solicitud = new SolicitudAutorizacionPago(tarjeta, v.getTotal());
        respuesta = service.solicitudDeAprobacionDePago(solicitud);
        solicitud.setEstado(respuesta);
    }
    @Then("la solicitud pasa al estado de {string}")
    public void la_solicitud_pasa_al_estado_de(String estado) {
            assertEquals(estado, solicitud.getEstado());
    }
}
