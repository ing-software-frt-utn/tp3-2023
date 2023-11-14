package is.tp3;

import io.cucumber.java.en.*;
import is.tp3.domain.TarjetaCredito;
import is.tp3.domain.Venta;
import service.TarjetaCreditoService;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PagoConTarjetaStepDefinitions {
    Venta v;
    TarjetaCredito tarjeta;
    TarjetaCreditoService service = new TarjetaCreditoService();
    @Given("una venta en curso con los datos:")
    public void una_venta_en_curso_con_los_datos(List<Map<String, String>> tabla) {
        v = new Venta();
        for (Map<String, String> fila : tabla) {
            int numero = Integer.parseInt(fila.get("numero"));
            String fecha = fila.get("fecha");
            String estado = fila.get("estado");
            Double total = Double.parseDouble(fila.get("total"));
            v.setNumero(numero);
            v.setFecha(fecha);
            v.setEstado(estado);
            v.setTotal(total);
        }
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
        service.solicitudDeAprobacionDePago(tarjeta, v.getTotal());
    }

    @When("recibo como respuesta {string}")
    public void recibo_como_respuesta(String string) {
        String respuesta = service.solicitudDeAprobacionDePago(tarjeta, v.getTotal());
        assertEquals(string, respuesta);
    }

    @Then("la venta pasa al estado de {string}")
    public void la_venta_pasa_al_estado_de(String string) {
        v.setEstado("aceptada");
        assertEquals(string,v.getEstado());
    }
}
