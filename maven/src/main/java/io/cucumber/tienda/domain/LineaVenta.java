public class LineaVenta {
    private Articulo articulo;
    private String talle;
    private String color;
    private int cantidad;

    public LineaVenta(Articulo articulo, String talle, String color, int cantidad) {
        this.articulo = articulo;
        this.talle = talle;
        this.color = color;
        this.cantidad = cantidad;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public String getTalle() {
        return talle;
    }

    public String getColor() {
        return color;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double calcularSubtotal() {
        double subtotal = 0;
        for (LineaVenta lineaVenta : lineasVenta) {
            subtotal += lineaVenta.getArticulo().getPrecio() * lineaVenta.getCantidad();
        }
        return subtotal;
    }
}