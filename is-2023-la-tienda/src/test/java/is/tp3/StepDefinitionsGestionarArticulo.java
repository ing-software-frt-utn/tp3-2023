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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SuppressWarnings("SpellCheckingInspection")
public class StepDefinitionsGestionarArticulo {

    private ArrayList<Articulo> articulos;
    private Articulo articulo;
    public RepositorioArticulo repositorioMock;
    private String mensajeError;

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
            Double precio = Double.parseDouble(fila.get("Precio"));
            articulos.add(new Articulo(codigo, marca, descripcion, precio));
        }

        when(repositorioMock.buscarArticulo(anyInt()))
                .then(answer -> {
                    Integer codigo = answer.getArgument(0);
                    return articulos
                            .stream()
                            .filter(a-> a.tieneCodigo(codigo))
                            .findFirst()
                            .orElseThrow(() -> new RuntimeException("Articulo Inexistente"));
                });
    }

    @When("ingreso el codigo {int}")
    public void ingreso_el_codigo(Integer codigo) {
        ServicioBuscarArticulo servicio = new ServicioBuscarArticulo(repositorioMock);

        try {
            articulo = servicio.buscarArticulo(codigo);
        }catch (RuntimeException e){
            mensajeError = e.getMessage();
        }

    }

    @Then("se muestra la siguiente informacion del articulo:")
    public void se_muestra_la_siguiente_informacion_del_articulo(List<Map<String, String>> tabla) {
        ArrayList<Articulo> esperados = new ArrayList<Articulo>();
        for (Map<String, String> fila : tabla) {
            Integer codigo = Integer.parseInt(fila.get("Codigo"));
            String marca = fila.get("Marca");
            String descripcion = fila.get("Descripcion");
            Double precio = Double.parseDouble(fila.get("Precio"));
            esperados.add(new Articulo(codigo, marca, descripcion, precio));
        }
        Articulo esperado = esperados.get(0);

        assertEquals(esperado.getCodigo(), articulo.getCodigo());
        assertEquals(esperado.getDescripcion(), articulo.getDescripcion());
        assertEquals(esperado.getMarca(), articulo.getMarca());
        assertEquals(esperado.getPrecio(), articulo.getPrecio());
    }

    @Then("se muestra el mensaje siguiente {string}")
    public void seMuestraElMensajeSiguiente(String mensajeEsperado) {
        assertEquals(mensajeEsperado, mensajeError);
    }

}