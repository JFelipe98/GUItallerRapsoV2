package co.edu.uniquindio.almacen.model;

import java.util.Calendar;

public class ProductoPerecible extends Producto {
    private Calendar fechaVencimiento;

    public ProductoPerecible() {
        super();
    }

    public ProductoPerecible(String codigo, String nombre, String descripcion,
                             Double valorUni, int cantidadExi, Calendar fechaVencimiento) {
        super(codigo, nombre, descripcion, valorUni, cantidadExi);
        this.fechaVencimiento = fechaVencimiento;
    }

    public Calendar getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Calendar fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
