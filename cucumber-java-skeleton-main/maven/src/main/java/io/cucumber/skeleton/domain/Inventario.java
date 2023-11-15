package io.cucumber.skeleton.domain;

public class Inventario {
    private final String sucursal;
    private final String talle;
    private final String color;
    private final String cantidad;
    public Inventario(String sucursal, String talle, String color, String cantidad){
        this.sucursal = sucursal;
        this.talle = talle;
        this.color = color;
        this.cantidad = cantidad;
    }
}
