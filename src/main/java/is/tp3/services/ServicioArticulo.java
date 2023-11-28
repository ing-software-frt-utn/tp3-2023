package is.tp3.services;

import is.tp3.domain.Articulo;
import is.tp3.domain.Cliente;
import is.tp3.repositories.RepositorioArticulo;
import is.tp3.repositories.RepositorioCliente;

public class ServicioArticulo {


    private RepositorioArticulo repositorioArticulo;

    public ServicioArticulo(RepositorioArticulo repositorio){
        this.repositorioArticulo = repositorio;
    }

    public Articulo buscarArticulo(int codigo)  {



            return repositorioArticulo.buscarArticulo(codigo);



    }

}
