package Tienda;

public class VentaService {
    private ProductoService productoService;

    // Constructor
    public VentaService(ProductoService productoService) {
        this.productoService = productoService;
    }

    // Método para realizar una venta
    public boolean realizarVenta(int codigo, String color, String talle) {
        Producto producto = productoService.obtenerProducto(codigo, color, talle);

        if (producto != null && producto.getStock() > 0) {
            // Lógica para procesar la venta
            productoService.actualizarStock(codigo, color, talle, -1); // Restar 1 al stock
            return true; // La venta se realizó correctamente
        } else {
            return false; // No se puede realizar la venta (producto no encontrado o sin stock)
        }
    }
}