package is.tp3.domain;

public class Stock {
    private final Integer codigo;
    private final String color;
    private final String talle;
    private final Integer cantidad;

    public Stock(Integer codigo, String color, String talle, Integer cantidad){
        this.codigo=codigo;
        this.cantidad=cantidad;
        this.talle=talle;
        this.color=color;
    }
    public Integer getCodigo() {
        return codigo;
    }

    public String getTalle() {
        return talle;
    }

    public String getColor() {
        return color;
    }

    public Integer getCantidad() {
        return cantidad;
    }
    public boolean tieneCodigo(Integer codigo) {
        return this.codigo == codigo;
    }
}
