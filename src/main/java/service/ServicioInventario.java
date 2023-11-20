package service;

import domain.Articulo;
import domain.Inventario;
import repositorie.IRepositorioInventario;

import java.util.ArrayList;

public class ServicioInventario implements IRepositorioInventario {
    private final IRepositorioInventario repositorio;

    public ServicioInventario(IRepositorioInventario repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public ArrayList<Inventario> buscarInventario(Articulo a) {
        return repositorio.buscarInventario(a);
    }
}
