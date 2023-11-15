package com.example.demo.repositorio;

import com.example.demo.dominio.Factura;

public interface RepositorioFactura {

    public Factura buscarFactura(String numero);
}
