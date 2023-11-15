package com.example.demo.constante;

public enum IVA {
    IVA21(0.21);
    private double porcentaje;

    IVA(double porcentaje){
        this.porcentaje = porcentaje;
    }
    public double porcentajeIVA(){
        return porcentaje;
    }
}
