package io.cucumber.tienda.domain;

public class Cliente {
    private String dni;
    private String nombre;
    private final CondicionTributaria condicionTributaria;

    public Cliente(String dni, String nombre, CondicionTributaria condicionTributaria) {
        this.dni = dni;
        this.nombre = nombre;

        if(condicionTributaria.getTipo() != null){
            this.condicionTributaria = condicionTributaria;
        }
        else {
            this.condicionTributaria = new CondicionTributaria("Consumidor Final");
        }
    }

    public Cliente(){
        this.condicionTributaria = new CondicionTributaria("Consumidor Final");
    }

    public Cliente(CondicionTributaria condicionTributaria) {
        this.condicionTributaria = condicionTributaria;
    }


    public CondicionTributaria getCondicionTributaria() {
        return condicionTributaria;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }
}