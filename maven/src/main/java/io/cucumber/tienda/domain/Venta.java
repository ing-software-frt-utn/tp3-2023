package io.cucumber.tienda.domain;

public class Venta {

    private Cliente cliente;
    private String estado;

    // Constructor
    public Venta() {
        this.estado = "pendiente";
    }
    public Venta(Cliente cliente) {
        this.cliente = cliente;
        this.estado = "pendiente";
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


}
