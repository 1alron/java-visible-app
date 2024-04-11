module com.example.javavisibleapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.javavisibleapp to javafx.fxml;
    exports com.example.javavisibleapp;
}