package Model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Juridico juridico)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getNit(), juridico.getNit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNit());
    }
}
