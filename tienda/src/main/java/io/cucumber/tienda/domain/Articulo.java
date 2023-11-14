package io.cucumber.tienda.domain;

public class Articulo {
    private final Integer codigo;
    private String descripcion;
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

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Articulo articulo = (Articulo) obj;
        return codigo.equals(articulo.codigo) &&
                descripcion.equals(articulo.descripcion) &&
                marca.equals(articulo.marca) &&
                categoria.equals(articulo.categoria);
    }

}
