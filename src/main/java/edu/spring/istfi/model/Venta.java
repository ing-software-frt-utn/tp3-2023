package edu.spring.istfi.model;

import java.time.LocalDateTime;

public class Venta {
    private int numVenta;
    private LocalDateTime fecha;
    private long numComprobante;
    private double total;


    // Constructor, getters y setters

    public Venta() {
    }

    public void agregarProducto(int id) {
        // Lógica para agregar un producto al detalle de la venta
    }

    public void quitarProducto(int id) {
        // Lógica para quitar un producto del detalle de la venta
    }

    public void pagar(Cliente cliente, TipoPago tipoPago) {
        // Lógica para procesar el pago de la venta
    }

    private double getTotal() {
        // Lógica para calcular el total de la venta
        return 0;
    }
}
