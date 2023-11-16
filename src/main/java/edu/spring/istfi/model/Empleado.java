package edu.spring.istfi.model;

import java.util.Date;
public class Empleado {

    private int legajo;
    private String nombre;
    private String apellido;
    private String usuario;
    private String contrasena;
    private Date fechaNacimiento;
    private Rol rol;
    private int edad;

    // Constructor
    public Empleado(int legajo, String nombre, String apellido, String usuario, String contrasena,
                    Date fechaNacimiento, Rol rol) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.fechaNacimiento = fechaNacimiento;
        this.rol = rol;
        // Calcular la edad
        this.edad = calcularEdad();
    }

    // Getter para la edad
    public int getEdad() {
        return edad;
    }
    // Método para calcular la edad si es que es necesario
    private int calcularEdad() {
        return 0;  // Reemplaza esto con la implementación real
    }
}
