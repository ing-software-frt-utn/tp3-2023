package io.cucumber.skeleton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AgregarArticuloStepDefinition {
    @Given("una venta en curso")
    public void una_venta_en_curso() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("selecciono un artículo {string} por su talle {string} color {string}, precio {string}, stock {string}, en sucursal {string} de la lista de artículos encontrados")
    public void selecciono_un_artículo_por_su_talle_color_precio_stock_en_sucursal_de_la_lista_de_artículos_encontrados(String string, String string2, String string3, String string4, String string5, String string6) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("se ingresa la cantidad de artículos necesarios {string}")
    public void se_ingresa_la_cantidad_de_artículos_necesarios(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("se agrega el artículo a la lista de artículos de la venta")
    public void se_agrega_el_artículo_a_la_lista_de_artículos_de_la_venta(io.cucumber.datatable.DataTable dataTable) {
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
