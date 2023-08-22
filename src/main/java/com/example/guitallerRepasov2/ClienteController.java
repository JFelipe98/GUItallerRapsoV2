package com.example.guitallerRepasov2;

import Model.Cliente;
import Model.Juridico;
import Model.Natural;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import com.example.guitallerRepasov2.MainApplication;

public class ClienteController extends ActionEvent {



//Atributos de la interfaz gráfica
    public Button btn_Volver;
    public Label label_Email_Nit;
    public Label label_FechaNacimiento;
    public DatePicker dP_Fecha;
    public TextField tF_Email_Nit;
    public TableView<Cliente> tabla_Clientes;
    public TableColumn<Cliente, String> columnaNombre;
    public TableColumn<Cliente, String> columnaApellido;
    public TableColumn<Cliente, String> columnaIdentificacion;
    public TableColumn<Cliente, String> columnaTelefono;
    public TableColumn<Cliente, String> columnaDireccion;
    public TableColumn<Cliente, String> columnaNatural;
    //public TableColumn<Natural, String> columnaEmail;
    //public TableColumn<Natural, String> columnaFecha;
    //public TableColumn<Juridico,String> columnaNit;
  //Lista observable de elementos del comboBox tipo de cliente
    public ObservableList<String> tipoCliente = FXCollections.observableArrayList("--SELECCIONE--","Natural","Juridico");
    @FXML
    public AnchorPane registroClientes;
    public Label label_Nombre;
    public Label label_Telefono;
    public Label label_Apellido;
    public Label label_RegistroClientes;
    public Label label_Identificacion;
    public Label label_Direccion;
    public  TextField tF_Nombre;
    public TextField tF_Apellido;
    public TextField tF_Telefono;
    public TextField tF_Identificacion;
    public TextField tF_Direccion;
    public Button btn_Registrar;



    public  ComboBox<String> comboBox_TipoCliente = new ComboBox<>(tipoCliente);





    public Button btn_Actualizar;
    public Button btn_Eliminar;



//Método que inicializa parametros, tablas y condiciones de vista según la elección del comBox
    public  void initialize() {
/*
        Elementos de la tabla de clientes, debe llenarse columna a columna con los atributos
        del objeto en cuestión. En este caso es un objeto Cliente. el String al final es el nombre
        exacto del atributo en cuestión.
 */
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        columnaIdentificacion.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
        columnaTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        columnaDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        columnaNatural.setCellValueFactory(new PropertyValueFactory<>("esNatural"));
        //columnaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        //columnaFecha.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
        //columnaNit.setCellValueFactory(new PropertyValueFactory<>("nit"));
        //inicialización de la tabla con los objetos predeterminados
        tabla_Clientes.setItems(MainApplication.getClientes());


/*
Inicialización del comboBox, dependiendo de la acción, algunos elementos aparecen y desaparecen.
 */
        comboBox_TipoCliente.setItems(tipoCliente);
        comboBox_TipoCliente.setOnAction( event -> {
            String seleccion = comboBox_TipoCliente.getSelectionModel().getSelectedItem();
            if ("Natural".equals(seleccion)){
                label_Email_Nit.setText("Email");
                label_Email_Nit.setVisible(true);
                tF_Email_Nit.setVisible(true);
                label_FechaNacimiento.setVisible(true);
                dP_Fecha.setVisible(true);
            }
            else if("Juridico".equals(seleccion)){
                label_Email_Nit.setText("NIT");
                label_Email_Nit.setVisible(true);
                tF_Email_Nit.setVisible(true);
                label_FechaNacimiento.setVisible(false);
                dP_Fecha.setVisible(false);
                dP_Fecha.setValue(null);

            }
            else{
                label_Email_Nit.setVisible(false);
                tF_Email_Nit.setVisible(false);
                label_FechaNacimiento.setVisible(false);
                dP_Fecha.setVisible(false);
            }
        });




    }
/*
Método que registra los clientes.
Se captura la info en variables y dependiendo de la selección del comboBox
instancia un cliente natural o uno juridico y se llama a la función registrarClienteTabla()
del MainAplication.
(Se creó allí para la persistencia de datos mientras la app esté abierta).
La función lo que hace es enviar el cliente instanciado, lo agrega a la lista de observables y
retorna la lista para ser actualizada la tabla.
 */
    public void registrarCliente(){

        String nombre = this.tF_Nombre.getText();
        String apellido = this.tF_Apellido.getText();
        String identificacion = this.tF_Identificacion.getText();
        String telefono = this.tF_Telefono.getText();
        String direccion = this.tF_Direccion.getText();
        boolean esNatural=false;

        String email = this.tF_Email_Nit.getText();
        String fechaNacimiento= this.dP_Fecha.getValue()+"";
        String nit = tF_Email_Nit.getText();

        if ("Natural".equals(comboBox_TipoCliente.getSelectionModel().getSelectedItem())){
            esNatural=true;
            Natural c1 = new Natural(nombre,apellido,identificacion,telefono,direccion,esNatural,email,fechaNacimiento);

            tabla_Clientes.setItems(Cliente.registrarClienteTabla(c1));
            for (int i=0;i<MainApplication.getClientes().size();i++) {
                System.out.println(MainApplication.getClientes().get(i).getNombre());
            }
        } else if("--SELECCIONE--".equals(comboBox_TipoCliente.getSelectionModel().getSelectedItem())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Elija una opción");
            alert.showAndWait();}
        else{
            Juridico c= new Juridico(nombre,apellido,identificacion,telefono,direccion,esNatural,nit);

            tabla_Clientes.setItems(Cliente.registrarClienteTabla(c));
        }


    //Codigo que "limpia" las casillas para agregar un nuevo cliente

        tF_Nombre.clear();
        tF_Apellido.clear();
        tF_Identificacion.clear();
        tF_Telefono.clear();
        tF_Direccion.clear();
        tF_Email_Nit.clear();
        dP_Fecha.setValue(null);

        label_Email_Nit.setVisible(false);
        tF_Email_Nit.setVisible(false);
        label_FechaNacimiento.setVisible(false);
        dP_Fecha.setVisible(false);
        comboBox_TipoCliente.getSelectionModel().select(0);

    }
    /*
    Método que actualiza clientes.
    retorna la información de la tabla a las casillas del formulario para ser editadas, a su vez
    elimina el dato actual a la espera de un nuevo registro.
     */
    public void actualizarCliente(){
        Cliente clienteSeleccionado = tabla_Clientes.getSelectionModel().getSelectedItem();
        tF_Nombre.setText(clienteSeleccionado.nombre);
        tF_Apellido.setText(clienteSeleccionado.apellido);
        tF_Identificacion.setText(clienteSeleccionado.identificacion);
        tF_Telefono.setText(clienteSeleccionado.telefono);
        tF_Direccion.setText(clienteSeleccionado.direccion);
        if(clienteSeleccionado.esNatural=true){
            comboBox_TipoCliente.setValue("Natural");

        }
        else{
            comboBox_TipoCliente.setValue("Juridico");
        }
        Cliente.eliminarCliente(clienteSeleccionado);
        tabla_Clientes.refresh();
    }
    /*
    Método que elimina clientes.
    selecciona un cliente de la tabla y llama a una función del mainApplication (donde
    está la lista observable) y remueve el dato.
     */
    public void eliminarCliente(){
        Cliente clienteSeleccionado = tabla_Clientes.getSelectionModel().getSelectedItem();
        Cliente.eliminarCliente(clienteSeleccionado);
        for (int i=0;i<MainApplication.getClientes().size();i++) {
            System.out.println(MainApplication.getClientes().get(i).getNombre());
        }
        tabla_Clientes.refresh();
    }
/*
Método volver.
Cierra la ventana.
 */
    public void volver() {
        Stage stage = (Stage) this.btn_Volver.getScene().getWindow();
        stage.close();


    }

}