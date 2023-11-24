package io.cucumber.tienda.domain;

public class Articulo {
    private String codigo;
    private String marca;
    private String descripcion;
    private double precio;

    public Articulo(String codigo, String marca, String descripcion, double precio) {
        this.codigo = codigo;
        this.marca = marca;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMarca() {
        return marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

}