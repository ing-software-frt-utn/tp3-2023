package io.cucumber.tienda;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InicioSesionSteps {
    private boolean sesionIniciada = false;
    private String usuarioRegistrado;
    private String contraseñaRegistrada;

    public String getUsuarioRegistrado() {
        return usuarioRegistrado;
    }

    public String getContraseñaRegistrada() {
        return contraseñaRegistrada;
    }

    @Given("un punto de venta válido sin sesión iniciada")
    public void puntoDeVentaSinSesion() {
        sesionIniciada = false;
    }

    @Given("un usuario con los siguientes datos:")
    public void usuarioConDatos(io.cucumber.datatable.DataTable dataTable) {
        usuarioRegistrado = dataTable.cell(1, 0);
        contraseñaRegistrada = dataTable.cell(1, 1);
    }

    @When("solicito iniciar sesión con usuario {string} y contraseña {string}")
    public void iniciarSesion(String usuario, String contraseña) {
        if (usuario.equals(usuarioRegistrado) && contraseña.equals(contraseñaRegistrada)) {
            sesionIniciada = true;
        }
    }

    @Then("se inicia correctamente la sesión en el punto de venta")
    public void sesionIniciadaCorrectamente() {
        assertTrue(sesionIniciada);
    }
}
