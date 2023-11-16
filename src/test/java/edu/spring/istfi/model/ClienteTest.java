package edu.spring.istfi.model;

import edu.spring.istfi.repository.ClienteRepository;
import edu.spring.istfi.servicio.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest(classes = ClienteService.class)
public class ClienteTest {

    @MockBean
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService servicio;

    @Test
    public void buscarClientePorDni() {
        Direccion direccionEjemplo = new Direccion(1, 12345, "Calle Ejemplo", 42);
        Cliente clienteEjemplo = new Cliente(1, 12345678, 987654321, "Cliente Ejemplo","Nicolas","Morales", direccionEjemplo);

        when(clienteRepository.findByDni(12345678)).thenReturn(clienteEjemplo);

        Cliente clienteEncontrado = servicio.buscarClienteporDni(12345678);

        assertEquals(12345678, clienteEncontrado.getDNI());


        verify(clienteRepository, times(1)).findByDni(12345678);
    }
}
