package io.cucumber.tienda;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.tienda.domain.*;
import io.cucumber.tienda.services.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class AgregarArticuloStepDefinitions {

    private Venta venta;
    private Articulo articuloSeleccionado;
    private Inventario inventario;

    @Given("existe una venta en proceso")
    public void existe_una_venta_en_proceso() {
        venta = new Venta();
    }

    @Given("un articulo con el siguente detalle codigo {string}, marca {string}, descripcion {string}, precio {string}")
    public void un_articulo_con_el_siguente_detalle_codigo_marca_descripcion_precio(String codigo, String marca, String descripcion, String precio) {
        // Write code here that turns the phrase above into concrete actions
        double precio1 = Double.parseDouble(precio);

        articuloSeleccionado = new Articulo(codigo, marca, descripcion, precio1);
    }

    @Given("existen los siguientes talles y colores para el articulo en la sucursal talle {string}, color {string}, stock {string}")
    public void existen_los_siguientes_talles_y_colores_para_el_articulo_en_la_sucursal_talle_color_stock(String talle, String color, String stock) {
        int stock1 = Integer.parseInt(stock);
        Inventario inventario = new Inventario(talle, color, stock1);

    }

    @When("selecciona talle {string}, color {string}, stock {string}")
    public void selecciona_talle_color_stock(String string, String string2, String string3) {
        articuloSeleccionado.setInventario(inventario);
        LineaVenta lineaVenta = new LineaVenta(articuloSeleccionado);
        venta.addLineaVenta(lineaVenta);
    }



    @Then("se agrega la seleccion a la linea de venta")
    public void se_agrega_la_seleccion_a_la_linea_de_venta() {
        assertEquals(1, venta.getLineaVenta().size());
    }

    @And("se muestra el sub total correspondiente")
    public void se_muestra_el_sub_total_correspondiente() {

        double subTotal = venta.calcularSubtotal();
        assertEquals(2000, subTotal);

    }


}