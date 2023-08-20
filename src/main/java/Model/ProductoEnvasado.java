package Model;

public class ProductoEnvasado extends Producto{
    private String fechaEnvasado;
    private double pesoEnvase;
    private enum paisOrigen {ARGENTINA,CHILE,COLOMBIA,ECUADOR, PERU};

    public ProductoEnvasado() {
        super();
    }

    public ProductoEnvasado(String tipoProducto,String codigo, String nombre, String descripcion,
                            Double valorUni, int cantidadExi, String fechaEnvasado,
                            double pesoEnvase) {
        super(tipoProducto,codigo, nombre, descripcion, valorUni, cantidadExi);
        this.fechaEnvasado = fechaEnvasado;
        this.pesoEnvase = pesoEnvase;
    }

    public String getFechaEnvasado() {
        return fechaEnvasado;
    }

    public void setFechaEnvasado(String fechaEnvasado) {
        this.fechaEnvasado = fechaEnvasado;
    }

    public double getPesoEnvase() {
        return pesoEnvase;
    }

    public void setPesoEnvase(double pesoEnvase) {
        this.pesoEnvase = pesoEnvase;
    }
}