package edu.spring.istfi.servicio;


import edu.spring.istfi.model.Cliente;

import edu.spring.istfi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    public Cliente buscarClienteporDni(int DNI) {
        return clienteRepository.findByDni(DNI);
    }
}
