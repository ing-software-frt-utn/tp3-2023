package is.tp3.domain;

public class Venta {
    private int numero;
    private String fecha;
    private String estado;
    private Pago pago;
    private Double total;
    private Cliente cliente;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Venta() {
    }

    public Venta(int numero, String fecha, String estado, Pago pago, Double total) {
        this.numero = numero;
        this.fecha = fecha;
        this.estado = estado;
        this.pago = pago;
        this.total = total;
    }

    public Venta(int numero, String fecha, String estado, Double total, Cliente cliente) {
        this.numero = numero;
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
        this.cliente = cliente;
    }
}
