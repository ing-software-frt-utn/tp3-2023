package is.tp3.services;

import is.tp3.domain.Articulo;
import is.tp3.repositories.RepositorioArticulo;

public class ServicioBuscarArticulo {

    private final RepositorioArticulo repositorio;

    public ServicioBuscarArticulo(RepositorioArticulo repositorio){

        this.repositorio = repositorio;
    }

    public Articulo buscarArticulo(Integer codigo)
    {

        return repositorio.buscarArticulo(codigo);
    }
}
