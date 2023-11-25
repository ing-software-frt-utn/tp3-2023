package io.cucumber.tienda.domain;

public class PuntoDeVenta {
    private Integer id;
    private Usuario usuario;
    private Boolean valido;

    public PuntoDeVenta(int num, boolean val) {
        id = num;
        usuario = null;
        valido = val;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public boolean validarSesion(){
        if(usuario != null)
        {
            return true;
        }
        return false;
    }
    public void iniciarSesion(Usuario ing){
        usuario = ing;
    }
}
