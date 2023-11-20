package service;

import domain.Articulo;
import repositorie.IRepositorioArticulo;

public class ServicioArticulo implements IRepositorioArticulo {

    private final IRepositorioArticulo repositorio;

    public ServicioArticulo(IRepositorioArticulo repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Articulo buscarArticulo(int codigo) {
        return repositorio.buscarArticulo(codigo);
    }
}
