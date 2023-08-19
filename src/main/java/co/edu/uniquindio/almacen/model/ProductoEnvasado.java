package co.edu.uniquindio.almacen.model;

import java.util.Calendar;

public class ProductoEnvasado extends Producto{
    private Calendar fechaEnvasado;
    private double pesoEnvase;
    private enum paisOrigen {ARGENTINA,CHILE,COLOMBIA,ECUADOR, PERU};

    public ProductoEnvasado() {
        super();
    }

    public ProductoEnvasado(String codigo, String nombre, String descripcion,
                            Double valorUni, int cantidadExi, Calendar fechaEnvasado,
                            double pesoEnvase) {
        super(codigo, nombre, descripcion, valorUni, cantidadExi);
        this.fechaEnvasado = fechaEnvasado;
        this.pesoEnvase = pesoEnvase;
    }

    public Calendar getFechaEnvasado() {
        return fechaEnvasado;
    }

    public void setFechaEnvasado(Calendar fechaEnvasado) {
        this.fechaEnvasado = fechaEnvasado;
    }

    public double getPesoEnvase() {
        return pesoEnvase;
    }

    public void setPesoEnvase(double pesoEnvase) {
        this.pesoEnvase = pesoEnvase;
    }
}
