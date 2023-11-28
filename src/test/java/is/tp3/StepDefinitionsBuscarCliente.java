package is.tp3;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import is.tp3.domain.Articulo;
import is.tp3.domain.Cliente;
import is.tp3.domain.LineaDeVenta;
import is.tp3.domain.Venta;
import is.tp3.repositories.RepositorioCliente;
import is.tp3.services.ServicioClientes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static  org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
public class StepDefinitionsBuscarCliente {

    public Cliente cliente;
    private ArrayList<Cliente> clientes;

    public RepositorioCliente repositorioMock;

    public ServicioClientes servicio;

    private Articulo articulo;

    ArrayList<Articulo> articulos;

    LineaDeVenta lineaDeVenta;

    public boolean seElimina = false;

    Venta venta;

    @Before
    public void setUp(){
        repositorioMock = mock(RepositorioCliente.class);
        servicio = new ServicioClientes(repositorioMock);

        when(repositorioMock.buscarCliente(anyInt()))
                .then(answer -> {
                    int dniCliente = answer.getArgument(0);
                    return clientes
                            .stream()
                            .filter(a-> a.dni == dniCliente)
                            .findFirst().get();
                });

        // when(repositorioMock.buscarCliente(anyInt())).thenReturn(clientes.get(0));
    }


    @Given("que existen los siguientes Clientes con sus dni:")
    public void que_existen_los_siguientes_clientes_con_sus_dni(List<Map<String, String>> tabla) {
        clientes = new ArrayList<Cliente>();
        for (Map<String, String> fila : tabla) {
            String nombre = fila.get("nombre");
            Integer dni = Integer.parseInt(fila.get("dni"));



            clientes.add(new Cliente(nombre, dni));


        }

    }

    @When("busco un cliente con dni: {int}")
    public void selecciono_buscar_cliente(int dni) {
        cliente = servicio.buscarCliente(dni);
        verify(repositorioMock, times(1)).buscarCliente(dni);

    }
    @Then("el Cliente {string} se asocia a la Venta")
    public void el_cliente_nombre_se_asocia_a_la_venta(String nombre) {

        assertEquals(nombre, cliente.nombre);
    }
}
