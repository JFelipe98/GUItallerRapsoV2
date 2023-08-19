package co.edu.uniquindio.almacen.model;
import java.util.Calendar;
public class ClienteNatural extends Cliente{

    private String email;
    private Calendar fechaNaci;

    public ClienteNatural() {
        super();
    }

    public ClienteNatural(String nombre, String id, String direccion, String telefono,
                          String email, Calendar fechaNaci) {
        super(nombre, id, direccion, telefono);
        this.email = email;
        this.fechaNaci = fechaNaci;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calendar getFechaNaci() {
        return fechaNaci;
    }

    public void setFechaNaci(Calendar fechaNaci) {
        this.fechaNaci = fechaNaci;
    }

}
