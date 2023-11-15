package com.example.demo.servicio;

import com.example.demo.dominio.Producto;
import com.example.demo.repositorio.RepositorioProducto;

public class ServicioRegistraProducto {
    private RepositorioProducto repositorioProducto;

    public ServicioRegistraProducto(RepositorioProducto repositorioProducto){
        this.repositorioProducto = repositorioProducto;
    }

    public Producto ingresarProducto(String id, String nombre, String talle, String color){
        Producto producto = new Producto(id, nombre, talle, color);
        repositorioProducto.ingresarProducto(producto);
        return producto;
    }

    public Producto ingresarProductoCompleto(String nombre, double costo, double margenGanancia, String talle, String color){
        Producto producto = new Producto(nombre, costo, margenGanancia, talle, color);
        repositorioProducto.ingresarProducto(producto);
        return producto;
    }

}
