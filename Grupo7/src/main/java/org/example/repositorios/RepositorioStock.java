package org.example.repositorios;

import org.example.domain.Stock;

import java.util.List;

public interface RepositorioStock {
    public List<Stock> buscarStockDisponiblePorCodigo(int codigo);
}
