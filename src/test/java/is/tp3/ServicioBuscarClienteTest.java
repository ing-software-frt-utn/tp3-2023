package is.tp3;

import is.tp3.domain.Articulo;
import is.tp3.domain.Cliente;
import is.tp3.repositories.RepositorioCliente;
import is.tp3.services.ServicioClientes;
import org.junit.jupiter.api.Test;


import static org.mockito.ArgumentMatchers.anyInt;
import  static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ServicioBuscarClienteTest {

    @Test
    public void buscarYEncontrarUnClientePorDNI(){
        RepositorioCliente repositorioMock = mock(RepositorioCliente.class);
        ServicioClientes servicio = new ServicioClientes(repositorioMock);


        Cliente esperado = new Cliente("Juan Perez", 37890124);

        Cliente resultado;

        when(repositorioMock.buscarCliente(anyInt()))
                    .then(answer -> {
                return new Cliente("Juan Perez",answer.getArgument(0));
            });

        resultado =  servicio.buscarCliente(37890124);

        verify(repositorioMock);
        assertNotNull(resultado);
        assertEquals(esperado, resultado);
    }
}
