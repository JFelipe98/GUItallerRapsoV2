package com.example.guitallerRepasov2;

import javafx.application.Application;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class TextFieldInputDialogExample extends Application {
    @Override
    public void start(Stage primaryStage) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Input Dialog");
        dialog.setHeaderText("Enter Something:");
        dialog.setContentText("Input:");

        // Show the dialog and wait for user input
        dialog.showAndWait().ifPresent(result -> {
            // Process the user input
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("User Input");
            alert.setHeaderText("You entered:");
            alert.setContentText(result);
            alert.showAndWait();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
