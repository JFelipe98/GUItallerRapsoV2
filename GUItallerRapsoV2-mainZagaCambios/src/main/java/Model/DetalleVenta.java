package Model;

public class DetalleVenta {
    private int cantidad;
    private double subtotal=0;
    private Producto producto;

    public DetalleVenta() {
    }

    public DetalleVenta(int cantidad, Producto producto) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = cantidad*producto.getValorUni();

    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public double calcularSubtotal (Producto producto){
        subtotal=cantidad*producto.getValorUni();
        return subtotal;
    }
}
