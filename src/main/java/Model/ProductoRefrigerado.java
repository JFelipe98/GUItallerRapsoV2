package Model;

public class ProductoRefrigerado extends Producto{
    private String codigoAprob;
    private double tempRecomendada;

    public ProductoRefrigerado() {
        super();
    }

    public ProductoRefrigerado(String tipoProducto,String codigo, String nombre, String descripcion,
                               Double valorUni, int cantidadExi, String codigoAprob,
                               double tempRecomendada) {
        super(tipoProducto, codigo, nombre, descripcion, valorUni, cantidadExi);
        this.codigoAprob = codigoAprob;
        this.tempRecomendada = tempRecomendada;
    }

    public String getCodigoAprob() {
        return codigoAprob;
    }

    public void setCodigoAprob(String codigoAprob) {
        this.codigoAprob = codigoAprob;
    }

    public double getTempRecomendada() {
        return tempRecomendada;
    }

    public void setTempRecomendada(double tempRecomendada) {
        this.tempRecomendada = tempRecomendada;
    }
}