package is.tp3.domain;

public class Pago {
    private Double monto;
    private TipoPago tipoPago;

    public Pago() {
    }

    public Pago(Double monto, TipoPago tipoPago) {
        this.monto = monto;
        this.tipoPago=tipoPago;
    }

    public Pago(Double monto) {
        this.monto = monto;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}
