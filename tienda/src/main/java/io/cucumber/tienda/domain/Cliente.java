package io.cucumber.tienda.domain;

public class Cliente {
    private String nombre;
    private CondicionTributaria condicionTributaria;

    public Cliente(String nombre, CondicionTributaria condicionTributaria) {
        if(condicionTributaria == null){
            this.condicionTributaria = condicionTributaria;
        }
        else {
            this.condicionTributaria = new CondicionTributaria("Consumidor Final");
        }
    }
    public Cliente(CondicionTributaria condicionTributaria) {
        this.condicionTributaria = condicionTributaria;
    }

    public Cliente(){
        this.condicionTributaria = new CondicionTributaria("Consumidor Final");
    }

    public CondicionTributaria getCondicionTributaria() {
        return condicionTributaria;
    }
    public void setCondicionTributaria(CondicionTributaria nuevaCondicionTributaria) {
        this.condicionTributaria = nuevaCondicionTributaria;
    }
}