package service;

import domain.Articulo;
import domain.Inventario;
import repositorie.RepositorioInventario;

import java.util.ArrayList;

public class ServicioInventario implements RepositorioInventario {
    private final RepositorioInventario repositorio;

    public ServicioInventario(RepositorioInventario repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public ArrayList<Inventario> buscarInventario(Articulo a) {
        return repositorio.buscarInventario(a);
    }

    @Override
    public Articulo buscarArticulo(int codigo) {
        return repositorio.buscarArticulo(codigo);
    }
}
