package io.cucumber.tienda.domain;


public class Inventario {
    private final String sucursal;
    private final String color;
    private final String talle;
    private final String cantidad;


    public Inventario (String sucursal,String color, String talle, String cantidad){

        this.sucursal = sucursal;
        this.color = color;
        this.talle = talle;
        this.cantidad = cantidad;
    }
}
