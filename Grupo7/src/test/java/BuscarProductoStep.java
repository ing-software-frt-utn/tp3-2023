import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.domain.Stock;
import org.example.repositorios.RepositorioStock;
import org.example.servicios.ServicioBuscarProducto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.*;
import java.util.stream.Collectors;

import static org.mockito.Mockito.*;

public class BuscarProductoStep {

    private ServicioBuscarProducto servicio;

    private String mensajeError;
    private List<Stock> resultado;
    private RepositorioStock repositorioMockeado;

    @Before
    public void setUp() {
        this.repositorioMockeado = mock(RepositorioStock.class);
        this.servicio = new ServicioBuscarProducto(repositorioMockeado);
    }

    @Given("que existen los siguientes productos:")
    public void queExistenLosSiguientesProductos(List<Map<String, String>> tabla) {
        List<Stock> stocks = new ArrayList<>();

        for(Map<String, String> fila: tabla) {
            int codigo = Integer.parseInt(fila.get("código"));
            String color = fila.get("color");
            String talle = fila.get("talle");
            int stock = Integer.parseInt(fila.get("stock"));

            stocks.add(new Stock(codigo, color, talle, stock));
        }

        when(repositorioMockeado.buscarStockDisponiblePorCodigo(anyInt())).then(answer -> {
            int codigo = answer.getArgument(0);
            return stocks.stream().filter(stock -> stock.tieneCodigo(codigo) && stock.hayStock()).collect(Collectors.toList());
        });
    }

    @When("se ingresa el código “{int}”")
    public void seIngresaElCódigo(int codigoProducto) {
        try {
            this.resultado = servicio.buscarStockDisponible(codigoProducto);
        }catch (Exception exception){
            this.mensajeError = exception.getMessage();
        }

    }

    @Then("el sistema muestra")
    public void elSistemaMuestra(List<Map<String, String>> tabla) {
        List<Stock> stocks = new ArrayList<>();

        for(Map<String, String> fila: tabla) {
            int codigo = Integer.parseInt(fila.get("código"));
            String color = fila.get("color");
            String talle = fila.get("talle");
            int stock = Integer.parseInt(fila.get("stock"));

            stocks.add(new Stock(codigo, color, talle, stock));
        }

        Assertions.assertEquals(resultado.size(), stocks.size());
    }

    @Then("el sistema muestra el siguiente mensaje de error {string}")
    public void elSistemaMuestraElSiguienteMensajeDeError(String mensajeError) {
        Assertions.assertEquals(mensajeError, this.mensajeError);
        Assertions.assertNotEquals(mensajeError, null);
    }
}
