package is.tp3;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import is.tp3.domain.Articulo;
import is.tp3.domain.Stock;
import is.tp3.domain.Venta;
import is.tp3.repositories.RepositorioArticulo;
import is.tp3.services.ServicioBuscarArticulo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StepDefinitionsListarArt {


    Articulo articulo;
    public RepositorioArticulo repositorioMock;
    @Before
    public void setUp(){
        repositorioMock = mock(RepositorioArticulo.class);
    }

    @Given("una venta en proceso")
    public void una_venta_en_proceso() {
        Venta venta= new Venta();
    }
    @Given("existen los siguientes articulos en stock:")
    public void existen_los_siguientes_articulos_en_stock(List<Map<String,String>> tabla){
        ArrayList<Articulo> articulos1= new ArrayList<Articulo>();
        for(Map<String,String> fila:tabla){
            Integer codigo= Integer.parseInt(fila.get("Codigo"));
            String marca= fila.get("Marca");
            String descripcion= fila.get("Descripcion");
            Integer precio= Integer.parseInt(fila.get("Precio"));
            articulos1.add(new Articulo(codigo,marca,descripcion,precio));
        }

        when(repositorioMock.buscarArticulo(anyInt()))
                .then(answer -> {
                    Integer codigo = answer.getArgument(0);
                    return articulos1
                            .stream()
                            .filter(a-> a.tieneCodigo(codigo))
                            .findFirst().get();
                });

    }

    @Given("existen las siguientes combinaciones de talle y color:")
    public void existen_las_siguientes_combinaciones_de_talle_y_color(List<Map<String,String>>lista) {
    ArrayList<Stock> stock=new ArrayList<Stock>();
    for(Map<String,String> fila:lista){
        Integer codigo=Integer.parseInt(fila.get("Codigo"));
        String talle= fila.get("Talle");
        String color= fila.get("Color");
        Integer cantidad = Integer.parseInt(fila.get("Cantidad"));
        stock.add(new Stock(codigo,talle,color,cantidad));
    }



    }
    @When("se ingresa el codigo {int}")
    public void se_ingresa_el_codigo(Integer codigo){
    ServicioBuscarArticulo buscar= new ServicioBuscarArticulo(repositorioMock);
    articulo= buscar.buscarArticulo(codigo);

    }


    @Then("muestra la siguiente informacion del articulo:")
    public void muestra_la_siguiente_informacion_del_articulo(List<Map<String,String>>tabla) {
       ArrayList<Articulo> artEsperados = new ArrayList<Articulo>();
       for(Map<String,String> fila : tabla){
           Integer codigo= Integer.parseInt(fila.get("Codigo"));
           String marca= fila.get("Marca");
           String descripcion =fila.get("Descripcion");
           Integer precio = Integer.parseInt(fila.get("Precio"));
           artEsperados.add(new Articulo(codigo, marca, descripcion, precio));
       }
    Articulo esperado = artEsperados.get(0);
        assertEquals(esperado.getCodigo(), articulo.getCodigo());
        assertEquals(esperado.getDescripcion(), articulo.getDescripcion());
        assertEquals(esperado.getMarca(), articulo.getMarca());
        assertEquals(esperado.getPrecio(), articulo.getPrecio());




    }
    @Then("se muestra la siguiente informacion del articulo solicitado:")
    public void se_muestra_la_siguiente_informacion_del_articulo_solicitado(List<Map<String,String>> tabla){
        ArrayList<Stock> stock1= new ArrayList<Stock>();
        for(Map<String,String> fila:tabla){
            Integer codigo= Integer.parseInt(fila.get("Codigo"));
            String talle= fila.get("Talle");
            String color= fila.get("Color");
            Integer cantidad= Integer.parseInt(fila.get("Cantidad"));
            stock1.add(new Stock(codigo,talle,color,cantidad));

        }

    }

}
