package io.cucumber.tienda;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.tienda.domain.Articulo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModificacionArticuloSteps {
    private Articulo articulo;

    @Given("existe un producto con los siguientes datos:")
    public void productoExistente(io.cucumber.datatable.DataTable dataTable) {
        articulo = crearArticuloDesdeDataTable(dataTable);
        // Lógica para establecer el artículo existente (por ejemplo, en la base de datos)
    }

    @When("solicito cambiar la descripción del producto {string} a {string}")
    public void cambioDescripcionProducto(String idProducto, String nuevaDescripcion) {
        if (articulo.getCodigo().toString().equals(idProducto)) {
            articulo.setDescripcion(nuevaDescripcion);
        }
    }

    @Then("se cambian los datos del producto por:")
    public void datosArticuloModificados(io.cucumber.datatable.DataTable dataTable) {
        Articulo articuloModificado = crearArticuloDesdeDataTable(dataTable);
        assertEquals(articuloModificado, articulo);
    }

    private Articulo crearArticuloDesdeDataTable(io.cucumber.datatable.DataTable dataTable) {
        java.util.Map<String, String> productoData = dataTable.asMaps(String.class, String.class).get(0);
        double precio = Double.parseDouble(productoData.get("Precio"));
        return new Articulo(
                Integer.parseInt(productoData.get("Id")),
                productoData.get("Descripción"),
                productoData.get("Marca"),
                productoData.get("Categoría"),
                precio
        );
    }
}
