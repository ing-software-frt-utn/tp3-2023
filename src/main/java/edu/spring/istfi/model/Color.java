package edu.spring.istfi.model;

public class Color {
    private int id;
    private String descripcion;

    public Color(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Color(String descripcion) {
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
        return "Color - ID: " + id +
                ", Descripción: " + descripcion;
    }

}
