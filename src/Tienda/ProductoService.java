package Tienda;

import java.util.ArrayList;
import java.util.List;

public class ProductoService {
    private List<Producto> productos;

    // Constructor
    public ProductoService() {
        this.productos = new ArrayList<>();
        // Agregar productos de ejemplo
        productos.add(new Producto(123456, "Rojo", "M", 10));
    }

    // Método para obtener un producto por código, color y talle
    public Producto obtenerProducto(int codigo, String color, String talle) {
        // Lógica para buscar y devolver el producto según los parámetros
        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo && producto.getColor().equals(color) && producto.getTalle().equals(talle)) {
                return producto;
            }
        }
        return null; // Si no se encuentra el producto
    }

    // Método para actualizar el stock de un producto
    public void actualizarStock(int codigo, String color, String talle, int cantidad) {
        Producto producto = obtenerProducto(codigo, color, talle);
        if (producto != null) {
            producto.setStock(producto.getStock() + cantidad);
        }
    }
}
