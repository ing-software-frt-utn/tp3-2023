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

public class StepDefinitions {


    public Cliente cliente;
    private ArrayList<Cliente> clientes;

    public RepositorioCliente repositorioMock;

    public ServicioClientes servicio;

    private Articulo articulo;

    ArrayList<Articulo> articulos;

    LineaDeVenta lineaDeVenta;

    public boolean seElimina = false;

    Venta venta;

    @Before
    public void setUp(){
        repositorioMock = mock(RepositorioCliente.class);
        servicio = new ServicioClientes(repositorioMock);

        when(repositorioMock.buscarCliente(anyInt()))
                .then(answer -> {
                    int dniCliente = answer.getArgument(0);
                    return clientes
                            .stream()
                            .filter(a-> a.dni == dniCliente)
                            .findFirst().get();
                });

       // when(repositorioMock.buscarCliente(anyInt())).thenReturn(clientes.get(0));
    }
    @Given("que existen los siguientes Clientes con sus dni:")
    public void que_existen_los_siguientes_clientes_con_sus_dni(List<Map<String, String>> tabla) {
        clientes = new ArrayList<Cliente>();
        for (Map<String, String> fila : tabla) {
            String nombre = fila.get("nombre");
            Integer dni = Integer.parseInt(fila.get("dni"));



            clientes.add(new Cliente(nombre, dni));


        }

    }

    @When("busco un cliente con dni: {int}")
    public void selecciono_buscar_cliente(int dni) {
       cliente = servicio.buscarCliente(dni);
        verify(repositorioMock, times(1)).buscarCliente(dni);

    }
    @Then("el Cliente {string} se asocia a la Venta")
    public void el_cliente_nombre_se_asocia_a_la_venta(String nombre) {

        assertEquals(nombre, cliente.nombre);
    }








    //---------------------------------------------------------------------------------------------------------------





    @Given("que hay un artículo en la sucursal {string} con los siguientes atributos:")
    public void que_hay_un_artículo_en_la_sucursal_con_los_siguientes_atributos(String sucursal, List<Map<String, String>> tabla) {
        for (Map<String, String> fila : tabla) {
            Integer codigo = Integer.parseInt(fila.get("Codigo"));
            String marca = fila.get("Marca");
            String descripcion = fila.get("Descripcion");
            Double precio = Double.parseDouble(fila.get("Precio"));
            String color = fila.get("Color");
            String talle = fila.get("Talle");
            Integer stock = Integer.parseInt(fila.get("Stock"));

            articulo = new Articulo(codigo, marca, descripcion, precio, color, talle, stock, sucursal);
        }
    }
    @Given("hay una venta en curso")
    public void hay_una_venta_en_curso() {
        venta = new Venta();
    }
    @When("se agrega {int} unidades del articulo con codigo: {int}, color: {string}, talle: {string} a la venta")
    public void se_agrega_unidades_del_articulo_con_codigo_color_talle(Integer cantidad, Integer codigo, String color, String talle) {
       // if(codigo == articulo.getCodigo() && color == articulo.getColor() && talle == articulo.getTalle()){
        venta.agregarArticulo(articulo, cantidad);
        //}
    }
    @Then("se crea en la venta una linea de venta con el articulo de codigo: {int}, color: {string}, talle: {string} y cantidad: {int}")
    public void se_crea_en_la_venta_una_linea_de_venta_con_el_articulo_de_codigo_color_talle_y_cantidad(Integer codigo, String color, String talle, Integer cantidad) {
        ArrayList<LineaDeVenta> lineasDeVentas = venta.getLineasDeVentas();
      LineaDeVenta lv = lineasDeVentas.getLast();


        assertEquals(lv.getArticulo().getCodigo(), codigo);
        assertEquals(lv.getArticulo().getColor(), color);
        assertEquals(lv.getArticulo().getTalle(), talle);
        assertEquals(lv.getCantidadArticulos(), cantidad);
    }
    @Then("el total de la venta se incrementa en {double}")
    public void el_total_de_la_venta_se_incrementa_a(Double total) {
        assertEquals(venta.getTotal(), total);
    }




    //--------------------------------------------------------------------------------------------------------------------





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




