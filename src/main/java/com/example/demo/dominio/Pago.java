package com.example.demo.dominio;

public class Pago {
    private double monto;
    private Venta venta;

    public Pago(double monto, Venta venta){
        this.monto = monto;
        this.venta = venta;
    }

    public Venta getVenta(){
        return this.venta;
    }

    public double getMonto(){
        return this.monto;
    }

    public boolean tieneCodigo(String idCompra){
        return venta.getId().equals(idCompra);
    }
}
