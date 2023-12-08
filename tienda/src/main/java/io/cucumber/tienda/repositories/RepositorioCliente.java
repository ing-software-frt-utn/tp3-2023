package io.cucumber.tienda.repositories;

import io.cucumber.tienda.domain.Cliente;
import io.cucumber.tienda.domain.LineaDeVenta;
import io.cucumber.tienda.domain.Venta;

import java.util.ArrayList;

public interface RepositorioCliente {
    Cliente buscarClientePorDNI(String codigo);
    Cliente buscarClientePorNombre(String nombre);
    Venta agregarAVenta(Venta venta, Cliente cliente);
}
