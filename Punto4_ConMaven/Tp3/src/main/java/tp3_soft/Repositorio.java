package tp3_soft;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {

	private static Repositorio instanciaUnica;
    private List<Producto> productos;

    private Repositorio() {
        productos = new ArrayList<>();
    }

    public static Repositorio obtenerInstancia() {
        if (instanciaUnica == null) {
            instanciaUnica = new Repositorio();
        }
        return instanciaUnica;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public Producto buscarProducto(String codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)){
                return producto;
            }
        }
        return null;
    }
	
}
