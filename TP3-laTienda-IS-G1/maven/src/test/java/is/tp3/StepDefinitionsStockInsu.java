package is.tp3;
import is.tp3.domain.Stock;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class StepDefinitionsStockInsu {
    @Given("existen las siguientes combinaciones para el articulo ingresado")
    public void existen_las_siguientes_combinaciones_para_el_articulo_ingresado(List<Map<String,String>> Lista) {
        ArrayList<Stock> stock = new ArrayList<Stock>();
        for(Map<String,String>fila: Lista){
            Integer codigo= Integer.parseInt(fila.get("Codigo"));
            String talle=fila.get("Talle");
            String color= fila.get("color");
            Integer cantidad= Integer.parseInt(fila.get("Cantidad"));
        }
    }
    @When("ingreso cantidad igual a {int}")
    public void ingreso_cantidad_igual_a(Integer int1) {

    }
    @Then("muestra un mensaje {string}")
    public void muestra_un_mensaje(String mensaje3) {
        String mensaje2= mensaje3;
        System.out.println(mensaje2);

    }


}
