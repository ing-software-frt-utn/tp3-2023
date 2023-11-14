package io.cucumber.tienda.repositories;

import io.cucumber.tienda.domain.Articulo;
import io.cucumber.tienda.domain.Inventario;
import io.cucumber.tienda.domain.LineaDeVenta;
import io.cucumber.tienda.domain.Venta;

import java.util.ArrayList;

public interface RepositorioArticulo {
    Articulo buscarArticuloPorCodigo(Integer codigo);
    ArrayList<Inventario> buscarInventarioPorArticulo(Articulo articulo);
    Venta agregarLineaDeVenta(Venta venta,LineaDeVenta lineaDeVenta);
}
