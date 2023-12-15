package repository;

import is.tp3.domain.Cliente;

public interface ClienteRepository {
    boolean buscarClientePorDNI(String dni);
}
