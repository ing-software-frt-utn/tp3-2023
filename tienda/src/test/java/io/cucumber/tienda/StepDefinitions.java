package io.cucumber.tienda;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.tienda.domain.Articulo;
import io.cucumber.tienda.domain.Inventario;
import io.cucumber.tienda.domain.Venta;
import io.cucumber.tienda.services.ServicioBuscarArticulos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {
    Articulo art;

    @Given("una venta en proceso")
    public void una_venta_en_proceso() {
        Venta venta = new Venta();
    }

    @Given("un articulo con codigo {int} con los siguientes datos:")
    public void un_articulo_con_codigo_con_los_siguientes_datos(Integer codigo, List<Map<String,String>> tabla) {
        ArrayList<Articulo> articulos = new ArrayList<Articulo>();
        for (Map<String,String> item : tabla){
            String descripcion = item.get("Descripcion");
            String marca = item.get("Marca");
            String categoria = item.get("Categoria");
            Double precio = Double.parseDouble(item.get("Precio"));
            articulos.add(new Articulo(codigo,descripcion,marca,categoria,precio));
        }

    }

    @Given("el inventario disponible para una combinacion de talles y colores para la sucursal {string} es la siguiente:")
    public void el_inventario_disponible_para_una_combinacion_de_talles_y_colores_para_la_sucursal_centro_es_la_siguiente(String sucursal,List<Map<String,String>> tabla) {
        ArrayList<Inventario> inventarios = new ArrayList<Inventario>();
        for (Map<String,String> item : tabla){
            String talle = item.get("Talle");
            String color = item.get("Color");
            String cantidad = item.get("Cantidad");
            inventarios.add(new Inventario(sucursal,talle,color,cantidad));
        }

    }

    @When("ingreso el codigo del articulo {int}")
    public void ingreso_el_codigo_del_articulo(Integer codigo) {
        ServicioBuscarArticulos buscarArticulos = new ServicioBuscarArticulos();
        art = buscarArticulos.buscarArticulos(codigo);
    }

    @Then("se obtiene la siguiente informacion del articulo:")
    public void se_obtiene_la_siguiente_informacion_del_articulo(List<Map<String,String>> tabla) {
        ArrayList<Articulo> articulos = new ArrayList<Articulo>();
        for (Map<String,String> item : tabla){
            Integer codigo = Integer.parseInt(item.get("Codigo"));
            String descripcion = item.get("Descripcion");
            String marca = item.get("Marca");
            String categoria = item.get("Categoria");
            Double precio = Double.parseDouble(item.get("Precio"));
            articulos.add(new Articulo(codigo,descripcion,marca,categoria,precio));
        }

        Articulo esperado = articulos.get(0);

        assertEquals(esperado,art);

    }

    @Then("la siguiente informacion del stock:")
    public void la_siguiente_informacion_del_stock(io.cucumber.datatable.DataTable dataTable) {
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
