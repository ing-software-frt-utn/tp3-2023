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

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

public class StepDefinitionsArtNoExistente {
    Articulo articulo;
    public RepositorioArticulo repositorioMock;
    @Before
    public void setUp(){
        repositorioMock = mock(RepositorioArticulo.class);
    }

    @Given("el siguiente articulo")
    public void el_siguiente_articulo(List<Map<String,String>> arti ) {
        ArrayList<Articulo> art= new ArrayList<Articulo>();
        for(Map<String,String> item:arti){
            Integer codigo= Integer.parseInt(item.get("Codigo"));
            String marca= item.get("Marca");
            String descripcion=item.get("Descripcion");
            Integer precio= Integer.parseInt(item.get("Precio"));
            art.add(new Articulo(codigo,marca,descripcion,precio));
        }
    articulo = art.get(0);

    }
    @When("ingresa el codigo {int}")
    public void ingresa_el_codigo(Integer Codigo){
        articulo=null;
        ServicioBuscarArticulo buscar =new ServicioBuscarArticulo(repositorioMock);
        articulo= buscar.buscarArticulo(Codigo);
    }
    @Then("se muestra mensaje de error")
    public void se_muestra_mensaje_de_error() {
            assertNull(articulo,"El articulo no existe");
    }


}
