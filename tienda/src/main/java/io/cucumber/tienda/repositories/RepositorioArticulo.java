package io.cucumber.tienda.repositories;

import io.cucumber.tienda.domain.Articulo;

public interface RepositorioArticulo {
    Articulo buscarArticuloPorCodigo(Integer codigo);
}
