package domain;

public class Venta {

    private EstadoVenta estadoVenta;


    public Venta(){


    }
    public Venta(EstadoVenta estadoVenta){
        this.estadoVenta = estadoVenta;
    }

    public EstadoVenta getEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(EstadoVenta estadoVenta) {
        this.estadoVenta = estadoVenta;
    }

}
