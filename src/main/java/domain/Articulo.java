package domain;

public class Articulo {
    private final Integer codigo;
    private final Double precio;
    private final String marca;
    private final String categoria;


    public Articulo(Integer codigo, Double precio, String marca, String categoria) {
        this.codigo = codigo;
        this.precio = precio;
        this.marca = marca;
        this.categoria = categoria;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Double getPrecio() {
        return precio;
    }

    public String getMarca() {
        return marca;
    }

    public String getCategoria() {
        return categoria;
    }
}
