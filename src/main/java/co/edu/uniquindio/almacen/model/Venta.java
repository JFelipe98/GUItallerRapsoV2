package co.edu.uniquindio.almacen.model;

import java.util.ArrayList;
import java.util.Calendar;

public class Venta {
    private String codigo;
    private Calendar fecha;
    private ArrayList<DescripcionVenta> descripcionVenta;
    private Cliente cliente;
    private double total;
    private double iva;

    public static void main(String[] args) {

    }
    public Venta (){

    }


    public Venta(String codigo, Calendar fecha, ArrayList<DescripcionVenta> descripcionVenta, Cliente cliente, double total, double iva) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.descripcionVenta = descripcionVenta;
        this.cliente = cliente;
        this.total = total;
        this.iva = iva;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public ArrayList<DescripcionVenta> getDescripcionVenta() {return descripcionVenta;
    }

    public void setDescripcionVenta(ArrayList<DescripcionVenta> descripcionVenta) {
        this.descripcionVenta = descripcionVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

}
