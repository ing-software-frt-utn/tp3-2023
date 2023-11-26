package StepDefinitions;

import domain.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.Mockito;
import service.ServicioInventario;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BuscarArticuloSteps {

    Articulo articuloEsperado;
    ArrayList<Inventario> inventarioEsperado;
    ServicioInventario servicioI = Mockito.mock(ServicioInventario.class);


    @Given("el siguiente articulo")
    public void el_siguiente_articulo(List<Map<String,String>> articulo) {
        ArrayList<Articulo> articuloE = new ArrayList<Articulo>();
        for (Map<String, String> item : articulo) {
            Integer codigo = Integer.parseInt(item.get("Codigo"));
            Double precio = Double.parseDouble(item.get("Precio"));
            String marca = item.get("Marca");
            String categoria = item.get("Categoria");
            articuloE.add(new Articulo(codigo, precio, marca, categoria));
        }
        articuloEsperado = articuloE.get(0);
    }

    @Given("el siguiente inventario para el articulo")
    public void el_siguiente_inventario_para_el_articulo (List < Map < String, String >> inventario){
        ArrayList<Inventario> inventarioE = new ArrayList<Inventario>();
        for (Map<String, String> item : inventario) {
            String talle = item.get("Talle");
            String color = item.get("Color");
            String sucursal = item.get("Sucursal");
            Integer stock = Integer.parseInt(item.get("Stock"));
            inventarioE.add(new Inventario(talle, color, sucursal, stock));
        }
        inventarioEsperado = inventarioE;
    }

    @When("ingreso el codigo del articulo {int}")
    public void ingreso_el_codigo_del_articulo (Integer codigo){
        Mockito.when(servicioI.buscarArticulo(codigo)).thenReturn(articuloEsperado);
        Mockito.when(servicioI.buscarInventario(articuloEsperado)).thenReturn(inventarioEsperado);
    }

    @When("ingreso un codigo inexistente del articulo {int}")
    public void ingreso_un_codigo_inexistente_del_articulo(Integer codigo){
        articuloEsperado = null;
        Mockito.when(servicioI.buscarArticulo(codigo)).thenReturn(articuloEsperado);
    }

    @Then("se muestra los detalles del articulo")
    public void se_muestra_los_detalles_del_articulo (List<Map<String,String>> articulo){
        ArrayList<Articulo> articuloO = new ArrayList<Articulo>();
        for (Map<String, String> item : articulo) {
            Integer codigo = Integer.parseInt(item.get("Codigo"));
            Double precio = Double.parseDouble(item.get("Precio"));
            String marca = item.get("Marca");
            String categoria = item.get("Categoria");
            articuloO.add(new Articulo(codigo, precio, marca, categoria));
        }

        Articulo articuloObtenido= articuloO.get(0);
        assertAll("Verificar Artículo",
                () -> assertEquals(articuloEsperado.getCodigo(), articuloObtenido.getCodigo()),
                () -> assertEquals(articuloEsperado.getPrecio(), articuloObtenido.getPrecio()),
                () -> assertEquals(articuloEsperado.getMarca(), articuloObtenido.getMarca()),
                () -> assertEquals(articuloEsperado.getCategoria(), articuloObtenido.getCategoria())
        );

    }

    @Then("su correspondiente inventario")
    public void su_correspondiente_inventario (List < Map < String, String >> inventario){
        ArrayList<Inventario> inventarioObtenido = new ArrayList<Inventario>();
        for (Map<String, String> item : inventario) {
            String talle = item.get("Talle");
            String color = item.get("Color");
            String sucursal = item.get("Sucursal");
            Integer stock = Integer.parseInt(item.get("Stock"));
            inventarioObtenido.add(new Inventario(talle, color, sucursal, stock));
        }

        for (int i=0; i<inventarioObtenido.size();i++){
            assertEquals(inventarioObtenido.get(i).getTalle(),inventarioEsperado.get(i).getTalle());
            assertEquals(inventarioObtenido.get(i).getColor(),inventarioEsperado.get(i).getColor());
            assertEquals(inventarioObtenido.get(i).getSucursal(),inventarioEsperado.get(i).getSucursal());
            assertEquals(inventarioObtenido.get(i).getStock(),inventarioEsperado.get(i).getStock());
        }
    }

    @Then("se muestra un mensaje indicando la faltante de stock del articulo ingresado")
    public void se_muestra_un_mensaje_indicando_la_faltante_de_stock_del_articulo_ingresado() {
        boolean sinStock = inventarioEsperado.stream().allMatch(inv -> inv.getStock() == 0);
        assertTrue(sinStock, "No se encuentra stock para el articulo ingresado");
    }

    @Then("se muestra un mensaje indicando que el codigo ingresado no existe")
    public void se_muestra_un_mensaje_indicando_que_el_codigo_ingresado_no_existe() {
        
        assertNull(articuloEsperado, "El artículo ingresado no existe");
    }
}
