package com.universidad.post1_u11.model;

public class LineaPedido {
    private Long productoId;
    private double precioUnitario;
    private int cantidad;

    public LineaPedido() {
    }

    public LineaPedido(Long productoId, double precioUnitario, int cantidad) {
        this.productoId = productoId;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
