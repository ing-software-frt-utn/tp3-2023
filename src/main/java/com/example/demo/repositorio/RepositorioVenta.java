package com.example.demo.repositorio;

import com.example.demo.dominio.Venta;

public interface RepositorioVenta {
    public Venta buscarVenta(String id);

    public Venta ingresarVenta(Venta venta);
}
