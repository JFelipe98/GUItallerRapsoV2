package com.example.guitallerRepasov2;

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

import java.net.URL;
import java.util.ResourceBundle;

public class ClienteController extends ActionEvent {




    public Button btn_Volver;
    public Label label_Email_Nit;
    public Label label_FechaNacimiento;
    public DatePicker dP_Fecha;
    public TextField tF_Email_Nit;
    public TableView<Natural> tabla_Clientes;
    public TableColumn<Natural, String> columnaNombre;
    public TableColumn<Natural, String> columnaApellido;
    public TableColumn<Natural, String> columnaIdentificacion;
    public TableColumn<Natural, String> columnaTelefono;
    public TableColumn<Natural, String> columnaDireccion;
    public TableColumn<Natural, String> columnaNatural;
    public TableColumn<Natural, String> columnaEmail;
    public TableColumn<Natural, String> columnaFecha;
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




    public Button btn_Leer;
    public Button btn_Actualizar;
    public Button btn_Eliminar;




    public  void initialize() {

        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        columnaIdentificacion.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
        columnaTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        columnaDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        columnaNatural.setCellValueFactory(new PropertyValueFactory<>("esNatural"));
        columnaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnaFecha.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
        tabla_Clientes.setItems(MainApplication.getClientes());



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

            }
            else{
                label_Email_Nit.setVisible(false);
                tF_Email_Nit.setVisible(false);
                label_FechaNacimiento.setVisible(false);
                dP_Fecha.setVisible(false);
            }
        });




    }

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
            MainApplication.registrarCliente(c1);
            tabla_Clientes.setItems(MainApplication.registrarClienteTabla(c1));
            tabla_Clientes.refresh();

        }
        else{
            Juridico c1= new Juridico(nombre,apellido,identificacion,telefono,direccion,esNatural,nit);
            MainApplication.registrarCliente(c1);
        }




         tF_Nombre.clear();
        tF_Apellido.clear();
        tF_Identificacion.clear();
        tF_Telefono.clear();
        tF_Direccion.clear();
        tF_Email_Nit.clear();

        label_Email_Nit.setVisible(false);
        tF_Email_Nit.setVisible(false);
        label_FechaNacimiento.setVisible(false);
        dP_Fecha.setVisible(false);
        comboBox_TipoCliente.getSelectionModel().select(0);

    }
    public void actualizarCliente(){

    }

    public void volver() {
        Stage stage = (Stage) this.btn_Volver.getScene().getWindow();
        stage.close();


    }

}