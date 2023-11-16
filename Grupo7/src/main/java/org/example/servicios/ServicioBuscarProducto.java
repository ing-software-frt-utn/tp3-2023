package org.example.servicios;

import org.example.domain.Stock;
import org.example.repositorios.RepositorioStock;

import java.util.List;

public class ServicioBuscarProducto {

    private RepositorioStock repositorio;

    public ServicioBuscarProducto(RepositorioStock repositorio) {
        this.repositorio = repositorio;
    }

    public List<Stock> buscarStockDisponible(int codigoProducto) {
        List<Stock> stocks = repositorio.buscarStockDisponiblePorCodigo(codigoProducto);

        boolean stocks3 = stocks.stream().anyMatch(stock -> stock.stock > 0);

        if(!stocks3) {
            throw new RuntimeException("Producto sin stock");
        }

        if (stocks == null || stocks.isEmpty()){

            throw new RuntimeException("Producto no encontrado");
        }else{
            return stocks;
        }
    }
}
