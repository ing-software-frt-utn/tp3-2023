package edu.spring.istfi.model;

public class PuntoVenta {
    private int numero;

    public PuntoVenta(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void iniciarVenta() {
        // Lógica para iniciar una venta
        System.out.println("Venta iniciada en el punto de venta " + numero);
    }

    public void autorizarPago() {
        // Lógica para autorizar un pago
        System.out.println("Pago autorizado en el punto de venta " + numero);
    }

    public void emitirComprobante() {
        // Lógica para emitir un comprobante
        System.out.println("Comprobante emitido en el punto de venta " + numero);
    }

    public void cancelarVenta() {
        // Lógica para cancelar una venta
        System.out.println("Venta cancelada en el punto de venta " + numero);
    }

    @Override
    public String toString() {
        return "Punto de Venta - Número: " + numero;
    }
}
