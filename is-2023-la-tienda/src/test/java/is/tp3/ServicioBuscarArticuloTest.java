package is.tp3;

import is.tp3.domain.Articulo;
import is.tp3.domain.Cliente;
import is.tp3.repositories.ClienteRepository;
import is.tp3.repositories.RepositorioArticulo;
import is.tp3.services.ServicioBuscarArticulo;
import is.tp3.services.ServicioBuscarCliente;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyInt;
import  static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ServicioBuscarArticuloTest {

    @Test
    public void buscarYEncontrarUnClientePorDNI(){

        ClienteRepository clienteRepository = mock(ClienteRepository.class);
        ServicioBuscarCliente servicio = new ServicioBuscarCliente(clienteRepository);
        int dni = 12345678;

        when(clienteRepository.buscarCliente(anyInt()))
                .then(answer -> {
            return new Cliente(answer.getArgument(0), null, null, null, null, null);
        });

        Cliente cliente = servicio.buscarCliente(dni);

        verify(clienteRepository);
        assertNotNull(cliente);
        assertTrue(cliente.tieneDni(dni));
    }
}
