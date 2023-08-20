package Model;

import java.util.Objects;

public class Natural extends Cliente{
    private String email;
    private String fechaNacimiento;






    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    public Natural(){
        super();

    }
    public Natural(String nombre, String apellido, String identificacion, String telefono, String direccion,boolean esNatural, String email, String fechaNacimiento) {
        super(nombre, apellido, identificacion, telefono, direccion,esNatural);
        this.email=email;
        this.fechaNacimiento=fechaNacimiento;
    }
    @Override
    public  void imprimir() {
        System.out.println("Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                "es natural'=" + esNatural + '\'' +
                "email='" + email + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Natural natural)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getEmail(), natural.getEmail()) && Objects.equals(getFechaNacimiento(), natural.getFechaNacimiento());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getEmail(), getFechaNacimiento());
    }
}
