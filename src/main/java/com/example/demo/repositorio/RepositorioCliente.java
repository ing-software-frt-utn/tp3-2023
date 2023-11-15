package com.example.demo.repositorio;

import com.example.demo.dominio.Cliente;

public interface RepositorioCliente {
    public Cliente buscarCliente(String dni);
}
