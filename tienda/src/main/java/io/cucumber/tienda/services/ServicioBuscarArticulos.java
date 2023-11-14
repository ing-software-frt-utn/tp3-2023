package io.cucumber.tienda.services;

import io.cucumber.tienda.domain.Articulo;
import io.cucumber.tienda.repositories.RepositorioArticulo;

public class ServicioBuscarArticulos {
    RepositorioArticulo repositorioArticulo;
    public Articulo buscarArticulos(Integer codigo){
        return repositorioArticulo.buscarArticuloPorCodigo(codigo);
    }
}
