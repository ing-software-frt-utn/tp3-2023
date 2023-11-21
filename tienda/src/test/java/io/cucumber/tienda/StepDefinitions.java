package io.cucumber.tienda;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.tienda.domain.*;
import io.cucumber.tienda.repositories.*;
import io.cucumber.tienda.services.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class StepDefinitions {
    @Mock
    private RepositorioArticulo repositorioArticulo;
    @InjectMocks
    private ServicioBuscarArticulos servicioBuscarArticulos;
    Articulo artEsperado;
    ArrayList<Inventario> invEsperado;

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
        artEsperado = articulos.get(0);
    }

    @Given("el inventario disponible para una combinacion de talles y colores para la sucursal {string} es la siguiente:")
    public void el_inventario_disponible_para_una_combinacion_de_talles_y_colores_para_la_sucursal_centro_es_la_siguiente(String sucursal,List<Map<String,String>> tabla) {
        invEsperado = new ArrayList<Inventario>();
        for (Map<String,String> item : tabla){
            String talle = item.get("Talle");
            String color = item.get("Color");
            String cantidad = item.get("Stock");
            invEsperado.add(new Inventario(sucursal,talle,color,cantidad));
        }
    }

    @When("ingreso el codigo del articulo {int}")
    public void ingreso_el_codigo_del_articulo(Integer codigo) {
        ServicioBuscarArticulos servicioArticulos = Mockito.mock(ServicioBuscarArticulos.class);
        Mockito.when(servicioArticulos.buscarArticulos(codigo)).thenReturn(artEsperado);
        Mockito.when(servicioArticulos.buscarInventarios(codigo)).thenReturn(invEsperado);
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
        assertEquals(esperado,artEsperado);
    }

    @Then("la siguiente informacion del stock:")
    public void la_siguiente_informacion_del_stock(List<Map<String,String>> tabla) {
        ArrayList<Inventario> inventarios = new ArrayList<Inventario>();
        for (Map<String,String> item : tabla){
            String sucursal = item.get("Sucursal");
            String talle = item.get("Talle");
            String color = item.get("Color");
            String cantidad = item.get("Stock");
            inventarios.add(new Inventario(sucursal,talle,color,cantidad));
        }
        for (int i=0; i<inventarios.size();i++){
            assertEquals(inventarios.get(i).getSucursal(),invEsperado.get(i).getSucursal());
            assertEquals(inventarios.get(i).getTalle(),invEsperado.get(i).getTalle());
            assertEquals(inventarios.get(i).getColor(),invEsperado.get(i).getColor());
            assertEquals(inventarios.get(i).getCantidad(),invEsperado.get(i).getCantidad());
        }
    }

}


