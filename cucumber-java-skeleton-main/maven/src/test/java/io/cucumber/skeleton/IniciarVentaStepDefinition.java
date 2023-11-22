package io.cucumber.skeleton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.skeleton.domain.Cliente;
import io.cucumber.skeleton.domain.Venta;

public class IniciarVentaStepDefinition {
    @Given("un cliente con nombre {string} y condición tributaria {string} con DNI {string}")
    public void un_cliente_con_nombre_y_condición_tributaria_con_dni(String nombre, String condicionTributaria, String dni) {
        Cliente cliente = new Cliente(nombre, condicionTributaria, dni);
    }
    @When("el vendedor inicia una nueva venta para el cliente con condición tributaria {string}")
    public void el_vendedor_inicia_una_nueva_venta_para_el_cliente_con_condición_tributaria(String string) {
        Venta venta = new Venta();
    }
    @Then("la nueva venta está asociada a los datos del cliente nuevo")
    public void la_nueva_venta_está_asociada_a_los_datos_del_cliente_nuevo(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }

}
