package domain;

public class Inventario {

    private final String talle;
    private final String color;
    private final String sucursal;
    private final Integer stock;

    public Inventario(String talle, String color, String sucursal, Integer stock) {
        this.talle = talle;
        this.color = color;
        this.sucursal = sucursal;
        this.stock = stock;
    }


    public String getTalle() {
        return talle;
    }

    public String getColor() {
        return color;
    }

    public String getSucursal() {
        return sucursal;
    }

    public Integer getStock() {
        return stock;
    }
}
