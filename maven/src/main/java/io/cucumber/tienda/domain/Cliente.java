package io.cucumber.tienda.domain;

public class Cliente {
    private String nombre;
    private int dni;
    private CondicionTributaria condicionTributaria;

    // Constructor
    public Cliente(String nombre, int dni, CondicionTributaria condicionTributaria) {
        this.nombre = nombre;
        this.dni = dni;
        this.condicionTributaria = condicionTributaria;
    }

}

