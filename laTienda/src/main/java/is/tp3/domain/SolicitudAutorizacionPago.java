package is.tp3.domain;

public class SolicitudAutorizacionPago {
    private TarjetaCredito tarjetaCredito;
    private Double monto;
    private String estado;

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public SolicitudAutorizacionPago(TarjetaCredito tarjetaCredito, Double monto, String estado) {
        this.tarjetaCredito = tarjetaCredito;
        this.monto = monto;
        this.estado = estado;
    }

    public TarjetaCredito getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(TarjetaCredito tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public SolicitudAutorizacionPago(TarjetaCredito tarjetaCredito, Double monto) {
        this.tarjetaCredito = tarjetaCredito;
        this.monto = monto;
    }
}
