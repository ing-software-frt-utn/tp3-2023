package com.example.demo.dominio;

public class Venta {
    private String id;
    private double monto;
    private boolean estadoPago;
    private Producto producto;

    public Venta(String id, double monto, Producto producto){
        this.id = id;
        this.monto = monto;
        this.producto = producto;
        this.estadoPago = false;
    }
    public void setEstadoPago(boolean estado){
        this.estadoPago = estado;
    }

    public double getMonto(){
        return this.monto;
    }

    public String getId(){
        return this.id;
    }

    public boolean tieneCodigo(String id) {
        return this.id.equals(id);
    }
    public boolean getEstadoPago(){
        return this.estadoPago;
    }

    public Producto getProducto(){
        return producto;
    }

}
