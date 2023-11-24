import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgregarArticuloStepDefinitions {

    private Venta venta;
    private Articulo articuloSeleccionado;
    private String talle;
    private String color;
    private int stock;

    @Given("existe una venta en proceso")
    public void existe_una_venta_en_proceso() {
        venta = new Venta();
    }

    @And("un articulo con el siguiente detalle")
    public void un_articulo_con_el_siguiente_detalle(io.cucumber.datatable.DataTable dataTable) {

        Map<String, String> articuloData = dataTable.asMaps().get(0);
        String codigo = articuloData.get("codigo");
        String marca = articuloData.get("marca");
        String descripcion = articuloData.get("descripcion");
        double precio = Double.parseDouble(articuloData.get("precio"));

        articuloSeleccionado = new Articulo(codigo, marca, descripcion, precio);
    }

    @And("existen los siguientes talles y colores para el articulo en la sucursal")
    public void existen_los_siguientes_talles_y_colores_para_el_articulo_en_la_sucursal(io.cucumber.datatable.DataTable dataTable) {

    }

    @When("selecciona")
    public void selecciona(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> seleccionData = dataTable.asMap(String.class, String.class);

        String talleSeleccionado = seleccionData.get("talle");
        String colorSeleccionado = seleccionData.get("color");
        int stockSeleccionado = Integer.parseInt(seleccionData.get("stock"));

        LineaVenta lineaVenta = new LineaVenta(articuloSeleccionado, talleSeleccionado, colorSeleccionado, stockSeleccionado);
        venta.addLineaVenta(lineaVenta);
    }

    @Then("se agrega la seleccion a la linea de venta")
    public void se_agrega_la_seleccion_a_la_linea_de_venta() {
        assertEquals(1, venta.getLineasVenta().size());
    }

    @And("se muestra el sub total correspondiente")
    public void se_muestra_el_sub_total_correspondiente() {

        double total = venta.calcularTotal();

    }
}