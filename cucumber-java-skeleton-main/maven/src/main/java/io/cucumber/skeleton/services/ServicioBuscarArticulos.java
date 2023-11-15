package io.cucumber.skeleton.services;

import io.cucumber.skeleton.domain.Articulo;
import io.cucumber.skeleton.repositories.RepositorioArticulo;

public class ServicioBuscarArticulos {


    RepositorioArticulo repositorioArticulo;
    public Articulo buscarArticulo(Integer codigo){

        return repositorioArticulo.buscarArticuloPorCodigo(codigo);
    }
}
