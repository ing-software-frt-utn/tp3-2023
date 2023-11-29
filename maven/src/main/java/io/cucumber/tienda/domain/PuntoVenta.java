package io.cucumber.tienda.domain;

public class PuntoVenta {
  private Integer id;
  private Usuario usuario;

  public PuntoVenta(int num){
    this.id = num;
  }

public Usuario getUsuario(){
  return usuario;
}
  public boolean comprobarSesion(){
    if(usuario != null){
      return true;
    }
    return false;
  }
  public void iniciarSesion(Usuario us){
    this.usuario = us;
  }
}
  
