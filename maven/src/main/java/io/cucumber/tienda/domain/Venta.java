package io.cucumber.tienda.domain;

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


}
