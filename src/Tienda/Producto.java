package Tienda;

public class Producto {
    private int codigo;
    private String color;
    private String talle;
    private int stock;

    // Constructor
    public Producto(){}
    public Producto(int codigo, String color, String talle, int stock) {
        this.codigo = codigo;
        this.color = color;
        this.talle = talle;
        this.stock = stock;
    }

    // Getter y Setter para el stock
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // Getter para el código
    public int getCodigo() {
        return codigo;
    }

    // Getter para el color
    public String getColor() {
        return color;
    }

    // Getter para el talle
    public String getTalle() {
        return talle;
    }
}

