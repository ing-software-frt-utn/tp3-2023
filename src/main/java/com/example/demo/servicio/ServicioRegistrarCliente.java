package com.example.demo.servicio;


import com.example.demo.dominio.Cliente;
import com.example.demo.repositorio.RepositorioCliente;

public class ServicioRegistrarCliente {
    private RepositorioCliente repositorioCliente;

    public ServicioRegistrarCliente(RepositorioCliente repositorioCliente){
        this.repositorioCliente = repositorioCliente;
    }

    public Cliente registrarCliente(String dni, String nombre, String domicilio) {
        return new Cliente(dni, nombre, domicilio);
    }

    public Cliente buscarCliente(String dni) {
        return repositorioCliente.buscarCliente(dni);
    }
}
