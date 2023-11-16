package edu.spring.istfi.model;

public class TipoTalle {
    private int id;
    private String descripcion;

    public TipoTalle(int id, String descripcion) {
        this.id = id;
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
        return "TipoTalle - ID: " + id +
                ", Descripción: " + descripcion;
    }
}
