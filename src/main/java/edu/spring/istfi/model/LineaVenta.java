package edu.spring.istfi.model;

public class LineaVenta {
    private int cantidad;

    public LineaVenta(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {

        return cantidad;
    }
    @Override
    public String toString() {
        return "Línea de Venta - Cantidad: " + cantidad + ", Subtotal: " + getSubtotal();
    }
}
