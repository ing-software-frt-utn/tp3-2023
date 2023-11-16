package edu.spring.istfi.model;

import javax.persistence.Entity;

@Entity
public class Cliente {

    private int id;
    private int DNI;
    private int CUIT;
    private String Nombre;
    private String Apellido;
    private String razonSocial;

    private Direccion direccion;

    // Constructor
    public Cliente(int id, int DNI, int CUIT, String razonSocial,String Nombre,String Apellido ,Direccion direccion) {
        this.id = id;
        this.DNI = DNI;
        this.CUIT = CUIT;
        this.razonSocial = razonSocial;
        this.Nombre=Nombre;
        this.Apellido=Apellido;
        this.direccion = direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getCUIT() {
        return CUIT;
    }

    public void setCUIT(int CUIT) {
        this.CUIT = CUIT;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
