package com.example.demo.servicio;

import com.example.demo.dominio.Venta;
import com.example.demo.dominio.Pago;
import com.example.demo.repositorio.RepositorioPago;

public class ServicioRegistrarPago {
    private RepositorioPago repositorioPago;

    public ServicioRegistrarPago(RepositorioPago repositorioPago){
        this.repositorioPago = repositorioPago;
    }
    public Pago ingresarPago(double monto, Venta compra){
        Pago pago = new Pago(monto, compra);
        return pago;
    }

    public Pago buscarPago(String idCompra) {
        return repositorioPago.buscarPago(idCompra);
    }
}
