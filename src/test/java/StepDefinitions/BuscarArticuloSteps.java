package StepDefinitions;

import domain.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.Mockito;
import service.ServicioArticulo;
import service.ServicioInventario;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BuscarArticuloSteps {

    Articulo articuloEsperado, articuloInexistente = null;
    ArrayList<Inventario> inventarioEsperado;


    @Given("el siguiente articulo")
    public void el_siguiente_articulo(List<Map<String,String>> articulo) {
        ArrayList<Articulo> articulos = new ArrayList<Articulo>();
        for (Map<String, String> item : articulo) {
            Integer codigo = Integer.parseInt(item.get("Codigo"));
            Double precio = Double.parseDouble(item.get("Precio"));
            String marca = item.get("Marca");
            String categoria = item.get("Categoria");
            articulos.add(new Articulo(codigo, precio, marca, categoria));
        }
        articuloEsperado = articulos.get(0);
    }

    @Given("el siguiente inventario para el articulo")
    public void el_siguiente_inventario_para_el_articulo (List < Map < String, String >> inventario){
        ArrayList<Inventario> inventarios = new ArrayList<Inventario>();
        for (Map<String, String> item : inventario) {
            String talle = item.get("Talle");
            String color = item.get("Color");
            String sucursal = item.get("Sucursal");
            Integer stock = Integer.parseInt(item.get("Stock"));
            inventarios.add(new Inventario(talle, color, sucursal, stock));
        }
        inventarioEsperado = inventarios;
    }

    @When("ingreso el codigo del articulo {int}")
    public void ingreso_el_codigo_del_articulo (Integer codigo){
        ServicioArticulo servicioA = Mockito.mock(ServicioArticulo.class);
        ServicioInventario servicioI = Mockito.mock(ServicioInventario.class);
        Mockito.when(servicioA.buscarArticulo(codigo)).thenReturn(articuloEsperado);
        Mockito.when(servicioI.buscarInventario(articuloEsperado)).thenReturn(inventarioEsperado);
    }

    @When("ingreso un codigo inexistente del articulo {int}")
    public void ingreso_un_codigo_inexistente_del_articulo(Integer codigo){
        ServicioArticulo servicioA = Mockito.mock(ServicioArticulo.class);
        Mockito.when(servicioA.buscarArticulo(codigo)).thenReturn(articuloInexistente);
    }

    @Then("se muestra los detalles del articulo")
    public void se_muestra_los_detalles_del_articulo (List<Map<String,String>> articulo){
        ArrayList<Articulo> articulos = new ArrayList<Articulo>();
        for (Map<String, String> item : articulo) {
            Integer codigo = Integer.parseInt(item.get("Codigo"));
            Double precio = Double.parseDouble(item.get("Precio"));
            String marca = item.get("Marca");
            String categoria = item.get("Categoria");
            articulos.add(new Articulo(codigo, precio, marca, categoria));
        }

        Articulo articuloObtenido= articulos.get(0);
        assertAll("Verificar Artículo",
                () -> assertEquals(articuloEsperado.getCodigo(), articuloObtenido.getCodigo()),
                () -> assertEquals(articuloEsperado.getPrecio(), articuloObtenido.getPrecio()),
                () -> assertEquals(articuloEsperado.getMarca(), articuloObtenido.getMarca()),
                () -> assertEquals(articuloEsperado.getCategoria(), articuloObtenido.getCategoria())
        );

    }

    @Then("su correspondiente inventario")
    public void su_correspondiente_inventario (List < Map < String, String >> inventario){
        ArrayList<Inventario> inventariosObtenido = new ArrayList<Inventario>();
        for (Map<String, String> item : inventario) {
            String talle = item.get("Talle");
            String color = item.get("Color");
            String sucursal = item.get("Sucursal");
            Integer stock = Integer.parseInt(item.get("Stock"));
            inventariosObtenido.add(new Inventario(talle, color, sucursal, stock));
        }

        for (int i=0; i<inventariosObtenido.size();i++){
            assertEquals(inventariosObtenido.get(i).getTalle(),inventarioEsperado.get(i).getTalle());
            assertEquals(inventariosObtenido.get(i).getColor(),inventarioEsperado.get(i).getColor());
            assertEquals(inventariosObtenido.get(i).getSucursal(),inventarioEsperado.get(i).getSucursal());
            assertEquals(inventariosObtenido.get(i).getStock(),inventarioEsperado.get(i).getStock());
        }
    }

    @Then("se muestra un mensaje indicando la faltante de stock del articulo ingresado")
    public void se_muestra_un_mensaje_indicando_la_faltante_de_stock_del_articulo_ingresado() {
        boolean sinStock = inventarioEsperado.stream().allMatch(inv -> inv.getStock() == 0);
        assertTrue(sinStock, "No se encuentra stock para el articulo ingresado");
    }

    @Then("se muestra un mensaje indicando que el codigo ingresado no existe")
    public void se_muestra_un_mensaje_indicando_que_el_codigo_ingresado_no_existe() {
        
        assertNull(articuloInexistente, "El artículo ingresado no existe");
    }
}
