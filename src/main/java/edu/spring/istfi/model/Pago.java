package edu.spring.istfi.model;

import java.util.Date;
public class Pago {
    private int codigo;
    private Date fecha;
    private double monto;

    public Pago(int codigo, Date fecha, double monto) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.monto = monto;
    }

    // Getters y setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
