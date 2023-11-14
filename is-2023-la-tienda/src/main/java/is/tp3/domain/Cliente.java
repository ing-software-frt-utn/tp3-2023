package is.tp3.domain;

import java.util.Objects;

public class Cliente {
    private Integer dni;
    private String condicionTributaria;
    private String cuilCuit;
    private String nombreRazonSocial;
    private String domicilio;
    private String localidad;

    public Cliente(Integer dni, String condicionTributaria, String cuilCuit, String nombreRazonSocial, String domicilio, String localidad) {
        this.dni = dni;
        this.condicionTributaria = condicionTributaria;
        this.cuilCuit = cuilCuit;
        this.nombreRazonSocial = nombreRazonSocial;
        this.domicilio = domicilio;
        this.localidad = localidad;
    }

    public Integer getDni() {
        return dni;
    }

    public String getCondicionTributaria() {
        return condicionTributaria;
    }

    public String getCuilCuit() {
        return cuilCuit;
    }

    public String getNombreRazonSocial() {
        return nombreRazonSocial;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public boolean tieneDni(Integer dni) {
        return this.dni.equals(dni);
    }

}
