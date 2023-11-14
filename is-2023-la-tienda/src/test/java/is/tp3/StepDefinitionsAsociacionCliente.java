package is.tp3;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import is.tp3.domain.Cliente;
import is.tp3.domain.Venta;
import is.tp3.repositories.ClienteRepository;
import is.tp3.services.ServicioBuscarCliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SuppressWarnings("SpellCheckingInspection")
public class StepDefinitionsAsociacionCliente {

    private ArrayList<Cliente> clientes;
    private Cliente clienteAsociado;
    private Venta ventaEnCurso;
    private ClienteRepository clienteRepository;
    private String mensajeError;
    private Cliente nuevoCliente;

    @Before
    public void setUp(){
        clienteRepository = mock(ClienteRepository.class);

        when(clienteRepository.buscarCliente(anyInt()))
                .then(answer -> {
                    Integer dni = answer.getArgument(0);
                    return clientes
                            .stream()
                            .filter(c -> c.tieneDni(dni))
                            .findFirst()
                            .orElseThrow(() -> new RuntimeException("Cliente inexistente"));
                });

        when(clienteRepository.registrarCliente(any(Cliente.class)))
                .then(answer -> {
                    Cliente nuevoCliente = answer.getArgument(0);

                    clientes.add(nuevoCliente);

                    // Lógica necesaria para simular el registro del cliente
                    // Simulación exitosa, cliente registrado
                    return true;
                });
    }

    @Given("existen los siguientes clientes registrados:")
    public void existen_los_siguientes_clientes_registrados(List<Map<String, String>> tabla) {

        clientes = new ArrayList<Cliente>();

        for (Map<String, String> fila : tabla) {
            Integer dni = Integer.parseInt(fila.get("DNI"));
            String condicionTributaria = fila.get("Condicion Tributaria");
            String cuilCuit = fila.get("CUIL / CUIT");
            String nombreRazonSocial = fila.get("Nombre / Razon Social");
            String domicilio = fila.get("Domicilio");
            String localidad = fila.get("Localidad");
            clientes.add(new Cliente(dni,condicionTributaria, cuilCuit, nombreRazonSocial, domicilio, localidad));
        }
    }

    @Given("una venta en curso con la siguiente informacion:")
    public void una_venta_en_curso_con_la_siguiente_informacion(List<Map<String, String>> tabla) {
        ServicioBuscarCliente servicio = new ServicioBuscarCliente(clienteRepository);
        Cliente clienteActual = null;

        for (Map<String, String> fila : tabla) {
            clienteActual = servicio.buscarCliente(Integer.parseInt(fila.get("Cliente Asociado")));
        }

        ventaEnCurso = new Venta(clienteActual);
    }

    @When("ingreso el DNI del cliente {int}")
    public void ingreso_el_dni_del_cliente(Integer dniCliente) {

        ServicioBuscarCliente servicio = new ServicioBuscarCliente(clienteRepository);

        try {
            clienteAsociado = servicio.buscarCliente(dniCliente);
        }catch (RuntimeException e){
            mensajeError = e.getMessage();
        }
    }

    @Then("se asocia el cliente a la venta.")
    public void se_asocia_el_cliente_a_la_venta(List<Map<String, String>> tabla) {
        ventaEnCurso.asociarCliente(clienteAsociado);
        int clienteEsperado = 0;

        for (Map<String, String> fila : tabla) {
            clienteEsperado = Integer.parseInt(fila.get("Cliente Asociado"));
        }

        assertEquals(clienteEsperado, ventaEnCurso.getClienteAsociado().getDni());
    }

    @Then("se muestra el siguiente mensaje {string}")
    public void seMuestraElSiguienteMensaje(String mensajeEsperado) {
        assertEquals(mensajeEsperado, mensajeError);
    }


    @When("completo el formulario de creacion de cliente con los siguientes datos:")
    public void completo_el_formulario_de_creacion_de_cliente_con_los_siguientes_datos(List<Map<String, String>> tabla) {
        for (Map<String, String> fila : tabla) {
            Integer dni = Integer.parseInt(fila.get("DNI"));
            String condicionTributaria = fila.get("Condicion Tributaria");
            String cuilCuit = fila.get("CUIL / CUIT");
            String nombreRazonSocial = fila.get("Nombre / Razon Social");
            String domicilio = fila.get("Domicilio");
            String localidad = fila.get("Localidad");

            nuevoCliente = new Cliente(dni,condicionTributaria, cuilCuit, nombreRazonSocial, domicilio, localidad);
        }
    }

    @Then("se registra al nuevo cliente")
    public void se_registra_al_nuevo_cliente(List<Map<String, String>> tabla) {
        ServicioBuscarCliente servicio = new ServicioBuscarCliente(clienteRepository);

        int cantidadPrevia = clientes.size();
        int cantidadNueva = 0;

        Boolean resultadoRegistro;
        resultadoRegistro = servicio.registrarCliente(nuevoCliente);

        cantidadNueva = clientes.size();

        assertTrue(resultadoRegistro);
        assertTrue(cantidadNueva > cantidadPrevia);
    }
}