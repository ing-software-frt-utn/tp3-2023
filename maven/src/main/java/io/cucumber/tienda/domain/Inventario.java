package io.cucumber.tienda.domain;

public class Inventario {
    private String talle;
    private String color;
    private int stock;
    public Inventario(String talle, String color, int stock){
        this.talle = talle;
        this.color = color;
        this.stock = stock;
    }
}
