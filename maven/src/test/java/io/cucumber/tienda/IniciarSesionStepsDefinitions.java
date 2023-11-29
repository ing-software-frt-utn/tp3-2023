import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertTrue;
import io.cucumber.tienda.domain.*;

public class StepDefinitions {
    private PuntoVenta puntoVenta;
    private Usuario usuario;

    @Given("que existe un punto de venta con el número {int}")
    public void que_existe_un_punto_de_venta_con_el_numero(Integer num) {
        puntoVenta = new PuntoVenta(num);
    }

    @Given("un usuario con nombre de usuario {string} y contraseña {string}")
    public void un_usuario_con_nombre_de_usuario_y_contrasena(String nombreUsuario, String contrasena) {
        usuario = new Usuario(nombreUsuario, contrasena);
    }

    @When("el usuario inicia sesión en el punto de venta")
    public void el_usuario_inicia_sesion_en_el_punto_de_venta() {
        puntoVenta.iniciarSesion(usuario);
    }

    @Then("el punto de venta debería tener una sesión activa")
    public void el_punto_de_venta_deberia_tener_una_sesion_activa() {
        assertTrue(puntoVenta.comprobarSesion());
    }
}
