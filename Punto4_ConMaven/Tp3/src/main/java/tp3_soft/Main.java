package tp3_soft;

public class Main {

	public static void main(String[] args) {
		Repositorio repositorio = Repositorio.obtenerInstancia();

        // Agregar productos al repositorio
        repositorio.agregarProducto(new Producto("001", "M", "naranja", 5));
        repositorio.agregarProducto(new Producto("001", "L", "azul", 10));
        repositorio.agregarProducto(new Producto("003", "M", "naranja", 0));
        repositorio.agregarProducto(new Producto("004", "XS", "rojo", 5));
        repositorio.agregarProducto(new Producto("004", "XL", "morado", 0));

        // Escenario 1: Producto existente, stock mayor a 0
        buscarYMostrarStock(repositorio, "001");

        // Escenario 2: Producto existente, stock igual a 0
        buscarYMostrarStock(repositorio, "003");

        // Escenario 3: Producto inexistente
        buscarYMostrarStock(repositorio, "002");

        // Escenario 4: Producto con stock y otro sin stock
        buscarYMostrarStock(repositorio, "004");
    }

    public static void buscarYMostrarStock(Repositorio repositorio, String codigo) {
        Producto productoEncontrado = repositorio.buscarProducto(codigo);

        if (productoEncontrado != null) {
            int stock = productoEncontrado.getStock();
            if (stock > 0) {
                System.out.println("Stock del producto encontrado: " + stock);
            } else {
                System.out.println("El producto existe pero no tiene stock.");
            }
        } else {
            System.out.println("Producto no encontrado en el stock.");
        }
    }

}
