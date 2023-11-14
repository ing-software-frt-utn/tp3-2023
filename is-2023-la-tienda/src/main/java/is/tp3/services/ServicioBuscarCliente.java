package is.tp3.services;

import is.tp3.domain.Articulo;
import is.tp3.domain.Cliente;
import is.tp3.repositories.ClienteRepository;
import is.tp3.repositories.RepositorioArticulo;

public class ServicioBuscarCliente {

    private final ClienteRepository repositorio;

    public ServicioBuscarCliente(ClienteRepository repositorio){
        this.repositorio = repositorio;
    }

    public Cliente buscarCliente(Integer dni){
        return repositorio.buscarCliente(dni);
    }

    public Boolean registrarCliente(Cliente nuevoCliente){
        return repositorio.registrarCliente(nuevoCliente);
    }

}
