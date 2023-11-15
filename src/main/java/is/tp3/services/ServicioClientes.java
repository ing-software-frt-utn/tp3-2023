package is.tp3.services;

import is.tp3.domain.Cliente;
import is.tp3.repositories.RepositorioCliente;

public class ServicioClientes {

    private RepositorioCliente repositorioCliente;

    public ServicioClientes(RepositorioCliente repositorio){
        this.repositorioCliente = repositorio;
    }

    public Cliente buscarCliente(int dni){
        return repositorioCliente.buscarCliente(dni);
    }
}

