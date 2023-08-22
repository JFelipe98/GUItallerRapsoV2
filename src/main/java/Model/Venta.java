package Model;

import com.example.guitallerRepasov2.MainApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Calendar;

public class Venta {
    private String codigo;
    private Calendar fecha;
    private ObservableList<DetalleVenta> detalleVenta = FXCollections.observableArrayList();
    private Cliente cliente;
    private double total;
    private double iva;

    public Venta() {
    }

    public Venta(String codigo, Calendar fecha, ObservableList<DetalleVenta> detalleVenta, Cliente cliente, double total, double iva) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.detalleVenta = detalleVenta;
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

    public ObservableList<DetalleVenta> getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(ObservableList<DetalleVenta> detalleVenta) {
        this.detalleVenta = detalleVenta;
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
    public Producto buscarProducto(String codigo){
        Producto prod= new Producto("","","","",0.0,0);
        for (int i = 0; i< MainApplication.getProductos().size(); i++){
            if ((codigo.equals(MainApplication.getProductos().get(i).getCodigo()))){
                prod= MainApplication.getProductos().get(i);
            break;
            }
        }
        System.out.println(prod.getNombre());
        return prod;
    }

    public double calcularIva(){
        double iva=getTotal()*0.19;
        setIva(iva);
        return iva;
    }
    public double calcularTotal(){
        double total=0;
        for(int i =0;i<getDetalleVenta().size();i++){
            total=getDetalleVenta().get(i).getSubtotal()+total;
        }
        setTotal(total);
        return total;
    }
    public double calcularSubtotal(){
        double sub=total-iva;

        return sub;
    }
}
