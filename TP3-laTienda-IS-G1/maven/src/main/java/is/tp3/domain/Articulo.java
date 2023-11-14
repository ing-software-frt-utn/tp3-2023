package is.tp3.domain;

public class Articulo {
    private final Integer codigo;
    private final String marca;
    private final String descripcion;
    private final Integer precio;

    public Articulo(Integer codigo, String marca, String descripcion, Integer precio) {

        this.codigo = codigo;
        this.marca = marca;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getMarca() {
        return marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getPrecio() {
        return precio;
    }

    public boolean tieneCodigo(Integer codigo) {
        return this.codigo == codigo;
    }
}