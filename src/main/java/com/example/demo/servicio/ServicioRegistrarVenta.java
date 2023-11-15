package com.example.demo.servicio;


import com.example.demo.dominio.Venta;
import com.example.demo.dominio.Producto;
import com.example.demo.repositorio.RepositorioVenta;

public class ServicioRegistrarVenta {
    private RepositorioVenta repositorioVenta;

    public ServicioRegistrarVenta(RepositorioVenta repositorioVenta){
        this.repositorioVenta = repositorioVenta;
    }

    public Venta ingresarVenta(String id, double monto, Producto producto){
        Venta venta = new Venta(id, monto, producto);
        repositorioVenta.ingresarVenta(venta);
        return venta;
    }

    public Venta buscarVenta(String idCompra) {
        return repositorioVenta.buscarVenta(idCompra);
    }
}
