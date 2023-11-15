package is.tp3.repositories;

import is.tp3.domain.Articulo;
import is.tp3.domain.Cliente;

public interface RepositorioCliente {

    Cliente buscarCliente(int dni);
}
