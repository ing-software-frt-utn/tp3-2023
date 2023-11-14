package io.cucumber.tienda.domain;

import java.util.ArrayList;

public class Venta {
    private final ArrayList<LineaDeVenta> lineaDeVentas;
    private final Double total;

    public Venta(ArrayList<LineaDeVenta> lineaDeVentas, Double total) {
        this.lineaDeVentas = (lineaDeVentas != null) ? new ArrayList<>(lineaDeVentas) : new ArrayList<>();
        this.total = (total == null? calcularTotal() : total);
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
}
