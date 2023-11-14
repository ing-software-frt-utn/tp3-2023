package is.tp3;

import io.cucumber.java.en.Then;

public class StepDefinitionsArtNoExistente {
    @Then("se muestra mensaje de error {string}")
    public void se_muestra_mensaje_de_error(String mensajeError) {
        String mensaje = mensajeError;
        System.out.println(mensaje);

    }

}
