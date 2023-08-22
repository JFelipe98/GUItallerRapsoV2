module GUItallerRepasoV2 {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    exports com.example.guitallerRepasov2;

    opens com.example.guitallerRepasov2;
    opens Model;

}