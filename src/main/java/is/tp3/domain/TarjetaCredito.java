package is.tp3.domain;

public class TarjetaCredito {
    private String numero;
    private Long dniTitular;
    private String nombrePropietario;
    private Long codigoSeguridad;
    private String fechaVencimiento;

    public TarjetaCredito() {
    }

    public TarjetaCredito(String numero, Long dniTitular, String nombrePropietario, Long codigoSeguridad, String fechaVencimiento) {
        this.numero = numero;
        this.dniTitular = dniTitular;
        this.nombrePropietario = nombrePropietario;
        this.codigoSeguridad = codigoSeguridad;
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Long getDniTitular() {
        return dniTitular;
    }

    public void setDniTitular(Long dniTitular) {
        this.dniTitular = dniTitular;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public Long getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(Long codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String toString() {
        return "TarjetaCredito{" +
                "numero=" + numero +
                ", dniTitular=" + dniTitular +
                ", nombrePropietario='" + nombrePropietario + '\'' +
                ", codigoSeguridad=" + codigoSeguridad +
                ", fechaVencimiento='" + fechaVencimiento + '\'' +
                '}';
    }
}
