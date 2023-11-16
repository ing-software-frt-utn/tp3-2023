package edu.spring.istfi.model;

public class Producto {
    private int id;
    private int stock;

    public Producto(int id, int stock) {
        this.id = id;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto - ID: " + id +
                ", Stock: " + stock;
    }

}
