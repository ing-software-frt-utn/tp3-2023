package io.cucumber.tienda.domain;

public class Articulo {
    private final Integer codigo;
    private final String descripcion;
    private final String marca;
    private final String categoria;
    private final Double precio;

    public Articulo(Integer codigo, String descripcion, String marca, String categoria, Double precio){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.marca = marca;
        this.categoria = categoria;
        this.precio = precio;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public Double getPrecio() {
        return precio;
    }
}
