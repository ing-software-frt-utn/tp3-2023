package edu.spring.istfi.model;

public enum CondicionTributaria {

    RESPONSABLE_INSCRIPTO("Responsable Inscripto"),
    MONOTRIBUTO("Monotributo"),
    EXENTO("Exento"),
    NO_RESPONSABLE("No Responsable"),
    CONSUMIDOR_FINAL("Consumidor Final");

    private final String descripcion;

    CondicionTributaria(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
