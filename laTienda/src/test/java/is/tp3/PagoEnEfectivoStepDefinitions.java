package is.tp3;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import is.tp3.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PagoEnEfectivoStepDefinitions {
    Venta v;
    @Given("una venta con los datos:")
    public void una_venta_con_los_datos(List<Map<String, String>> tabla) {
        Cliente cliente = new Cliente ();
        Articulo articulo = new Articulo();
        articulo.setCodigo(1);
        articulo.setNombre("Calza");
        articulo.setCosto(10000.0);
        articulo.setMargenGanancia(0.5);
        double total = 0.0;
        v = new Venta();
        for (Map<String, String> fila : tabla) {
            int numero = Integer.parseInt(fila.get("numero"));
            String fecha = fila.get("fecha");
            String dni = fila.get("dni");
            v.setNumero(numero);
            v.setFecha(fecha);
            cliente.setDNI(dni);
            total = Double.parseDouble(fila.get("total"));
        }
        List<LineaVenta> lineasVenta = new ArrayList<>();
        lineasVenta.add(v.crearLineaVenta(articulo, 1));
        v.setLineasVenta(lineasVenta);
        v.setNumero(1);
        v.setFecha("2021-05-01");
        v.setCliente(cliente);
        assertEquals(total, v.getTotal());
    }
    @When("selecciono pagar en efectivo")
    public void selecciono_pagar_en_efectivo() {
        Pago pago = new Pago();
        pago.setTipoPago(TipoPago.EFECTIVO);
        pago.setMonto(v.getTotal());
        v.setPago(pago);
    }

    @Then("se actualiza el tipo de pago a efectivo")
    public void se_actualiza_el_tipo_de_pago_a_efectivo() {
        assertEquals("EFECTIVO", v.getPago().getTipoPago().toString());
    }

}
