package edu.spring.istfi.model;

public class Pais {
    private int codigo;
    private String nombre;

    public Pais(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    // Getter y Setter para código
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    // Getter y Setter para nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nombre: " + nombre;
    }
}
