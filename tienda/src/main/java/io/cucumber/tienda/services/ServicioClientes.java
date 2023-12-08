package io.cucumber.tienda.services;

import io.cucumber.tienda.domain.Cliente;
import io.cucumber.tienda.domain.Venta;
import io.cucumber.tienda.repositories.RepositorioCliente;

import java.util.ArrayList;

public class ServicioClientes {
    private final RepositorioCliente repositorioCliente;

    public ServicioClientes(final RepositorioCliente repositorioCliente){
        this.repositorioCliente = repositorioCliente;
    }

    public Cliente buscarClientePorDNI(final String dni){
        return repositorioCliente.buscarClientePorDNI(dni);
    }

    public Cliente buscarClientePorNombre(final String nombre){
        return repositorioCliente.buscarClientePorNombre(nombre);
    }
    public Venta agregarClienteAVenta(final Venta venta, final Cliente cliente){
        return repositorioCliente.agregarAVenta(venta, cliente);
    }
}
