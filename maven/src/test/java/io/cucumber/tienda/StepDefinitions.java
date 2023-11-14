package io.cucumber.tienda;

import io.cucumber.tienda.domain.*;
import io.cucumber.tienda.services.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.tienda.services.ServicioVenta;

import java.util.List;
import java.util.Map;

public class StepDefinitions {

    Cliente cliente;
    ServicioVentaImpl servicioVenta = new ServicioVentaImpl();

    @Given("un cliente")
    public void un_cliente(List<Map<String,String>> tabla) {
        Map<String, String> data = tabla.get(0);

        String nombre = data.get("nombre");
        int dni = Integer.parseInt(data.get("dni"));
        String condicion = data.get("condicion tributaria");

        CondicionTributaria condicionTributaria = new CondicionTributaria(condicion);

        cliente = new Cliente(nombre, dni, condicionTributaria);
    }

    @When("se inicia una nueva venta")
    public void se_inicia_una_nueva_venta() {


        servicioVenta.iniciarNuevaVenta();

    }

    @Then("se asocia a la venta el cliente con dni {string}")
    public void se_asocia_a_la_venta_el_cliente_con_dni(String string) {

        servicioVenta.asociarClienteConVenta(cliente);

    }

    @Then("se asocia comprobante Factura B")
    public void se_asocia_comprobante_factura_b() {
        servicioVenta.asociarComprobante();
    }
    }

