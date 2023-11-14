package io.cucumber.tienda.services;

import io.cucumber.tienda.domain.Cliente;

public interface ServicioVenta {
    void iniciarNuevaVenta();
    void asociarClienteConVenta(Cliente cliente);
    void asociarComprobante();
    // Otros métodos relacionados con la gestión de ventas
}