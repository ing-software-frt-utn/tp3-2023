package is.tp3.domain;

@SuppressWarnings("SpellCheckingInspection")
public class Venta {

    private Cliente clienteAsociado;
    private Double total;
    private String metodoPago;

    public Venta(Cliente clienteAsociado, Double total) {
        this.clienteAsociado = clienteAsociado;
        this.total = total;
    }

    public Venta(Cliente clienteAsociado) {
        this.clienteAsociado = clienteAsociado;
    }

    public Cliente getClienteAsociado() {
        return clienteAsociado;
    }

    public Double getTotalVenta() {
        return total;
    }

    public String getMetodoPago(){
        return metodoPago;
    }

    public void asociarCliente(Cliente clienteAsoc) {
        this.clienteAsociado = clienteAsoc;
    }

    public void establecerMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void verificarFinalizacionVenta() {
        if (this.total > 92700.0 && this.clienteAsociado.getDni() == 0) {
            throw new RuntimeException("ERROR. Debido a que el monto total es mayor a $92.700, debe asociar un cliente a la venta.");
        }
    }

}