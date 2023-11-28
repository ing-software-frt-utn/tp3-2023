package is.tp3.repositories;

import is.tp3.domain.Articulo;
import is.tp3.domain.Cliente;

public interface RepositorioArticulo {

    Articulo buscarArticulo(int codigo);
}
