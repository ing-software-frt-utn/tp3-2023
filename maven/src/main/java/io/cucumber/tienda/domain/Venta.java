package io.cucumber.tienda.domain;

import java.util.ArrayList;
import java.util.List;

public class Venta {

    private Cliente cliente;
    private String estado;
    private List<LineaVenta> lineasVenta;

    // Constructor
    public Venta() {

        this.estado = "pendiente";
        this.lineasVenta = new ArrayList<>();

    }
    public Venta(Cliente cliente) {
        this.cliente = cliente;
        this.estado = "pendiente";
        this.lineasVenta = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addLineaVenta(LineaVenta lineaVenta) {
        lineasVenta.add(lineaVenta);
    }


    public double calcularSubtotal() {
        double subtotal = 0;
        for (LineaVenta lineaVenta : lineasVenta) {
            subtotal += lineaVenta.getArticulo().getPrecio() * lineaVenta.getCantidad();
        }
        return subtotal;
    }

    public List<LineaVenta> getLineaVenta() {
        return lineasVenta;
    }

}
