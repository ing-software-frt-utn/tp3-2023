package service;

import is.tp3.domain.Cliente;
import repository.ClienteRepository;

public class ClienteService{
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public boolean buscarClientePorDNI(String dni){
        return false;
    }

}
