package stepsCucumber;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepsCucumber {

	@Given("existen los siguientes productos:")
    public void cargarProductos(List<Map<String, String>> dataTable) {
        // Lógica para cargar productos desde el DataTable
    }

    @When("se ingresa el código {string}")
    public void ingresarCodigo(String codigo) {
        // Lógica para ingresar el código del producto
    }

    @Then("el sistema muestra:")
    public void verificarProducto(List<Map<String, String>> dataTable) {
        // Lógica para verificar la información del producto mostrada por el sistema
    }

    @Then("el sistema muestra un mensaje: {string}")
    public void verificarMensaje(String mensaje) {
        // Lógica para verificar el mensaje mostrado por el sistema
    }
	
}
