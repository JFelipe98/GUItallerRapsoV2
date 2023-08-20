package Model;

public class Juridico extends Cliente{



    private String nit;
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    public Juridico(String nombre, String apellido, String identificacion, String telefono, String direccion, boolean esNatural, String nit) {
        super(nombre, apellido, identificacion, telefono, direccion, esNatural);
        this.nit = nit;
    }

    @Override
    public void imprimir(){
        System.out.println("Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", nit=' " + nit + '\'');
    }


}
