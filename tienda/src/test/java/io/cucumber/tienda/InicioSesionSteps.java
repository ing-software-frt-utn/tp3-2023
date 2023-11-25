package io.cucumber.tienda;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.tienda.domain.PuntoDeVenta;
import io.cucumber.tienda.domain.Usuario;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InicioSesionSteps {

    private PuntoDeVenta pdv;
    private Usuario user;

    @Given("un punto de venta válido sin sesión iniciada")
    public void un_punto_de_venta_valido_sin_sesion_iniciada() {
        pdv = new PuntoDeVenta(1,true);
    }

    @Given("un usuario con los siguientes datos:")
    public void existe_un_usuario_con_datos(io.cucumber.datatable.DataTable dataTable) {
        user = new Usuario(dataTable.cell(1, 0), dataTable.cell(1, 1));
    }

    @When("solicito iniciar sesión con usuario {string} y contraseña {string}")
    public void solicito_iniciar_sesion_con_usuario_y_contraseña(String usuario, String contraseña) {
        Usuario ingreso = new Usuario(usuario,contraseña);
        pdv.iniciarSesion(ingreso);
    }

    @Then("se inicia correctamente la sesión en el punto de venta")
    public void se_inicia_correctamente_la_sesion_en_el_punto_de_venta() {
        assertTrue(pdv.validarSesion());
    }
}
