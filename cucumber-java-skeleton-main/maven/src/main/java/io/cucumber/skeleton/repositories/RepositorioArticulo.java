package io.cucumber.skeleton.repositories;

import io.cucumber.skeleton.domain.Articulo;

public interface RepositorioArticulo {
    Articulo buscarArticuloPorCodigo(Integer codigo);
}
