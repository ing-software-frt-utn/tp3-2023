package io.cucumber.tienda.repositories;

import io.cucumber.tienda.domain.Articulo;
import io.cucumber.tienda.domain.Inventario;

import java.util.ArrayList;

public interface RepositorioInventario {
    ArrayList<Inventario> buscarInventarioPorCodigo(Integer codigo);
}
