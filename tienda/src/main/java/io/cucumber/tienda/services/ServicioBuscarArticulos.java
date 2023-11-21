package io.cucumber.tienda.services;

import io.cucumber.tienda.domain.*;
import io.cucumber.tienda.repositories.RepositorioArticulo;
import io.cucumber.tienda.repositories.RepositorioInventario;

import java.util.ArrayList;

public class ServicioBuscarArticulos {
    RepositorioArticulo repositorioArticulo;
    RepositorioInventario repositorioInventario;

    public ServicioBuscarArticulos(final RepositorioArticulo repositorioArticulo){
        this.repositorioArticulo = repositorioArticulo;
    }
    public Articulo buscarArticulos(Integer codigo){
        return repositorioArticulo.buscarArticuloPorCodigo(codigo);
    }
    public ArrayList<Inventario> buscarInventarios(Integer codigo){
        return repositorioInventario.buscarInventarioPorCodigo(codigo);
    }
}
