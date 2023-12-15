package is.tp3.domain;

import java.util.List;

public class Venta {
    private int numero;
    private String fecha;
    private Pago pago;
    private Cliente cliente;
    private List<LineaVenta> lineasVenta;
    public LineaVenta crearLineaVenta(Articulo articulo, int cantidad) {
        LineaVenta lineaVenta = new LineaVenta();
        lineaVenta.setCantidad(cantidad);
        lineaVenta.setProducto(articulo);
        return  lineaVenta;
    }
    public Double getTotal() {
        Double total = 0.0;
        for (LineaVenta lineaVenta : lineasVenta) {
            total += lineaVenta.getSubtotal();
        }
        return total;
    }

    public Venta() {
    }

    public Venta(int numero, String fecha, String estado, Pago pago, Cliente cliente, List<LineaVenta> lineasVenta) {
        this.numero = numero;
        this.fecha = fecha;
        this.pago = pago;
        this.cliente = cliente;
        this.lineasVenta = lineasVenta;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<LineaVenta> getLineasVenta() {
        return lineasVenta;
    }

    public void setLineasVenta(List<LineaVenta> lineasVenta) {
        this.lineasVenta = lineasVenta;
    }
}
