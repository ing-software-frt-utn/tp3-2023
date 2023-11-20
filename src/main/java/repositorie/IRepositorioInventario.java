package repositorie;

import domain.Articulo;
import domain.Inventario;

import java.util.ArrayList;

public interface IRepositorioInventario {

    ArrayList<Inventario> buscarInventario(Articulo a);
}
