package is.tp3.domain;

public class Articulo {
    private int codigo;
    private String nombre;
    private Double costo;
    private Double margenGanancia;

    public Double getPrecioVenta(){
        double netoGravado = costo + (costo * margenGanancia);
        double iva = netoGravado * 0.21;
        return netoGravado + iva;
    }

    public Articulo() {
    }

    public Articulo(int codigo, String nombre, Double costo, Double margenGanancia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.costo = costo;
        this.margenGanancia = margenGanancia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Double getMargenGanancia() {
        return margenGanancia;
    }

    public void setMargenGanancia(Double margenGanancia) {
        this.margenGanancia = margenGanancia;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", costo=" + costo +
                ", margenGanancia=" + margenGanancia +
                '}';
    }
}
