package edu.spring.istfi.model;

public class Marca {
    private int id;
    private String descripcion;

    public Marca(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Marca(String descripcion) {
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
        return "Marca - ID: " + id +
                ", Descripción: " + descripcion;
    }
}
