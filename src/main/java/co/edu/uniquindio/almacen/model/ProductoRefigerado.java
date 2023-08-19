package co.edu.uniquindio.almacen.model;

public class ProductoRefigerado extends Producto{
    private String coidoAprob;
    private double tempRecomendada;

    public ProductoRefigerado() {
        super();
    }

    public ProductoRefigerado(String codigo, String nombre, String descripcion,
                              Double valorUni, int cantidadExi, String coidoAprob,
                              double tempRecomendada) {
        super(codigo, nombre, descripcion, valorUni, cantidadExi);
        this.coidoAprob = coidoAprob;
        this.tempRecomendada = tempRecomendada;
    }

    public String getCoidoAprob() {
        return coidoAprob;
    }

    public void setCoidoAprob(String coidoAprob) {
        this.coidoAprob = coidoAprob;
    }

    public double getTempRecomendada() {
        return tempRecomendada;
    }

    public void setTempRecomendada(double tempRecomendada) {
        this.tempRecomendada = tempRecomendada;
    }
}
