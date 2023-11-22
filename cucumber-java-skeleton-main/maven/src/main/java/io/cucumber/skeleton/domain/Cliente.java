package io.cucumber.skeleton.domain;

public class Cliente {
    private final String nombre;
    private final String condicionTributaria;
    private final String dni;
    public Cliente(String nombre, String condicionTributaria, String dni) {
        this.nombre = nombre;
        this.condicionTributaria = condicionTributaria;
        this.dni = dni;
    }
}
