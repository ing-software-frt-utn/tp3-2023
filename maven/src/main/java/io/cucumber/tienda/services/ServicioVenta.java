package io.cucumber.tienda.services;

import io.cucumber.tienda.domain.Cliente;
import io.cucumber.tienda.domain.Venta;

public interface ServicioVenta {
    void iniciarNuevaVenta(Cliente cliente);

    Venta getVentaActual();
}