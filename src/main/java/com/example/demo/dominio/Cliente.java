package com.example.demo.dominio;

public class Cliente {
    private String dni;
    private String nombre;
    private String domicilio;

    public Cliente(String dni, String nombre, String domicilio){
        this.dni = dni;
        this.nombre = nombre;
        this.domicilio = domicilio;
    }

    public boolean tieneDni(String dni) {
        return this.dni.equals(dni);
    }

    public String getDni() {
        return this.dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDomicilio() {
        return this.domicilio;
    }
}
