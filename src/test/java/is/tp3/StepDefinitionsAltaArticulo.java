package is.tp3;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import is.tp3.domain.Articulo;
import is.tp3.domain.Cliente;
import is.tp3.domain.LineaDeVenta;
import is.tp3.domain.Venta;
import is.tp3.repositories.RepositorioArticulo;
import is.tp3.repositories.RepositorioCliente;
import is.tp3.services.ServicioArticulo;
import is.tp3.services.ServicioClientes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static  org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class StepDefinitionsAltaArticulo {

    public Cliente cliente;
    private ArrayList<Articulo> articulos;

    public RepositorioArticulo repositorioMock;

    public ServicioArticulo servicio;

    private Articulo articulo;



    LineaDeVenta lineaDeVenta;

    public boolean seElimina = false;

    Venta venta;


    @Before
    public void setUp(){
        repositorioMock = mock(RepositorioArticulo.class);
        servicio = new ServicioArticulo(repositorioMock);

        when(repositorioMock.buscarArticulo(anyInt()))
                .then(answer -> {
                    int codigoArticulo = answer.getArgument(0);
                    return articulos
                            .stream()
                            .filter(a-> a.getCodigo() == codigoArticulo)
                            .findFirst().get();
                });

        // when(repositorioMock.buscarCliente(anyInt())).thenReturn(clientes.get(0));
    }
    @Given("que hay un artículo en la sucursal {string} con los siguientes atributos:")
    public void que_hay_un_artículo_en_la_sucursal_con_los_siguientes_atributos(String sucursal, List<Map<String, String>> tabla) {
        articulos = new ArrayList<Articulo>();
        for (Map<String, String> fila : tabla) {
            Integer codigo = Integer.parseInt(fila.get("Codigo"));
            String marca = fila.get("Marca");
            String descripcion = fila.get("Descripcion");
            Double precio = Double.parseDouble(fila.get("Precio"));
            String color = fila.get("Color");
            String talle = fila.get("Talle");
            Integer stock = Integer.parseInt(fila.get("Stock"));


            articulos.add(new Articulo(codigo, marca, descripcion, precio, color, talle, stock, sucursal));

        }
    }
    @Given("hay una venta en curso")
    public void hay_una_venta_en_curso() {
        venta = new Venta();
    }
    @When("se agregan {int} unidades del articulo con codigo {int}")
    public void se_agrega_unidades_del_articulo_con_codigo(Integer cantidad, Integer codigo) {


        articulo = servicio.buscarArticulo(codigo);
        verify(repositorioMock, times(1)).buscarArticulo(codigo);



        venta.agregarArticulo(articulo, cantidad);

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

}
