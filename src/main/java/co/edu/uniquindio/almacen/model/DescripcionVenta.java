package co.edu.uniquindio.almacen.model;

import java.util.ArrayList;

public class DescripcionVenta {
    private Producto producto;
    private int cantidadProductos;
    private double subtotal;

    public static void main(String[] args) {

    }
    public DescripcionVenta(){

    }

    public DescripcionVenta(Producto producto, int cantidadProductos, double subtotal) {
        this.producto = producto;
        this.cantidadProductos = cantidadProductos;
        this.subtotal = subtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
