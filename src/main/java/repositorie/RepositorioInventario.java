package repositorie;

import domain.Articulo;
import domain.Inventario;

import java.util.ArrayList;

public interface RepositorioInventario {

    ArrayList<Inventario> buscarInventario(Articulo a);
    Articulo buscarArticulo(int codigo);
}
