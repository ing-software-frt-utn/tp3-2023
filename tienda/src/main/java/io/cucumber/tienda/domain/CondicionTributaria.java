package io.cucumber.tienda.domain;

public class CondicionTributaria {
    private final String tipo;

    public CondicionTributaria(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}