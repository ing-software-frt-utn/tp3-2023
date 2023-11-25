package io.cucumber.tienda.domain;

public class Usuario {
    private String nombreUsuario;
    private String contraseña;

    public Usuario(String nomUsr, String cont) {
        nombreUsuario = nomUsr;
        contraseña = cont;
    }

    public String getNombreUsuario(){
        return nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }
}
