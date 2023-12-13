package io.cucumber.tienda.services;

import io.cucumber.tienda.domain.Cliente;
import io.cucumber.tienda.domain.Venta;
import io.cucumber.tienda.services.ServicioVenta;

public class ServicioVentaImpl implements ServicioVenta {
    private Venta ventaActual;
    public void iniciarNuevaVenta(Cliente cliente) {
        ventaActual = new Venta(cliente);
    }

    @Override
    public Venta getVentaActual() {
        return ventaActual;
    }


}
