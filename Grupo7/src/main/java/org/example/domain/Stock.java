package org.example.domain;

public class Stock {
    private int codigo;
    private String color;
    private String talle;
    public int stock;

    public Stock(int codigo, String color, String talle, int stock) {
        this.codigo = codigo;
        this.color = color;
        this.talle = talle;
        this.stock = stock;
    }

    public boolean tieneCodigo(int codigo) {
        return this.codigo == codigo;
    }

    public boolean hayStock() {
        return this.stock > 0;
    }
}
