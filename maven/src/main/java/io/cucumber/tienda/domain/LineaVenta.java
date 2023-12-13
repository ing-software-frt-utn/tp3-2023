package io.cucumber.tienda.domain;

import io.cucumber.tienda.domain.*;

public class LineaVenta {
    private Articulo articulo;
    private String talle;
    private String color;
    private int cantidad;


    public LineaVenta(Articulo articulo, String talle, String color, int cantidad) {
        this.articulo = articulo;
        this.talle = talle;
        this.color = color;
        this.cantidad = cantidad;
    }

    public LineaVenta(Articulo articuloSeleccionado) {
        this.articulo = articuloSeleccionado;
        this.cantidad = 1;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public String getTalle() {
        return talle;
    }

    public String getColor() {
        return color;
    }

    public int getCantidad() {
        return cantidad;
    }

}