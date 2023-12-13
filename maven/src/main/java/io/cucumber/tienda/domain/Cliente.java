package io.cucumber.tienda.domain;

public class Cliente {
    private String nombre;
    private int dni;
    private CondicionTributaria condicionTributaria;

    public Cliente(String nombre, int dni, CondicionTributaria condicionTributaria) {
        this.nombre = nombre;
        this.dni = dni;
        this.condicionTributaria = condicionTributaria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return dni == cliente.dni && (nombre == null ? cliente.nombre == null : nombre.equals(cliente.nombre));
    }
}

