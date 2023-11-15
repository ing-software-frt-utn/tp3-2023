package com.example.demo.dominio;

public class Factura {
    private String numero;
    private Venta compra;
    private Cliente cliente;

    public Factura(String numero, Venta compra, Cliente cliente){
        this.numero = numero;
        this.compra = compra;
        this.cliente = cliente;
    }

    public boolean tieneNumero(String num) {
        return this.numero.equals(num);
    }
}
