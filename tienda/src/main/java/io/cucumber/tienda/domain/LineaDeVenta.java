package io.cucumber.tienda.domain;

public class LineaDeVenta {
    private final Integer codigo;
    private final String descripcion;
    private final Double precioUnitario;
    private final String color;
    private final String talle;
    private final String cantidad;
    private final Double subtotal;

    public LineaDeVenta(Integer codigo, String descripcion, Double precioUnitario, String color, String talle, String cantidad, Double subtotal){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.color = color;
        this.talle = talle;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }


    public String getColor() {
        return color;
    }

    public String getTalle() {
        return talle;
    }

    public String getCantidad() {
        return cantidad;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }
}
