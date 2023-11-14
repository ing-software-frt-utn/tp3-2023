package is.tp3;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import is.tp3.domain.Pago;
import is.tp3.domain.TipoPago;
import is.tp3.domain.Venta;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PagoEnEfectivoStepDefinitions {
    private Venta v;
    @Given("una venta con los datos:")
    public void una_venta_con_los_datos(List<Map<String, String>> tabla) {
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

    @Given("el monto total de la venta es {double}")
    public void el_monto_total_de_la_venta_es(Double monto) {
        v.setTotal(monto);
        if(!(v.getTotal() < 92700.0)){
            throw new IllegalStateException("El monto es mayor a 92700");
        }
    }

    @When("selecciono pago en efectivo")
    public void selecciono_pago_en_efectivo() {
        Pago p = new Pago(v.getTotal(), TipoPago.EFECTIVO);
        v.setPago(p);
    }

    @Then("la venta pasa al estado {string}")
    public void la_venta_pasa_al_estado(String estado) {
        v.setEstado(estado);
        assertEquals("Pagada", v.getEstado());
    }
}
