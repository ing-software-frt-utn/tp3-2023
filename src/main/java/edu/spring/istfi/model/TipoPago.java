package edu.spring.istfi.model;

public enum TipoPago {
    EFECTIVO("Efectivo"),
    TARJETA_DEBITO("Tarjeta débito"),
    TARJETA_CREDITO("Tarjeta crédito");

    private final String descripcion;

    TipoPago(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
