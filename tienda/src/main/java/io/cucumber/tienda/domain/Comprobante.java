package io.cucumber.tienda.domain;

public class Comprobante {
    private final String tipo;

    public Comprobante(Cliente cliente) {
        this.tipo = determinarTipoComprobante(cliente.getCondicionTributaria());
    }
    public Comprobante(String tipo) {
        this.tipo = tipo;
    }

    private String determinarTipoComprobante(CondicionTributaria condicionTributaria) {
        return switch (condicionTributaria.getTipo()) {
            case "Responsable Inscripto", "Monotributista" -> "Factura A";
            case "Exento", "No Responsable" -> "Factura B";
            default -> "Factura Invalida";
        };
    }

    public String getTipo() {
        return tipo;
    }
}
