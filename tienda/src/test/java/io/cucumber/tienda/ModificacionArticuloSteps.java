package io.cucumber.tienda;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.tienda.domain.Articulo;
import org.junit.runner.RunWith;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ModificacionArticuloSteps {
    private Articulo articulo;

    @Given("existe un producto con los siguientes datos:")
    public void productoExistente(List<Map<String, String>> tabla) {
        ArrayList<Articulo> articulos = new ArrayList<Articulo>();
        for(Map<String,String> item:tabla){
            Integer id = Integer.parseInt(item.get("Id"));
            String descripcion = item.get("Descripción");
            String marca = item.get("Marca");
            String categoria = item.get("Categoría");
            articulos.add(new Articulo(id, descripcion, marca, categoria));
        }
        articulo = articulos.get(0);
    }

    @When("solicito cambiar la descripción del producto {string} a {string}")
    public void cambioDescripcionProducto(String idProducto, String nuevaDescripcion) {
        if (articulo.getCodigo().toString().equals(idProducto)) {
            articulo.setDescripcion(nuevaDescripcion);
        }
    }

    @Then("se cambian los datos del producto por:")
    public void datosArticuloModificados(List<Map<String, String>> tabla) {
        ArrayList<Articulo> articulos = new ArrayList<Articulo>();
        for(Map<String,String> item:tabla){
            Integer id = Integer.parseInt(item.get("Id"));
            String descripcion = item.get("Descripción");
            String marca = item.get("Marca");
            String categoria = item.get("Categoría");
            articulos.add(new Articulo(id, descripcion, marca, categoria));
        }
        Articulo articuloModificado = articulos.get(0);
        assertEquals(articuloModificado, articulo);
    }
}
