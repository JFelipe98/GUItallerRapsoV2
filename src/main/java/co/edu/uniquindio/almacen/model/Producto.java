package co.edu.uniquindio.almacen.model;

public class Producto {

    private String codigo;
    private String nombre;
    private String descripcion;
    private double valorUni;
    private int cantidadExi;

    public static void main(String[] args) {

    }

    public Producto(){

    }

    public Producto(String codigo, String nombre, String descripcion, Double valorUni, int cantidadExi) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valorUni = valorUni;
        this.cantidadExi = cantidadExi;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getValorUni() {
        return valorUni;
    }

    public void setValorUni(Double valorUni) {
        this.valorUni = valorUni;
    }

    public int getCantidadExi() {
        return cantidadExi;
    }

    public void setCantidadExi(int cantidadExi) {
        this.cantidadExi = cantidadExi;
    }
}
