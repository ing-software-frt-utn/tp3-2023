package domain;

import org.jetbrains.annotations.NotNull;

public class Venta {

    private Double montoVenta;
    private EstadoVenta estadoVenta;


    public Venta(){
    }


    public void setEstadoVenta(EstadoVenta estadoVenta) {
        this.estadoVenta = estadoVenta;
    }

    public EstadoVenta getEstadoVenta() {
        return estadoVenta;
    }

    public Double getMontoVenta() {
        return montoVenta;
    }

    public void AutorizacionAFIP(Boolean respuesta){
        if (respuesta.equals(true))this.estadoVenta = EstadoVenta.APROBADA;
        else this.estadoVenta = EstadoVenta.RECHAZADA;
    }

}
