package is.tp3;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import is.tp3.domain.Articulo;
import is.tp3.domain.Cliente;
import is.tp3.domain.LineaDeVenta;
import is.tp3.domain.Venta;
import is.tp3.repositories.RepositorioCliente;
import is.tp3.services.ServicioClientes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static  org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
public class StepDefinitionsEliminar_linea_venta {


    public Cliente cliente;
    private ArrayList<Cliente> clientes;

    public RepositorioCliente repositorioMock;

    public ServicioClientes servicio;

    private Articulo articulo;

    ArrayList<Articulo> articulos;

    LineaDeVenta lineaDeVenta;

    public boolean seElimina = false;

    Venta venta;






    @Given("una venta en curso en la sucursal: {string} con dos articulos con los siguientes datos:")
    public void una_venta_en_curso_en_la_sucursal_con_dos_articulos_con_los_siguientes_datos(String sucursal, List<Map<String, String>> tabla) {

        venta = new Venta();

        articulos = new ArrayList<>();

        for (Map<String, String> fila : tabla) {
            Integer codigo = Integer.parseInt(fila.get("Codigo"));
            String marca = fila.get("Marca");
            String descripcion = fila.get("Descripcion");
            Double precio = Double.parseDouble(fila.get("Precio"));
            String color = fila.get("Color");
            String talle = fila.get("Talle");
            Integer stock = Integer.parseInt(fila.get("Stock"));

            articulo = new Articulo(codigo, marca, descripcion, precio, color, talle, stock, sucursal);

            articulos.add(articulo);
        }
    }
    @Given("cantidad del articulo de codigo {int} es igual a {int}")
    public void cantidad_del_articulo_de_codigo_es_igual_a(Integer codigo, Integer cantidad) {

        for (Articulo articulo : articulos) {

            if(articulo.getCodigo() == codigo){

                venta.agregarArticulo(articulo,cantidad);

            }
        }


    }

    @When("se elimina el articulo con codigo {int}")
    public void se_elimina_el_articulo_con_codigo(Integer codigo) {

        seElimina =  venta.quitarArticulo(codigo);
    }
    @Then("la linea de venta del articulo con codigo {int} se elimina")
    public void la_linea_de_venta_del_articulo_con_codigo_se_elimina(Integer codigo) {

        assertTrue(seElimina);

        assertNull(venta.obtenerArticulo(codigo));





    }

    @Then("se actualiza el total de la venta en {double}")
    public void se_actualiza_el_total_de_la_venta(double total) {
        assertEquals(venta.getTotal(), total);
    }


}
