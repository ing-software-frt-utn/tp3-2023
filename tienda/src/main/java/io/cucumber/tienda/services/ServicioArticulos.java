package io.cucumber.tienda.services;

import io.cucumber.tienda.domain.Articulo;
import io.cucumber.tienda.domain.Inventario;
import io.cucumber.tienda.repositories.RepositorioArticulo;

import java.util.ArrayList;

public class ServicioArticulos {
    private final RepositorioArticulo repositorioArticulo;

    public ServicioArticulos(final RepositorioArticulo repositorioArticulo){
        this.repositorioArticulo = repositorioArticulo;
    }
    public Articulo crearArticulo(final  Articulo articulo){
        if (articulo == null){
            throw new IllegalArgumentException("El articulo no puede ser nulo");
        }
        return repositorioArticulo.crearArtiuclo(articulo);
    }

    public Articulo buscarArticulos(final Integer codigo){
        return repositorioArticulo.buscarArticuloPorCodigo(codigo);
    }

    public ArrayList<Inventario> buscarInventario(final Articulo articulo){
        return repositorioArticulo.buscarInventarioPorArticulo(articulo);
    }
}
