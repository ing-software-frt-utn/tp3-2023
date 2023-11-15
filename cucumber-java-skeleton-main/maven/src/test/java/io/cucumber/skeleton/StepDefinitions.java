package io.cucumber.skeleton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.cucumber.skeleton.domain.Inventario;
import io.cucumber.skeleton.domain.Venta;
import io.cucumber.skeleton.services.ServicioBuscarArticulos;

import io.cucumber.skeleton.domain.Articulo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class StepDefinitions {
    Articulo articulo;
    @Given("una venta en proceso")
    public void una_venta_en_proceso() {
        // Write code here that turns the phrase above into concrete actions
        Venta venta = new Venta();
    }

    @Given("un articulo con código {int} con los siguientes datos:")
    public void un_articulo_con_código_con_los_siguientes_datos(Integer codigo, List<Map<String,String>> tabla) {
        ArrayList<Articulo> articulos = new ArrayList<Articulo>();
        for (Map<String, String> item: tabla){
            String descripcion = item.get("Descripcion");
            String marca = item.get("Marca");
            String categoria = item.get("Categoria");
            Double precio = Double.parseDouble(item.get("Precio"));
            articulos.add(new Articulo(codigo, descripcion, marca, categoria, precio));
        }
    }


    @Given("el inventario disponible para una combinación de talles y colores para la sucursal {string} es la siguiente:")
    public void el_inventario_disponible_para_una_combinación_de_talles_y_colores_para_la_sucursal_es_la_siguiente(String sucursal, List<Map<String,String>> tabla) {

        ArrayList<Inventario> inventariosCentro = new ArrayList<Inventario>();
        for (Map<String, String> item: tabla){
            String talle = item.get("Talle");
            String color = item.get("Color");
            String cantidad = item.get("Cantidad");
            inventariosCentro.add(new Inventario(sucursal, talle, color, cantidad));
        }

    }

    @When("ingreso el código de artículo {int}")
    public void ingreso_el_código_de_artículo(Integer codigo) {
        ServicioBuscarArticulos servicioBuscarArticulos = new ServicioBuscarArticulos();
        Articulo articulo = servicioBuscarArticulos.buscarArticulo(codigo);
    }

    @Then("se obtiene la siguiente información del artículo:")
    public void se_obtiene_la_siguiente_información_del_artículo(List<Map<String,String>> tabla) {
        ArrayList<Articulo> articulos = new ArrayList<Articulo>();
        for (Map<String, String> item: tabla){
            Integer codigo = Integer.parseInt(item.get("Codigo"));
            String descripcion = item.get("Descripcion");
            String marca = item.get("Marca");
            String categoria = item.get("Categoria");
            Double precio = Double.parseDouble(item.get("Precio"));
            articulos.add(new Articulo(codigo, descripcion, marca, categoria, precio));
        }
        Articulo esperado = articulos.get(0);

        assertEquals(esperado, articulo);
    }

    @Then("la siguiente información del stock:")
    public void la_siguiente_información_del_stock(io.cucumber.datatable.DataTable dataTable) {
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
