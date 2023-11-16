package edu.spring.istfi.model;

public class Talle {

    private int id;
    private String descripcion;

    public Talle(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Talle(String descripcion) {
        this.descripcion = descripcion;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Talle - ID: " + id +
                ", Descripción: " + descripcion;
    }
}
