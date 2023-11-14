package is.tp3.domain;

public class Cliente {
    private String nomYAp;
    private String condicionTributaria;
    private String razonSocial;
    private String CUIT;
    private String DNI;
    private String domicilio;
    private String localidad;

    public Cliente(String nomYAp, String condicionTributaria, String razonSocial, String CUIT, String DNI, String domicilio, String localidad) {
        this.nomYAp = nomYAp;
        this.condicionTributaria = condicionTributaria;
        this.razonSocial = razonSocial;
        this.CUIT = CUIT;
        this.DNI = DNI;
        this.domicilio = domicilio;
        this.localidad = localidad;
    }

    public Cliente() {
    }

    public String getNomYAp() {
        return nomYAp;
    }

    public void setNomYAp(String nomYAp) {
        this.nomYAp = nomYAp;
    }

    public String getCondicionTributaria() {
        return condicionTributaria;
    }

    public void setCondicionTributaria(String condicionTributaria) {
        this.condicionTributaria = condicionTributaria;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCUIT() {
        return CUIT;
    }

    public void setCUIT(String CUIT) {
        this.CUIT = CUIT;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}
