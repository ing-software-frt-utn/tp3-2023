package is.tp3.domain;

public class LineaVenta {
    private int cantidad;
    private Articulo articulo;

    public Double getSubtotal(){
        return cantidad * articulo.getPrecioVenta();
    }

    public LineaVenta(int cantidad, Articulo articulo) {
        this.cantidad = cantidad;
        this.articulo = articulo;
    }

    public LineaVenta() {
    }

    public int getCantidad() {
        return cantidad;
    }

    public Articulo getProducto() {
        return articulo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setProducto(Articulo producto) {
        this.articulo = producto;
    }
}
