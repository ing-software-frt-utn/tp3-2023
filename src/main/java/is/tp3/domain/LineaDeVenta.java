package is.tp3.domain;

public class LineaDeVenta {

    Articulo articulo;

    Integer cantidad;


    public LineaDeVenta( ){

    }


    public void agregarArticuloALineaDeVenta(Integer cantidad,Articulo articulo) {
        this.articulo = articulo;
        this.cantidad = cantidad;


    }

    public int getCantidadArticulos() {
        return this.cantidad;
    }

    public Articulo getArticulo() {
        return this.articulo;
    }

    public double getSubTotal() {
        return cantidad * articulo.getPrecio();
    }
}
