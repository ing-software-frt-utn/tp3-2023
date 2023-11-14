package is.tp3;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import is.tp3.domain.Articulo;
import is.tp3.repositories.RepositorioArticulo;
import is.tp3.services.ServicioBuscarArticulo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static  org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class StepDefinitions {

    private ArrayList<Articulo> articulos;
    private Articulo articulo;
    public RepositorioArticulo repositorioMock;

    @Before
    public void setUp(){
        repositorioMock = mock(RepositorioArticulo.class);
    }

    @Given("existen los siguientes articulos:")
    public void existen_los_siguientes_articulos(List<Map<String, String>> tabla) {
        articulos = new ArrayList<Articulo>();
        for (Map<String, String> fila : tabla) {
            Integer codigo = Integer.parseInt(fila.get("Codigo"));
            String marca = fila.get("Marca");
            String descripcion = fila.get("Descripcion");
            Integer precio = Integer.parseInt(fila.get("Precio"));
            articulos.add(new Articulo(codigo, marca, descripcion, precio));
        }

        when(repositorioMock.buscarArticulo(anyInt()))
                .then(answer -> {
                    Integer codigo = answer.getArgument(0);
                    return articulos
                            .stream()
                            .filter(a-> a.tieneCodigo(codigo))
                            .findFirst().get();
                });
    }

    @When("ingreso el codigo {int}")
    public void ingreso_el_codigo(Integer codigo) {
        ServicioBuscarArticulo servicio = new ServicioBuscarArticulo(repositorioMock);
        articulo = servicio.buscarArticulo(codigo);
    }

    @Then("se muestra la siguiente informacion del articulo:")
    public void se_muestra_la_siguiente_informacion_del_articulo(List<Map<String, String>> tabla) {
        ArrayList<Articulo> esperados = new ArrayList<Articulo>();
        for (Map<String, String> fila : tabla) {
            Integer codigo = Integer.parseInt(fila.get("Codigo"));
            String marca = fila.get("Marca");
            String descripcion = fila.get("Descripcion");
            Integer precio = Integer.parseInt(fila.get("Precio"));
            esperados.add(new Articulo(codigo, marca, descripcion, precio));
        }
        Articulo esperado = esperados.get(0);

        assertEquals(esperado.getCodigo(), articulo.getCodigo());
        assertEquals(esperado.getDescripcion(), articulo.getDescripcion());
        assertEquals(esperado.getMarca(), articulo.getMarca());
        assertEquals(esperado.getPrecio(), articulo.getPrecio());
    }
}
