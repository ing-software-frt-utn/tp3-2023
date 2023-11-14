package io.cucumber.tienda.domain;

import java.util.ArrayList;

public class Venta {
    private ArrayList<LineaDeVenta> lineaDeVentas;
    private Double total;
    private Cliente cliente;
    private Comprobante comprobante;

    public Venta(ArrayList<LineaDeVenta> lineaDeVentas) {
        this.lineaDeVentas = (lineaDeVentas != null) ? new ArrayList<>(lineaDeVentas) : new ArrayList<>();
        this.total = calcularTotal();
    }

    private Double calcularTotal() {
        Double totalCalculado = (double) 0;
        for (LineaDeVenta linea : lineaDeVentas) {
            totalCalculado += linea.getSubtotal();
        }
        return totalCalculado;
    }
    public ArrayList<LineaDeVenta> getLineaDeVentas() {
        return new ArrayList<>(lineaDeVentas);
    }

    public Double getTotal() {
        return total;
    }

    // Métodos para Feature AsociarCliente

    public Venta(Cliente cliente){
        this.cliente = cliente;
        this.comprobante = new Comprobante(this.cliente);
    }
    public void modificarCondicionTributaria(CondicionTributaria nuevaCondicionTributaria) {
        this.cliente.setCondicionTributaria(nuevaCondicionTributaria);
        this.comprobante = new Comprobante(this.cliente);
    }

    public Cliente getCliente() { return cliente; }

    public Comprobante getComprobante() {
        return comprobante;
    }
}
