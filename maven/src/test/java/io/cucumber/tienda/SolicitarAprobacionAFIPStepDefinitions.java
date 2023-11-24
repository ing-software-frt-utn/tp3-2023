package io.cucumber.tienda;

import io.cucumber.tienda.domain.Venta;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class SolicitarAprobacionAFIPStepDefinitions {
    @Given("una venta en estado pendiente")
    public void una_venta_en_estado_pendiente() {
       Venta venta = new Venta();
    }

    @When("solicito autorizacion de AFIP")
    public void solicito_autorizacion_de_afip() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("recibo una respuesta Aprobada")
    public void recibo_una_respuesta_aprobada() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("recibo una respuesta Aprobada con obs")
    public void recibo_una_respuesta_aprobada_con_obs() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("la venta cambia a estado Aprobado")
    public void la_venta_cambia_a_estado_aprobado() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("recibo una respuesta Rechazado")
    public void recibo_una_respuesta_rechazado() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("la venta cambia a estado Rechazado")
    public void la_venta_cambia_a_estado_rechazado() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
