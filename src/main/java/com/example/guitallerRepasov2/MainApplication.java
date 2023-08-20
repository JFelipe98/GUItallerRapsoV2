package com.example.guitallerRepasov2;

import Model.Cliente;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MainApplication extends Application {
    private static ArrayList<Cliente> listaCliente;
    Cliente cPrueba = new Cliente("Naruto","Uzumaki","9876543210","3151234567", "Cra 24 #48-00");
    Cliente cPrueba2 = new Cliente("Harry","Potter","9876543210","3151234567", "Cra 24 #48-00");


    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
        listaCliente = new ArrayList<>();
        listaCliente.add(cPrueba);
        listaCliente.add(cPrueba2);




    }

    public static void main(String[] args) {

        launch();
    }
    public static void registrarCliente(Cliente c){

        listaCliente.add(c);
        for (int i=0;i<listaCliente.size();i++){
            listaCliente.get(i).imprimir();
        }
    }
}