package com.universidad.post1_u11.model;

public class CodigoDescuento {
    private String codigo;
    private double porcentaje;

    public CodigoDescuento() {
    }

    public CodigoDescuento(String codigo, double porcentaje) {
        this.codigo = codigo;
        this.porcentaje = porcentaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
}
