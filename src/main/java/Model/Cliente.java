package Model;

import java.util.Objects;

public class Cliente {
    public String nombre;
    public String apellido;
    public String identificacion;



    public boolean esNatural;

    public String telefono;
    public String direccion;
    public Cliente(String nombre, String apellido, String identificacion, String telefono, String direccion, boolean esNatural) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.direccion = direccion;
        this.esNatural=esNatural;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public boolean getEsNatural() {
        return esNatural;
    }

    public void setEsNatural(boolean esNatural) {
        this.esNatural = esNatural;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return getEsNatural() == cliente.getEsNatural() && Objects.equals(getNombre(), cliente.getNombre()) && Objects.equals(getApellido(), cliente.getApellido()) && Objects.equals(getIdentificacion(), cliente.getIdentificacion()) && Objects.equals(getTelefono(), cliente.getTelefono()) && Objects.equals(getDireccion(), cliente.getDireccion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getApellido(), getIdentificacion(), getEsNatural(), getTelefono(), getDireccion());
    }

    public  void imprimir() {
      /*
        System.out.println("Cliente{" +
        "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' );
    }
       */
    }
}
