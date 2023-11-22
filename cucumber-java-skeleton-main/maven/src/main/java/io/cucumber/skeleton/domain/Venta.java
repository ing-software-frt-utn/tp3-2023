package io.cucumber.skeleton.domain;

public class Venta {
    Cliente cliente;

    public Venta(){
    }

    public Venta(Cliente cliente){
    this.cliente = cliente;
    }
}
