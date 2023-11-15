package com.example.demo.dominio;

import com.example.demo.constante.IVA;

import java.util.UUID;

public class Producto {
    private String id;
    private String nombre;
    private double costo;
    private double margenGanancia;
    private String talle;
    private String color;

    private IVA iva;

    public Producto(String id, String nombre, String talle, String color){
        this.id = id;
        this.nombre = nombre;
        this.talle = talle;
        this.color = color;
    }

    public Producto(String nombre, String talle, String color){
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.talle = talle;
        this.color = color;
    }

    public Producto(String nombre, double costo, double margenGanancia, String talle, String color){
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.costo = costo;
        this.margenGanancia = margenGanancia;
        this.talle = talle;
        this.color = color;
        this.iva = IVA.IVA21;
    }

    public double precioVenta() {
        double precioVenta = 0;
        precioVenta = costo * margenGanancia / 100 + costo;
        precioVenta = precioVenta * iva.porcentajeIVA() + precioVenta;
        return precioVenta;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getCosto() {
        return this.costo;
    }

    public double getMargenGanancia() {
        return this.margenGanancia;
    }

    public String getTalle() {
        return this.talle;
    }

    public String getColor() {
        return this.color;
    }
}
