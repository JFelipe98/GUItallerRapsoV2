package co.edu.uniquindio.almacen.model;

public class ClienteJuridico extends Cliente {

    private String nit;

    public ClienteJuridico() {
        super();
    }

    public ClienteJuridico(String nombre, String id, String direccion,
                           String telefono, String nit) {
        super(nombre, id, direccion, telefono);
        this.nit = nit;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
}
