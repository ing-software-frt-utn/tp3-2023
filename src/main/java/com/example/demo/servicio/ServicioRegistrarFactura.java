package com.example.demo.servicio;

import com.example.demo.dominio.Cliente;
import com.example.demo.dominio.Venta;
import com.example.demo.dominio.Factura;
import com.example.demo.repositorio.RepositorioFactura;

public class ServicioRegistrarFactura {
    private RepositorioFactura repositorioFactura;
    public ServicioRegistrarFactura(RepositorioFactura repositorioFactura) {
        this.repositorioFactura = repositorioFactura;
    }

    public Factura ingresarFactura(String numero, Venta venta, Cliente cliente) {
        return new Factura(numero, venta, cliente);
    }

    public Factura buscarFactura(String idCompra) {
        return repositorioFactura.buscarFactura(idCompra);
    }
}
