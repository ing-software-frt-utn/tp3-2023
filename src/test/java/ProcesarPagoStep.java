import com.example.demo.dominio.*;
import com.example.demo.repositorio.*;
import com.example.demo.servicio.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ProcesarPagoStep {

    private RepositorioPago repositorioPago;
    private RepositorioVenta repositorioVenta;
    private RepositorioProducto repositorioProducto;
    private RepositorioCliente repositorioCliente;
    private RepositorioFactura repositorioFactura;
    private ServicioRegistrarPago servicioRegistrarPago;
    private ServicioRegistrarVenta servicioRegistrarVenta;
    private ServicioRegistrarCliente servicioRegistrarCliente;
    private ServicioRegistrarFactura servicioRegistrarFactura;
    private ServicioRegistraProducto servicioRegistraProducto;

    private ServicioExternoAFIP servicioExternoAFIP;
    private double vuelto;


    @Before
    public void setUp(){
        repositorioPago = mock(RepositorioPago.class);
        repositorioVenta = mock(RepositorioVenta.class);
        repositorioProducto = mock(RepositorioProducto.class);
        repositorioCliente = mock(RepositorioCliente.class);
        repositorioFactura = mock(RepositorioFactura.class);
        servicioRegistrarPago = new ServicioRegistrarPago(repositorioPago);
        servicioRegistrarVenta = new ServicioRegistrarVenta(repositorioVenta);
        servicioRegistraProducto = new ServicioRegistraProducto(repositorioProducto);
        servicioRegistrarCliente = new ServicioRegistrarCliente(repositorioCliente);
        servicioRegistrarFactura = new ServicioRegistrarFactura(repositorioFactura);
        servicioExternoAFIP = new ServicioExternoAFIP();
    }

    @Given("Que existe un cliente que realiza una compra de ${double} con id {string} de un producto {string} talle {string} color {string} con id {string}")
    public void queExisteUnClienteQueRealizaUnaCompraDe$DeUnProductoTalleColorConId(double monto, String idCompra, String nombre, String talle, String color, String idProducto) {
        List<Venta> ventas = new ArrayList<>();
        Producto producto = servicioRegistraProducto.ingresarProducto(idProducto, nombre, talle, color);
        ventas.add(servicioRegistrarVenta.ingresarVenta(idCompra, monto, producto));
        when(repositorioVenta.buscarVenta(anyString())).then(answer -> {
            String id = answer.getArgument(0);
            return ventas
                    .stream()
                    .filter(venta -> venta.tieneCodigo(id))
                    .findFirst()
                    .orElse(null);
        });
    }

    @When("se realiza el pago de la compra con idCompra {string} de ${double}")
    public void seRealizaElPagoDeUnaCompraDe$(String idCompra, double monto) {
        List<Pago> pagos = new ArrayList<>();
        Venta compra = servicioRegistrarVenta.buscarVenta(idCompra);
        Pago pagoC = servicioRegistrarPago.ingresarPago(monto, compra);
        pagos.add(pagoC);
        when(repositorioPago.buscarPago(anyString())).then(answer -> {
            String id = answer.getArgument(0);
            return pagos
                    .stream()
                    .filter(pago -> pago.tieneCodigo(id))
                    .findFirst()
                    .orElse(null);
        });
    }

    @Then("El Sistema registra el pago para la compra con id {string}")
    public void elSistemaRegistraElPagoRealizado(String idCompra) {
        Venta venta = servicioRegistrarVenta.buscarVenta(idCompra);
        Pago pago = servicioRegistrarPago.buscarPago(idCompra);
        if(pago.getMonto() >= venta.getMonto()){
            venta.setEstadoPago(true);
            vuelto = pago.getMonto() - venta.getMonto();
        }
        assertThat(venta.getEstadoPago()).isEqualTo(true);
    }

    @And("El sistema calcula, muestra el vuelto ${double}")
    public void elSistemaCalculaMuestraElVuelto(double vuelto) {
        assertThat(vuelto).isEqualTo(this.vuelto);
    }

    @Given("que existe un cliente con dni {string}, nombre {string}, domicilio {string} que realiza una compra de ${double} con id {string} de {string} productos {string} talle {string} color {string} con id {string}")
    public void queElClienteConDniNombreDomicilioRealizaUnaCompraDe$ConIdDeProductosTalleColorConId(String dni, String nombre, String domicilio, double monto, String idCompra, String cantidad, String nombreProducto, String talle, String color, String idProducto) {
        List<Venta> ventas = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente = servicioRegistrarCliente.registrarCliente(dni,nombre,domicilio);
        clientes.add(cliente);
        Producto producto = servicioRegistraProducto.ingresarProducto(idProducto, nombreProducto, talle, color);
        ventas.add(servicioRegistrarVenta.ingresarVenta(idCompra, monto, producto));
        when(repositorioVenta.buscarVenta(anyString())).then(answer -> {
            String id = answer.getArgument(0);
            return ventas
                    .stream()
                    .filter(venta -> venta.tieneCodigo(id))
                    .findFirst()
                    .orElse(null);
        });
        when(repositorioCliente.buscarCliente(anyString())).then(answer -> {
            String dniCliente = answer.getArgument(0);
            return clientes
                    .stream()
                    .filter(client -> client.tieneDni(dniCliente))
                    .findFirst()
                    .orElse(null);
        });
    }

    @Then("El sistema asocia el cliente con dni {string}, nombre {string}, domicilio {string} a la compra con idCompra {string}")
    public void elSistemaAsociaElClienteConDniNombreDomicilioALaCompraConIdCompra(String dni, String nombre, String domicilio, String idCompra) {
        List<Factura> facturas = new ArrayList<>();
        Venta venta = servicioRegistrarVenta.buscarVenta(idCompra);
        Cliente cliente = servicioRegistrarCliente.buscarCliente(dni);
        Factura factura = servicioRegistrarFactura.ingresarFactura("12", venta, cliente);
        facturas.add(factura);
        when(repositorioFactura.buscarFactura(anyString())).then(answer -> {
            String num = answer.getArgument(0);
            return facturas
                    .stream()
                    .filter(fact -> fact.tieneNumero(num))
                    .findFirst()
                    .orElse(null);
        });
    }

    @And("El sistema se conecta con el sistema externo de AFIP el cual aprueba compra con id {string}")
    public void elSistemaSeConectaConElSistemaExternoDeAFIPElCualApruebaCompra(String idCompra) {
        Factura factura = servicioRegistrarFactura.buscarFactura(idCompra);
        boolean aprobada = servicioExternoAFIP.aprobarComprobante(factura);
        assertThat(aprobada).isTrue();
    }
}
