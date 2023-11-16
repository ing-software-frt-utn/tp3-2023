package edu.spring.istfi.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long codigo;
    private String descripcion;
    private double costo;
    private double margenDeGanancia;
    private double iva = 0.21;

    private Talle talle;
    private Color color;
    private Marca marca;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    private Categoria categoria;

    public void setTalle(Talle talle) {
        this.talle = talle;
    }

    public Talle getTalle() {
        return talle;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Marca getMarca() {
        return marca;
    }

    // Constructor sin argumentos necesario para JPA
    public Articulo() {
    }

    // Constructor con argumentos
    public Articulo(String descripcion, double costo, double margenDeGanancia) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        if (costo < 0) throw new RuntimeException("No se puede crear articulos con costo negativo");
        this.costo = costo;
        if (margenDeGanancia < 0) throw new RuntimeException("No se puede crear articulos con margen de ganancia negativo");
        this.margenDeGanancia = margenDeGanancia;
        this.iva = iva;
    }

    public Articulo(long codigo, String descripcion, double costo, double margenDeGanancia, double iva) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.costo = costo;
        this.margenDeGanancia = margenDeGanancia;
        this.iva = iva;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getMargenDeGanancia() {
        return margenDeGanancia;
    }

    public void setMargenDeGanancia(double margenDeGanancia) {
        this.margenDeGanancia = margenDeGanancia;
    }

    public double getIVA() {
        return iva;
    }

    public void setIVA(double iva) {
        this.iva = iva;
    }

    public double getPrecioDeVenta() {
       double netoGravado = calcularNetoGravado();
       double importeIVA = netoGravado * iva;
       return netoGravado + importeIVA;
    }

    private double calcularNetoGravado(){
        return costo * (margenDeGanancia / 100) + costo;
    }

    public double getNetoGravado() {
        // Implementa la lógica para calcular el neto gravado
        return costo + (costo * margenDeGanancia);
    }

    public double getCostoIVA() {
        // Implementa la lógica para calcular el costo con IVA
        return getNetoGravado() * (1 + (iva / 100));
    }



    @Override
    public String toString() {
        return "Articulo - ID: " + id +
                ", Código: " + codigo +
                ", Descripción: " + descripcion +
                ", Costo: " + costo +
                ", Margen de Ganancia: " + margenDeGanancia +
                ", IVA: " + iva +
                ", Neto Gravado: " + getNetoGravado() +
                ", Costo con IVA: " + getCostoIVA() +
                ", Precio de Venta: " + getPrecioDeVenta();
    }
}
