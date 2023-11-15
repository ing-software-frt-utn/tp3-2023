import com.example.demo.dominio.Cliente;
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

public class RegistrarClienteStep {
    private List<Cliente> clientes;
    private RepositorioCliente repositorioCliente;
    private ServicioRegistrarCliente servicioRegistrarCliente;

    private static final String MENSAJE_EXISTOSO = "Registro Exitoso";
    private static final String MENSAJE_FALLIDO = "Registro Fallido";
    private String msj;

    @Before
    public void setUp(){
        clientes = new ArrayList<>();
        repositorioCliente = mock(RepositorioCliente.class);
        servicioRegistrarCliente = new ServicioRegistrarCliente(repositorioCliente);
    }
    @Given("que exista un cliente con dni {string}, nombre {string} y domicilio {string} que quiere ser dado de alta y no este registrado")
    public void queExistaUnClienteConDniNombreYDomicilioQueQuiereSerDadoDeAltaYNoEsteRegistrado(String dni, String nombre, String domicilio) {
        when(repositorioCliente.buscarCliente(anyString())).then(answer -> {
            String dniCliente = answer.getArgument(0);
            return clientes
                    .stream()
                    .filter(client -> client.tieneDni(dniCliente))
                    .findFirst()
                    .orElse(null);
        });

        Cliente cliente = servicioRegistrarCliente.buscarCliente(dni);

        assertThat(cliente).isNull();
    }

    @When("se inicializa el registro del cliente con dni {string}, nombre {string} y domicilio {string}")
    public void seInicializaElRegistroDelClienteConDniNombreYDomicilio(String dni, String nombre, String domicilio) {
        Cliente cliente = servicioRegistrarCliente.registrarCliente(dni,nombre,domicilio);
        clientes.add(cliente);
    }

    @Then("el sistema Registra un nuevo cliente con dni {string}, nombre {string} y domicilio {string}")
    public void elSistemaRegistraUnNuevoClienteConDniNombreYDomicilio(String dni, String nombre, String domicilio) {
        Cliente cliente = servicioRegistrarCliente.buscarCliente(dni);
        assertThat(cliente).isNotNull();
        assertThat(cliente.getDni()).isEqualTo(dni);
        assertThat(cliente.getNombre()).isEqualTo(nombre);
        assertThat(cliente.getDomicilio()).isEqualTo(domicilio);
        msj = MENSAJE_EXISTOSO;
    }

    @And("El sistema muestra un mensaje de {string}")
    public void elSistemaMuestraUnMensajeDeRegistroExitoso(String mensaje) {
        assertThat(msj).isEqualTo(mensaje);
    }
}
