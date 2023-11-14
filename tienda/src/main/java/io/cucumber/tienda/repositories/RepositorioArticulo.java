package io.cucumber.tienda.repositories;

import io.cucumber.tienda.domain.Articulo;
import io.cucumber.tienda.domain.Inventario;

import java.util.ArrayList;

public interface RepositorioArticulo {
    Articulo buscarArticuloPorCodigo(Integer codigo);
    ArrayList<Inventario> buscarInventarioPorArticulo(Articulo articulo);
    Articulo crearArtiuclo(Articulo articulo);
}
