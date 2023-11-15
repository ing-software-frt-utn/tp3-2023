package com.example.demo.repositorio;

import com.example.demo.dominio.Pago;

public interface RepositorioPago {
    public void registrarPago(Pago pago);
    public Pago buscarPago(String idCompra);
}
