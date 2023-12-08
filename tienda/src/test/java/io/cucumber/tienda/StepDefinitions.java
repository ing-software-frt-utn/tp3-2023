package io.cucumber.tienda;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.tienda.domain.*;
import io.cucumber.tienda.repositories.RepositorioArticulo;
import io.cucumber.tienda.services.ServicioArticulos;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
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
    private ServicioArticulos servicioArticulos;

    Articulo art;
    Articulo articuloVenta;
    Venta ventaIniciada;
    List<Inventario> inventarioEsperado;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Given("una venta en proceso")
    public void una_venta_en_proceso() {
        ventaIniciada = new Venta((ArrayList<LineaDeVenta>) null);
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
        articuloVenta = articulos.get(0);
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
        Articulo articuloSimulado = new Articulo(codigo,"Camisa Mangas Largas","Polo","Camisas", 1000.00);
        Mockito.when(repositorioArticulo.buscarArticuloPorCodigo(codigo))
                .thenReturn(articuloSimulado);
        art = servicioArticulos.buscarArticulos(codigo);

        ArrayList<Inventario> inventarioSimulado = new ArrayList<>();
        inventarioSimulado.add(new Inventario("Centro", "M", "Rojo", "10"));
        inventarioSimulado.add(new Inventario("Centro", "S", "Rojo", "15"));
        Mockito.when(repositorioArticulo.buscarInventarioPorArticulo(art))
                .thenReturn(inventarioSimulado);
        inventarioEsperado = servicioArticulos.buscarInventario(art);
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

        assertEquals(esperado.getCodigo(), art.getCodigo());
        assertEquals(esperado.getDescripcion(), art.getDescripcion());
        assertEquals(esperado.getMarca(), art.getMarca());
        assertEquals(esperado.getCategoria(), art.getCategoria());
        assertEquals(esperado.getPrecio(), art.getPrecio());

    }

    @Then("la siguiente informacion del stock:")
    public void la_siguiente_informacion_del_stock(List<Map<String,String>> tabla) {
        ArrayList<Inventario> inventarios = new ArrayList<Inventario>();
        for (Map<String,String> item : tabla){
            String sucursal = item.get("Sucursal");
            String talle = item.get("Talle");
            String color = item.get("Color");
            String cantidad = item.get("Cantidad");
            inventarios.add(new Inventario(sucursal,talle,color,cantidad));
        }

        for (int i=0; i<inventarios.size();i++){
            assertEquals(inventarios.get(i).getSucursal(),inventarioEsperado.get(i).getSucursal());
            assertEquals(inventarios.get(i).getTalle(),inventarioEsperado.get(i).getTalle());
            assertEquals(inventarios.get(i).getColor(),inventarioEsperado.get(i).getColor());
            assertEquals(inventarios.get(i).getCantidad(),inventarioEsperado.get(i).getCantidad());
        }
    }

    @When("selecciono con cantidad {string} la siguiente combinacion:")
    public void selecciono_con_cantidad_la_siguiente_combinacion(String cantidad, List<Map<String,String>> tabla) {
        Map<String, String> item = tabla.get(0);
        String color = item.get("Color");
        String talle = item.get("Talle");
        Double subtotal = (double) (Integer.parseInt(cantidad) * articuloVenta.getPrecio());
        LineaDeVenta lineaDeVenta = new LineaDeVenta(articuloVenta.getCodigo(),articuloVenta.getDescripcion(),articuloVenta.getPrecio(),color,talle,cantidad,subtotal);
        ArrayList<LineaDeVenta> lineasSimuladas = new ArrayList<LineaDeVenta>();
        lineasSimuladas.add(lineaDeVenta);

        Venta ventaSimulado = new Venta(lineasSimuladas);

        Mockito.when(repositorioArticulo.agregarLineaDeVenta(ventaIniciada,lineaDeVenta))
                .thenReturn(ventaSimulado);
        ventaIniciada = servicioArticulos.agregarArticuloAVenta(ventaIniciada,lineaDeVenta);
    }
    @Then("la linea de venta sera de la siguiente manera:")
    public void la_linea_de_venta_sera_de_la_siguiente_manera(List<Map<String,String>> tabla) {
        ArrayList<LineaDeVenta> lineaDeVentas = new ArrayList<LineaDeVenta>();
        for (Map<String,String> item: tabla) {
            Integer codigo = Integer.parseInt(item.get("Codigo"));
            String descripcion = item.get("Descripcion");
            Double precio = Double.parseDouble(item.get("PrecioUnitario"));
            String color = item.get("Color");
            String talle = item.get("Talle");
            String cantidad = item.get("Cantidad");
            Double subtotal = Double.parseDouble(item.get("Subtotal"));

            lineaDeVentas.add(new LineaDeVenta(codigo,descripcion,precio,color,talle,cantidad,subtotal));
        }

        LineaDeVenta lineaDeVentaEsperada = lineaDeVentas.get(0);
        LineaDeVenta lineaDeVentaObtenida = ventaIniciada.getLineaDeVentas().get(0);

        assertEquals(lineaDeVentaEsperada.getCodigo(), lineaDeVentaObtenida.getCodigo());
        assertEquals(lineaDeVentaEsperada.getCantidad(), lineaDeVentaObtenida.getCantidad());
        assertEquals(lineaDeVentaEsperada.getColor(), lineaDeVentaObtenida.getColor());
        assertEquals(lineaDeVentaEsperada.getDescripcion(), lineaDeVentaObtenida.getDescripcion());
        assertEquals(lineaDeVentaEsperada.getTalle(), lineaDeVentaObtenida.getTalle());
        assertEquals(lineaDeVentaEsperada.getPrecioUnitario(), lineaDeVentaObtenida.getPrecioUnitario());
        assertEquals(lineaDeVentaEsperada.getSubtotal(), lineaDeVentaObtenida.getSubtotal());
    }
    @Then("el total de la venta sera {double} .")
    public void el_total_de_la_venta_sera(Double total) {
        assertEquals(ventaIniciada.getTotal(),total);
    }
}
