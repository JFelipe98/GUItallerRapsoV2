package Model;

import java.util.Calendar;

public class ProductoPerecible extends Producto {
    private String fechaVencimiento;

    public ProductoPerecible() {
        super();
    }

    public ProductoPerecible(String tipoProducto, String codigo, String nombre, String descripcion,
                             Double valorUni, int cantidadExi, String fechaVencimiento) {
        super(tipoProducto,codigo, nombre, descripcion, valorUni, cantidadExi);
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}