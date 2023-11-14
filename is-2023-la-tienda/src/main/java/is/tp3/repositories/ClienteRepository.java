package is.tp3.repositories;

import is.tp3.domain.Cliente;

public interface ClienteRepository {
    Cliente buscarCliente(Integer dni);
    Boolean registrarCliente(Cliente nuevoCliente);
}
